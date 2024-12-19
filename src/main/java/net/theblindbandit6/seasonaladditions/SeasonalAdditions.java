package net.theblindbandit6.seasonaladditions;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.theblindbandit6.seasonaladditions.block.ModBlocks;
import net.theblindbandit6.seasonaladditions.item.ModItemGroups;
import net.theblindbandit6.seasonaladditions.item.ModItems;
import net.theblindbandit6.seasonaladditions.potion.ModPotions;
import net.theblindbandit6.seasonaladditions.recipe.ModRecipeSerializer;
import net.theblindbandit6.seasonaladditions.recipe.ModRecipeTypes;
import net.theblindbandit6.seasonaladditions.recipe.book.ModRecipeBookCategories;
import net.theblindbandit6.seasonaladditions.recipe.display.ModRecipeDisplays;
import net.theblindbandit6.seasonaladditions.screen.IcecutterScreenHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;

public class SeasonalAdditions implements ModInitializer {
	public static final String MOD_ID = "seasonaladditions";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final ScreenHandlerType<IcecutterScreenHandler> ICECUTTER_SCREEN_HANDLER =
			SeasonalAdditions.registerScreenHandlerType(MOD_ID, IcecutterScreenHandler::new);

	public static Identifier identifier(final String resourceName) {
		return Identifier.of(MOD_ID, resourceName);
	}

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Seasonal Additions.");
		Calendar calendar = Calendar.getInstance();
		if (calendar.get(2) + 1 == 12 && calendar.get(5) == 25) {
			SeasonalAdditions.LOGGER.info("Merry Christmas!");
		}
		if (calendar.get(2) + 1 == 12 && calendar.get(5) == 31) {
			SeasonalAdditions.LOGGER.info("Happy New Year!");
		}
		if (calendar.get(2) + 1 == 1 && calendar.get(5) == 1) {
			SeasonalAdditions.LOGGER.info("Happy New Year!");
		}

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModPotions.registerPotions();

		ModRecipeTypes.registerRecipeTypes();
		ModRecipeSerializer.registerRecipeSerializer();
		ModRecipeBookCategories.registerRecipeBookCategories();
		ModRecipeDisplays.registerRecipeDisplays();

		//Potion Brewing
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, ModItems.FROSTED_GLOWSTONE_DUST, ModPotions.FROSTED_POTION);
		});
	}

	private static <T extends ScreenHandler> ScreenHandlerType<T> registerScreenHandlerType(String id, ScreenHandlerType.Factory<T> factory) {
		return Registry.register(Registries.SCREEN_HANDLER, id, new ScreenHandlerType<>(factory, FeatureFlags.VANILLA_FEATURES));
	}

	private static <T extends ScreenHandler, D extends ScreenHandler & PacketCodec<? super RegistryByteBuf, D>> ExtendedScreenHandlerType<T, D> registerExtendedScreenHandlerType(
			String id,
			ExtendedScreenHandlerType.ExtendedFactory<T, D> factory,
			D data
	) {
		return Registry.register(
				Registries.SCREEN_HANDLER,
				Identifier.of(SeasonalAdditions.MOD_ID, id),
				new ExtendedScreenHandlerType<>(factory, data)
		);
	}
}