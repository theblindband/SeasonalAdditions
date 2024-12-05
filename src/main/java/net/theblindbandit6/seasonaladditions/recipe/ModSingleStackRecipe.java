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

public abstract class ModSingleStackRecipe implements Recipe<SingleStackRecipeInput> {
    private final Ingredient ingredient;
    private final ItemStack result;
    private final String group;
    @Nullable
    private IngredientPlacement ingredientPlacement;

    public ModSingleStackRecipe(String group, Ingredient ingredient, ItemStack result) {
        this.group = group;
        this.ingredient = ingredient;
        this.result = result;
    }

    @Override
    public abstract RecipeSerializer<? extends net.theblindbandit6.seasonaladditions.recipe.ModSingleStackRecipe> getSerializer();

    @Override
    public abstract RecipeType<? extends net.theblindbandit6.seasonaladditions.recipe.ModSingleStackRecipe> getType();

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
    public interface RecipeFactory<T extends net.theblindbandit6.seasonaladditions.recipe.ModSingleStackRecipe> {
        T create(String group, Ingredient ingredient, ItemStack result);
    }

    public static class Serializer<T extends net.theblindbandit6.seasonaladditions.recipe.ModSingleStackRecipe> implements RecipeSerializer<T> {
        private final MapCodec<T> codec;
        private final PacketCodec<RegistryByteBuf, T> packetCodec;

        protected Serializer(net.theblindbandit6.seasonaladditions.recipe.ModSingleStackRecipe.RecipeFactory<T> recipeFactory) {
            this.codec = RecordCodecBuilder.mapCodec(
                    instance -> instance.group(
                                    Codec.STRING.optionalFieldOf("group", "").forGetter(net.theblindbandit6.seasonaladditions.recipe.ModSingleStackRecipe::getGroup),
                                    Ingredient.CODEC.fieldOf("ingredient").forGetter(net.theblindbandit6.seasonaladditions.recipe.ModSingleStackRecipe::ingredient),
                                    ItemStack.VALIDATED_CODEC.fieldOf("result").forGetter(net.theblindbandit6.seasonaladditions.recipe.ModSingleStackRecipe::result)
                            )
                            .apply(instance, recipeFactory::create)
            );
            this.packetCodec = PacketCodec.tuple(
                    PacketCodecs.STRING,
                    net.theblindbandit6.seasonaladditions.recipe.ModSingleStackRecipe::getGroup,
                    Ingredient.PACKET_CODEC,
                    net.theblindbandit6.seasonaladditions.recipe.ModSingleStackRecipe::ingredient,
                    ItemStack.PACKET_CODEC,
                    net.theblindbandit6.seasonaladditions.recipe.ModSingleStackRecipe::result,
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
