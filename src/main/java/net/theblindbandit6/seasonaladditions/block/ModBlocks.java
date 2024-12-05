package net.theblindbandit6.seasonaladditions.block;

import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.theblindbandit6.seasonaladditions.SeasonalAdditions;

public class ModBlocks {
    //Mod Blocks
    public static final Block FROSTED_GLOWSTONE = registerBlock("frosted_glowstone",
            new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SeasonalAdditions.MOD_ID, "frosted_glowstone")))
                    .mapColor(MapColor.LIGHT_BLUE_GRAY)
                    .instrument(NoteBlockInstrument.PLING)
                    .strength(0.3F)
                    .sounds(BlockSoundGroup.GLASS)
                    .luminance(state -> 15)
                    .solidBlock(Blocks::never)));

    //Block Register Methods
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(SeasonalAdditions.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(SeasonalAdditions.MOD_ID, name),
                new BlockItem(block, new Item.Settings()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SeasonalAdditions.MOD_ID, name))).useBlockPrefixedTranslationKey()));
    }

    public static void registerModBlocks() {

    }
}
