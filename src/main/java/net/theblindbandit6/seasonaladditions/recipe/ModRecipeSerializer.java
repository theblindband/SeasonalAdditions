package net.theblindbandit6.seasonaladditions.recipe;

import net.minecraft.recipe.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

import static net.theblindbandit6.seasonaladditions.SeasonalAdditions.MOD_ID;

public class ModRecipeSerializer {

    public static RecipeSerializer<IcecuttingRecipe> ICECUTTING = register("icecutting", new SingleStackWithCountRecipe.Serializer<>(IcecuttingRecipe::new));

    public static void registerRecipeSerializer() {
    }

    private static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String path, S serializer) {
        return Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(MOD_ID, path), serializer);
    }
}
