package net.theblindbandit6.seasonaladditions.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.*;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class SingleStackWithCountRecipe implements Recipe<SingleStackRecipeInput> {

    private final String group;
    private final Ingredient ingredient;
    private final int inputCount;
    private final ItemStack result;
    @Nullable
    private IngredientPlacement ingredientPlacement;

    public SingleStackWithCountRecipe(String group, Ingredient ingredient, int inputCount, ItemStack result) {
        this.group = group;
        this.ingredient = ingredient;
        this.inputCount = inputCount;
        this.result = result;
    }

    @Override
    public abstract RecipeSerializer<? extends SingleStackWithCountRecipe> getSerializer();

    @Override
    public abstract RecipeType<? extends SingleStackWithCountRecipe> getType();

    public boolean matches(SingleStackRecipeInput singleStackRecipeInput, World world) {
        return this.ingredient.test(singleStackRecipeInput.item());
    }

    @Override
    public String getGroup() {
        return this.group;
    }

    public Ingredient ingredient() {
        return this.ingredient;
    }

    public int inputCount() {
        return this.inputCount;
    }

    protected ItemStack result() {
        return this.result;
    }

    @Override
    public IngredientPlacement getIngredientPlacement() {
        if (this.ingredientPlacement == null) {
            this.ingredientPlacement = IngredientPlacement.forSingleSlot(this.ingredient);
        }

        return this.ingredientPlacement;
    }

    public ItemStack craft(SingleStackRecipeInput singleStackRecipeInput, RegistryWrapper.WrapperLookup wrapperLookup) {
        return this.result.copy();
    }

    @FunctionalInterface
    public interface RecipeFactory<T extends SingleStackWithCountRecipe> {
        T create(String group, Ingredient ingredient, int inputCount, ItemStack result);
    }

    public static class Serializer<T extends SingleStackWithCountRecipe> implements RecipeSerializer<T> {
        private final MapCodec<T> codec;
        private final PacketCodec<RegistryByteBuf, T> packetCodec;

        protected Serializer(SingleStackWithCountRecipe.RecipeFactory<T> recipeFactory) {
            this.codec = RecordCodecBuilder.mapCodec(
                    instance -> instance.group(
                                    Codec.STRING.optionalFieldOf("group", "").forGetter(SingleStackWithCountRecipe::getGroup),
                                    Ingredient.CODEC.fieldOf("ingredient").forGetter(SingleStackWithCountRecipe::ingredient),
                                    Codec.INT.fieldOf("inputCount").forGetter(SingleStackWithCountRecipe::inputCount),
                                    ItemStack.VALIDATED_CODEC.fieldOf("result").forGetter(SingleStackWithCountRecipe::result)
                            )
                            .apply(instance, recipeFactory::create)
            );
            this.packetCodec = PacketCodec.tuple(
                    PacketCodecs.STRING,
                    SingleStackWithCountRecipe::getGroup,
                    Ingredient.PACKET_CODEC,
                    SingleStackWithCountRecipe::ingredient,
                    PacketCodecs.INTEGER,
                    SingleStackWithCountRecipe::inputCount,
                    ItemStack.PACKET_CODEC,
                    SingleStackWithCountRecipe::result,
                    recipeFactory::create
            );
        }

        @Override
        public MapCodec<T> codec() {
            return this.codec;
        }

        @Override
        public PacketCodec<RegistryByteBuf, T> packetCodec() {
            return this.packetCodec;
        }
    }
}
