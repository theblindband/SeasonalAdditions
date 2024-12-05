package net.theblindbandit6.seasonaladditions.recipe;

import com.mojang.serialization.MapCodec;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.theblindbandit6.seasonaladditions.SeasonalAdditions;

public interface ModRecipeSerializer<T extends Recipe<?>> {
    net.minecraft.recipe.RecipeSerializer<IcecuttingRecipe> ICECUTTING = register(SeasonalAdditions.MOD_ID + "icecutting",
            new ModSingleStackRecipe.Serializer<>(IcecuttingRecipe::new));

    MapCodec<T> codec();

    /**
     * {@return the packet codec for serializing recipes over the network}
     *
     * @deprecated {@link Recipe} is no longer synced to the clients, making this
     * obsolete.
     *
     * @see RecipeDisplayEntry
     */
    @Deprecated
    PacketCodec<RegistryByteBuf, T> packetCodec();

    static <S extends net.minecraft.recipe.RecipeSerializer<T>, T extends Recipe<?>> S register(String id, S serializer) {
        return Registry.register(Registries.RECIPE_SERIALIZER, id, serializer);
    }
}
