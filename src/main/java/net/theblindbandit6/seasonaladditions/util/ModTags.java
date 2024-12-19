package net.theblindbandit6.seasonaladditions.util;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BannerPattern;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.theblindbandit6.seasonaladditions.SeasonalAdditions;

public class ModTags  {
    public static class Blocks {

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(SeasonalAdditions.MOD_ID, name));
        }
    }

    public static class Items {
        //public static final TagKey<Item> EXAMPLE = createTag("example");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(SeasonalAdditions.MOD_ID, name));
        }
    }

    public static class BannerPatterns {
        public static final TagKey<BannerPattern> PRESENT_PATTERN_ITEM = createTag("pattern_item/present");

        private static TagKey<BannerPattern> createTag(String name) {
            return TagKey.of(RegistryKeys.BANNER_PATTERN, Identifier.of(SeasonalAdditions.MOD_ID, name));
        }
    }
}
