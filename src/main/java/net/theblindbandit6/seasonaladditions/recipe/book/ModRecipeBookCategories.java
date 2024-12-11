package net.theblindbandit6.seasonaladditions.recipe.book;

import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static net.minecraft.recipe.book.RecipeBookCategories.CAMPFIRE;

public class ModRecipeBookCategories {
    public static final RecipeBookCategory ICECUTTER = register("icecutter");


    private static RecipeBookCategory register(String id) {
        return Registry.register(Registries.RECIPE_BOOK_CATEGORY, id, new RecipeBookCategory());
    }

    public static RecipeBookCategory registerAndGetDefault(Registry<RecipeBookCategory> registry) {
        return CAMPFIRE;
    }
}
