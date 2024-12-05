package net.theblindbandit6.seasonaladditions;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeasonalAdditions implements ModInitializer {
	public static final String MOD_ID = "seasonaladditions";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Seasonal Additions.");
	}
}