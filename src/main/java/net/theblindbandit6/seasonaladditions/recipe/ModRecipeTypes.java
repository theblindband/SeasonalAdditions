package net.theblindbandit6.seasonaladditions.recipe;

import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

import static net.theblindbandit6.seasonaladditions.SeasonalAdditions.MOD_ID;

public class ModRecipeTypes  {

    public static RecipeType<IcecuttingRecipe> ICECUTTING = register("icecutting");

    public static void registerRecipeTypes() {
    }

    private static <T extends Recipe<?>> RecipeType<T> register(String id) {
        return Registry.register(Registries.RECIPE_TYPE, Identifier.of(MOD_ID, id), new RecipeType<T>() {
            public String toString() {
                return id;
            }
        });
    }
}
