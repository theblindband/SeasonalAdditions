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
import net.theblindbandit6.seasonaladditions.block.custom.IcecutterBlock;

public class ModBlocks {
    //Winter Blocks
    //Icecutter
    public static final Block ICECUTTER = registerBlock("icecutter",
            new IcecutterBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SeasonalAdditions.MOD_ID, "icecutter")))
                    .mapColor(MapColor.STONE_GRAY).instrument(NoteBlockInstrument.BASEDRUM).strength(3.5F).requiresTool()));
    //Small Ice Bricks
    public static final Block SMALL_ICE_BRICKS = registerBlock("small_ice_bricks",
            new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SeasonalAdditions.MOD_ID, "small_ice_bricks")))
                    .mapColor(MapColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 6.0F).sounds(BlockSoundGroup.GLASS).requiresTool().slipperiness(0.98F)));
    public static final Block SMALL_ICE_BRICKS_SLAB = registerBlock("small_ice_bricks_slab",
            new SlabBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SeasonalAdditions.MOD_ID, "small_ice_bricks_slab")))
                    .mapColor(MapColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 6.0F).sounds(BlockSoundGroup.GLASS).requiresTool().slipperiness(0.98F)));
    public static final Block SMALL_ICE_BRICKS_STAIRS = registerBlock("small_ice_bricks_stairs",
            new StairsBlock(SMALL_ICE_BRICKS.getDefaultState(), AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SeasonalAdditions.MOD_ID, "small_ice_bricks_stairs")))
                    .mapColor(MapColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 6.0F).sounds(BlockSoundGroup.GLASS).requiresTool().slipperiness(0.98F)));
    public static final Block SMALL_ICE_BRICKS_WALL = registerBlock("small_ice_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SeasonalAdditions.MOD_ID, "small_ice_bricks_wall")))
                    .mapColor(MapColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 6.0F).sounds(BlockSoundGroup.GLASS).requiresTool().slipperiness(0.98F)));
    //Large Ice Bricks
    public static final Block LARGE_ICE_BRICKS = registerBlock("large_ice_bricks",
            new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SeasonalAdditions.MOD_ID, "large_ice_bricks")))
                    .mapColor(MapColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 6.0F).sounds(BlockSoundGroup.GLASS).requiresTool().slipperiness(0.98F)));
    public static final Block LARGE_ICE_BRICKS_SLAB = registerBlock("large_ice_bricks_slab",
            new SlabBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SeasonalAdditions.MOD_ID, "large_ice_bricks_slab")))
                    .mapColor(MapColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 6.0F).sounds(BlockSoundGroup.GLASS).requiresTool().slipperiness(0.98F)));
    public static final Block LARGE_ICE_BRICKS_STAIRS = registerBlock("large_ice_bricks_stairs",
            new StairsBlock(LARGE_ICE_BRICKS.getDefaultState(), AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SeasonalAdditions.MOD_ID, "large_ice_bricks_stairs")))
                    .mapColor(MapColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 6.0F).sounds(BlockSoundGroup.GLASS).requiresTool().slipperiness(0.98F)));
    public static final Block LARGE_ICE_BRICKS_WALL = registerBlock("large_ice_bricks_wall",
            new WallBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SeasonalAdditions.MOD_ID, "large_ice_bricks_wall")))
                    .mapColor(MapColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 6.0F).sounds(BlockSoundGroup.GLASS).requiresTool().slipperiness(0.98F)));
    //Polished Ice
    public static final Block POLISHED_ICE = registerBlock("polished_ice",
            new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SeasonalAdditions.MOD_ID, "polished_ice")))
                    .mapColor(MapColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 6.0F).sounds(BlockSoundGroup.GLASS).requiresTool().slipperiness(0.98F)));

    //Icecutter blocks to add:
    //Slab, Stair and Wall variants for existing ice and modded variants.
    //Blue Ice Variants
    //Tiles and Chisled Variants

    //Frosted Glowstone
    public static final Block FROSTED_GLOWSTONE = registerBlock("frosted_glowstone",
            new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SeasonalAdditions.MOD_ID, "frosted_glowstone")))
                    .mapColor(MapColor.LIGHT_BLUE_GRAY).instrument(NoteBlockInstrument.PLING).strength(0.3F).sounds(BlockSoundGroup.GLASS).luminance(state -> 15).solidBlock(Blocks::never).slipperiness(0.98F)));
    //Additional Winter themed blocks:
    //Candy cane blocks
    //Snow Blocks
    //Baubles
    //Fairy Lights
    //Snowglobe
    //Presents

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
