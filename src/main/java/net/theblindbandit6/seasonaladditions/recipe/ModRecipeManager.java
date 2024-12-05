package net.theblindbandit6.seasonaladditions.recipe;

import net.minecraft.recipe.RecipePropertySet;
import net.minecraft.recipe.StonecuttingRecipe;
import net.minecraft.recipe.display.CuttingRecipeDisplay;
import net.minecraft.registry.RegistryKey;

public interface ModRecipeManager {
    RecipePropertySet getPropertySet(RegistryKey<RecipePropertySet> key);

    static CuttingRecipeDisplay.Grouping<IcecuttingRecipe> getIcecutterRecipes() {
        return null;
    }
}
