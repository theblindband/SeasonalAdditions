package net.theblindbandit6.seasonaladditions;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.potion.Potions;
import net.theblindbandit6.seasonaladditions.block.ModBlocks;
import net.theblindbandit6.seasonaladditions.item.ModItemGroups;
import net.theblindbandit6.seasonaladditions.item.ModItems;
import net.theblindbandit6.seasonaladditions.potion.ModPotions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeasonalAdditions implements ModInitializer {
	public static final String MOD_ID = "seasonaladditions";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Initializing Seasonal Additions.");
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModItemGroups.registerItemGroups();
		ModPotions.registerPotions();

		//Potion Brewing
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, ModItems.FROSTED_GLOWSTONE_DUST, ModPotions.FROSTED_POTION);
		});
	}
}