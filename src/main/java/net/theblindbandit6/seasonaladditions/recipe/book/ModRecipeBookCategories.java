package net.theblindbandit6.seasonaladditions.recipe.book;

import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.minecraft.recipe.book.RecipeBookCategories.CAMPFIRE;
import static net.theblindbandit6.seasonaladditions.SeasonalAdditions.MOD_ID;

public class ModRecipeBookCategories {

    public static final RecipeBookCategory ICECUTTER = register("icecutter");

    public static void registerRecipeBookCategories() {
    }

    private static RecipeBookCategory register(String path) {
        return Registry.register(Registries.RECIPE_BOOK_CATEGORY, Identifier.of(MOD_ID, path), new RecipeBookCategory());
    }
}
