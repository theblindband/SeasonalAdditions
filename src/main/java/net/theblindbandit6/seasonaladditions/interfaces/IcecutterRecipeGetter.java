package net.theblindbandit6.seasonaladditions.interfaces;

import net.theblindbandit6.seasonaladditions.recipe.display.IcecuttingRecipeDisplay;

public interface IcecutterRecipeGetter {

    default IcecuttingRecipeDisplay.Grouping seasonalAdditions$getIcecutterRecipeForSync() {
        return IcecuttingRecipeDisplay.Grouping.empty();
    }

    default IcecuttingRecipeDisplay.Grouping seasonalAdditions$getIcecutterRecipes() {
        return IcecuttingRecipeDisplay.Grouping.empty();
    }
}
