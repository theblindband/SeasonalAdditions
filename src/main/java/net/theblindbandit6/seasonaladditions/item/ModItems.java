package net.theblindbandit6.seasonaladditions.item;

import net.minecraft.item.BannerPatternItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.theblindbandit6.seasonaladditions.SeasonalAdditions;
import net.theblindbandit6.seasonaladditions.block.ModBlocks;
import net.theblindbandit6.seasonaladditions.util.ModTags;

public class ModItems {
    //Winter Items
    //Frosted Glowstone Dust
    public static final Item FROSTED_GLOWSTONE_DUST = registerItem("frosted_glowstone_dust",new Item(new Item.Settings()));
    //Candy Cane
    public static final Item CANDY_CANE = registerItem("candy_cane",new Item(new Item.Settings()
            .food(ModFoodComponents.CANDY_CANE)));
    //Peppermint
    public static final Item PEPPERMINT = registerItem("peppermint",new BlockItem(ModBlocks.PEPPERMINT_BUSH, new Item.Settings()));
    //Banner Patterns
    public static final Item PRESENT_BANNER_PATTERN = registerItem("present_banner_pattern",new BannerPatternItem(ModTags.BannerPatterns.PRESENT_PATTERN_ITEM, new Item.Settings()));

    //Item Register Methods
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SeasonalAdditions.MOD_ID, name), item);
    }

    public static void registerModItems() {

    }
}