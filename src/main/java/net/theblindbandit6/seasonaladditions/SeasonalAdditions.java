package net.theblindbandit6.seasonaladditions;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.theblindbandit6.seasonaladditions.block.ModBlocks;
import net.theblindbandit6.seasonaladditions.item.ModItemGroups;
import net.theblindbandit6.seasonaladditions.item.ModItems;
import net.theblindbandit6.seasonaladditions.potion.ModPotions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;

public class SeasonalAdditions implements ModInitializer {
	public static final String MOD_ID = "seasonaladditions";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier identifier(final String resourceName) {
		return Identifier.of(MOD_ID, resourceName);
	}

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Seasonal Additions.");
		Calendar calendar = Calendar.getInstance();
		if(calendar.get(2) + 1 == 12 && calendar.get(5) == 9){
			SeasonalAdditions.LOGGER.info("Merry Christmas!");
		}if(calendar.get(2) + 1 == 12 && calendar.get(5) == 31){
			SeasonalAdditions.LOGGER.info("Happy New Year!");
		}if(calendar.get(2) + 1 == 1 && calendar.get(5) == 1){
			SeasonalAdditions.LOGGER.info("Happy New Year!");
		}

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