package net.theblindbandit6.seasonaladditions.client.recipebook;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.theblindbandit6.seasonaladditions.recipe.display.IcecuttingRecipeDisplay;

@Environment(EnvType.CLIENT)
public class ClientModRecipeManager {

    private final IcecuttingRecipeDisplay.Grouping icecuttingRecipes;

    public ClientModRecipeManager(IcecuttingRecipeDisplay.Grouping woodcuttingRecipes) {
        this.icecuttingRecipes = woodcuttingRecipes;
    }

    public IcecuttingRecipeDisplay.Grouping getIcecutterRecipes() {
        return this.icecuttingRecipes;
    }
}
