package net.theblindbandit6.seasonaladditions.interfaces;

import net.theblindbandit6.seasonaladditions.client.recipebook.ClientModRecipeManager;
import net.theblindbandit6.seasonaladditions.recipe.display.IcecuttingRecipeDisplay;

public interface ModRecipeManagerGetter {

    default ClientModRecipeManager seasonalAdditions$getModRecipeManager() {
        return new ClientModRecipeManager(IcecuttingRecipeDisplay.Grouping.empty());
    }
}
