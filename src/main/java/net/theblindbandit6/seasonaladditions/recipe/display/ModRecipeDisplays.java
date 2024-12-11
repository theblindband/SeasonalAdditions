package net.theblindbandit6.seasonaladditions.recipe.display;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModRecipeDisplays {

    public static void registerRecipeDisplays() {

        Registry.register(Registries.RECIPE_DISPLAY, "icecutter", IcecutterRecipeDisplay.SERIALIZER);
    }
}
