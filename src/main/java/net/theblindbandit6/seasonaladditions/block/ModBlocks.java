package net.theblindbandit6.seasonaladditions.block;

import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.theblindbandit6.seasonaladditions.SeasonalAdditions;
import net.theblindbandit6.seasonaladditions.block.custom.FairyLightsBlock;
import net.theblindbandit6.seasonaladditions.block.custom.IcecutterBlock;
import net.theblindbandit6.seasonaladditions.block.custom.PeppermintBushBlock;

public class ModBlocks {
    //Winter Blocks
    //Icecutter
    public static final Block ICECUTTER = registerBlock("icecutter", new IcecutterBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "icecutter"))).mapColor(MapColor.STONE_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(3.5F)));
    //Ice
    public static final Block ICE_SLAB = registerBlock("ice_slab", new SlabBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "ice_slab"))).mapColor(MapColor.PALE_PURPLE).slipperiness(0.98F).ticksRandomly().strength(0.5F).sounds(BlockSoundGroup.GLASS).nonOpaque().allowsSpawning((state, world, pos, entityType) -> entityType == EntityType.POLAR_BEAR).solidBlock(Blocks::never)));
    public static final Block ICE_STAIRS = registerBlock("ice_stairs", new StairsBlock(Blocks.ICE.getDefaultState(), AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "ice_stairs"))).mapColor(MapColor.PALE_PURPLE).slipperiness(0.98F).ticksRandomly().strength(0.5F).sounds(BlockSoundGroup.GLASS).nonOpaque().allowsSpawning((state, world, pos, entityType) -> entityType == EntityType.POLAR_BEAR).solidBlock(Blocks::never)));
    public static final Block ICE_WALL = registerBlock("ice_wall", new WallBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "ice_wall"))).mapColor(MapColor.PALE_PURPLE).slipperiness(0.98F).ticksRandomly().strength(0.5F).sounds(BlockSoundGroup.GLASS).nonOpaque().allowsSpawning((state, world, pos, entityType) -> entityType == EntityType.POLAR_BEAR).solidBlock(Blocks::never)));
    //Packed Ice
    public static final Block PACKED_ICE_SLAB = registerBlock("packed_ice_slab", new SlabBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "packed_ice_slab"))).mapColor(MapColor.PALE_PURPLE).instrument(NoteBlockInstrument.CHIME).slipperiness(0.98F).strength(0.5F).sounds(BlockSoundGroup.GLASS)));
    public static final Block PACKED_ICE_STAIRS = registerBlock("packed_ice_stairs", new StairsBlock(Blocks.PACKED_ICE.getDefaultState(), AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "packed_ice_stairs"))).mapColor(MapColor.PALE_PURPLE).instrument(NoteBlockInstrument.CHIME).slipperiness(0.98F).strength(0.5F).sounds(BlockSoundGroup.GLASS)));
    public static final Block PACKED_ICE_WALL = registerBlock("packed_ice_wall", new WallBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "packed_ice_wall"))).mapColor(MapColor.PALE_PURPLE).instrument(NoteBlockInstrument.CHIME).slipperiness(0.98F).strength(0.5F).sounds(BlockSoundGroup.GLASS)));
    //Blue Ice
    public static final Block BLUE_ICE_SLAB = registerBlock("blue_ice_slab", new SlabBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "blue_ice_slab"))).mapColor(MapColor.PALE_PURPLE).strength(2.8F).slipperiness(0.989F).sounds(BlockSoundGroup.GLASS)));
    public static final Block BLUE_ICE_STAIRS = registerBlock("blue_ice_stairs", new StairsBlock(Blocks.BLUE_ICE.getDefaultState(), AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "blue_ice_stairs"))).mapColor(MapColor.PALE_PURPLE).strength(2.8F).slipperiness(0.989F).sounds(BlockSoundGroup.GLASS)));
    public static final Block BLUE_ICE_WALL = registerBlock("blue_ice_wall", new WallBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "blue_ice_wall"))).mapColor(MapColor.PALE_PURPLE).strength(2.8F).slipperiness(0.989F).sounds(BlockSoundGroup.GLASS)));
    //Snow
    public static final Block SNOW_SLAB = registerBlock("snow_slab", new SlabBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "snow_slab"))).mapColor(MapColor.WHITE).strength(0.2F).sounds(BlockSoundGroup.SNOW)));
    public static final Block SNOW_STAIRS = registerBlock("snow_stairs", new StairsBlock(Blocks.SNOW_BLOCK.getDefaultState(), AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "snow_stairs"))).mapColor(MapColor.WHITE).strength(0.2F).sounds(BlockSoundGroup.SNOW)));
    public static final Block SNOW_WALL = registerBlock("snow_wall", new WallBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "snow_wall"))).mapColor(MapColor.WHITE).strength(0.2F).sounds(BlockSoundGroup.SNOW)));
    //Small Ice Bricks
    public static final Block SMALL_ICE_BRICKS = registerBlock("small_ice_bricks", new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "small_ice_bricks"))).mapColor(MapColor.LIGHT_BLUE).instrument(NoteBlockInstrument.CHIME).strength(2.0F, 6.0F).sounds(BlockSoundGroup.GLASS).requiresTool().slipperiness(0.98F)));
    public static final Block SMALL_ICE_BRICKS_SLAB = registerBlock("small_ice_bricks_slab", new SlabBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "small_ice_bricks_slab"))).mapColor(MapColor.LIGHT_BLUE).instrument(NoteBlockInstrument.CHIME).strength(2.0F, 6.0F).sounds(BlockSoundGroup.GLASS).requiresTool().slipperiness(0.98F)));
    public static final Block SMALL_ICE_BRICKS_STAIRS = registerBlock("small_ice_bricks_stairs", new StairsBlock(SMALL_ICE_BRICKS.getDefaultState(), AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "small_ice_bricks_stairs"))).mapColor(MapColor.LIGHT_BLUE).instrument(NoteBlockInstrument.CHIME).strength(2.0F, 6.0F).sounds(BlockSoundGroup.GLASS).requiresTool().slipperiness(0.98F)));
    public static final Block SMALL_ICE_BRICKS_WALL = registerBlock("small_ice_bricks_wall", new WallBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "small_ice_bricks_wall"))).mapColor(MapColor.LIGHT_BLUE).instrument(NoteBlockInstrument.CHIME).strength(2.0F, 6.0F).sounds(BlockSoundGroup.GLASS).requiresTool().slipperiness(0.98F)));
    //Large Ice Bricks
    public static final Block LARGE_ICE_BRICKS = registerBlock("large_ice_bricks", new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "large_ice_bricks"))).mapColor(MapColor.LIGHT_BLUE).instrument(NoteBlockInstrument.CHIME).strength(2.0F, 6.0F).sounds(BlockSoundGroup.GLASS).requiresTool().slipperiness(0.98F)));
    public static final Block LARGE_ICE_BRICKS_SLAB = registerBlock("large_ice_bricks_slab", new SlabBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "large_ice_bricks_slab"))).mapColor(MapColor.LIGHT_BLUE).instrument(NoteBlockInstrument.CHIME).strength(2.0F, 6.0F).sounds(BlockSoundGroup.GLASS).requiresTool().slipperiness(0.98F)));
    public static final Block LARGE_ICE_BRICKS_STAIRS = registerBlock("large_ice_bricks_stairs", new StairsBlock(LARGE_ICE_BRICKS.getDefaultState(), AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "large_ice_bricks_stairs"))).mapColor(MapColor.LIGHT_BLUE).instrument(NoteBlockInstrument.CHIME).strength(2.0F, 6.0F).sounds(BlockSoundGroup.GLASS).requiresTool().slipperiness(0.98F)));
    public static final Block LARGE_ICE_BRICKS_WALL = registerBlock("large_ice_bricks_wall", new WallBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "large_ice_bricks_wall"))).mapColor(MapColor.LIGHT_BLUE).instrument(NoteBlockInstrument.CHIME).strength(2.0F, 6.0F).sounds(BlockSoundGroup.GLASS).requiresTool().slipperiness(0.98F)));
    //Polished Ice
    public static final Block POLISHED_ICE = registerBlock("polished_ice", new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "polished_ice"))).mapColor(MapColor.LIGHT_BLUE).instrument(NoteBlockInstrument.CHIME).strength(2.0F, 6.0F).sounds(BlockSoundGroup.GLASS).requiresTool().slipperiness(0.98F)));
    public static final Block POLISHED_ICE_SLAB = registerBlock("polished_ice_slab", new SlabBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "polished_ice_slab"))).mapColor(MapColor.LIGHT_BLUE).instrument(NoteBlockInstrument.CHIME).strength(2.0F, 6.0F).sounds(BlockSoundGroup.GLASS).requiresTool().slipperiness(0.98F)));
    public static final Block POLISHED_ICE_STAIRS = registerBlock("polished_ice_stairs", new StairsBlock(POLISHED_ICE.getDefaultState(), AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "polished_ice_stairs"))).mapColor(MapColor.LIGHT_BLUE).instrument(NoteBlockInstrument.CHIME).strength(2.0F, 6.0F).sounds(BlockSoundGroup.GLASS).requiresTool().slipperiness(0.98F)));
    public static final Block POLISHED_ICE_WALL = registerBlock("polished_ice_wall", new WallBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "polished_ice_wall"))).mapColor(MapColor.LIGHT_BLUE).instrument(NoteBlockInstrument.CHIME).strength(2.0F, 6.0F).sounds(BlockSoundGroup.GLASS).requiresTool().slipperiness(0.98F)));
    //Chiseled Ice
    public static final Block CHISELED_ICE_BRICKS = registerBlock("chiseled_ice_bricks", new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "chiseled_ice_bricks"))).mapColor(MapColor.LIGHT_BLUE).instrument(NoteBlockInstrument.CHIME).strength(2.0F, 6.0F).sounds(BlockSoundGroup.GLASS).requiresTool().slipperiness(0.98F)));
    //Frosted Glowstone
    public static final Block FROSTED_GLOWSTONE = registerBlock("frosted_glowstone", new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "frosted_glowstone"))).mapColor(MapColor.LIGHT_BLUE_GRAY).instrument(NoteBlockInstrument.PLING).strength(0.3F).sounds(BlockSoundGroup.GLASS).luminance(state -> 15).solidBlock(Blocks::never).slipperiness(0.98F)));
    //Candy Cane Blocks
    public static final Block RED_CANDY_CANE_BLOCK = registerBlock("red_candy_cane_block", new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "red_candy_cane_block"))).mapColor(MapColor.WHITE).instrument(NoteBlockInstrument.XYLOPHONE).requiresTool().strength(2.0F).sounds(BlockSoundGroup.BONE)));
    public static final Block RED_CANDY_CANE_SLAB = registerBlock("red_candy_cane_slab", new SlabBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "red_candy_cane_slab"))).mapColor(MapColor.WHITE).instrument(NoteBlockInstrument.XYLOPHONE).requiresTool().strength(2.0F).sounds(BlockSoundGroup.BONE)));
    public static final Block RED_CANDY_CANE_STAIRS = registerBlock("red_candy_cane_stairs", new StairsBlock(RED_CANDY_CANE_BLOCK.getDefaultState(), AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "red_candy_cane_stairs"))).mapColor(MapColor.WHITE).instrument(NoteBlockInstrument.XYLOPHONE).requiresTool().strength(2.0F).sounds(BlockSoundGroup.BONE)));
    public static final Block GREEN_CANDY_CANE_BLOCK = registerBlock("green_candy_cane_block", new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "green_candy_cane_block"))).mapColor(MapColor.WHITE).instrument(NoteBlockInstrument.XYLOPHONE).requiresTool().strength(2.0F).sounds(BlockSoundGroup.BONE)));
    public static final Block GREEN_CANDY_CANE_SLAB = registerBlock("green_candy_cane_slab", new SlabBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "green_candy_cane_slab"))).mapColor(MapColor.WHITE).instrument(NoteBlockInstrument.XYLOPHONE).requiresTool().strength(2.0F).sounds(BlockSoundGroup.BONE)));
    public static final Block GREEN_CANDY_CANE_STAIRS = registerBlock("green_candy_cane_stairs", new StairsBlock(GREEN_CANDY_CANE_BLOCK.getDefaultState(), AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "green_candy_cane_stairs"))).mapColor(MapColor.WHITE).instrument(NoteBlockInstrument.XYLOPHONE).requiresTool().strength(2.0F).sounds(BlockSoundGroup.BONE)));
    //Peppermint
    public static final Block PEPPERMINT_BUSH = registerBlockWithoutBlockItem("peppermint_bush", new PeppermintBushBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "peppermint_bush"))).mapColor(MapColor.DARK_GREEN).ticksRandomly().noCollision().sounds(BlockSoundGroup.SWEET_BERRY_BUSH).pistonBehavior(PistonBehavior.DESTROY)));
    //Fairy Lights
    public static final Block GREEN_FAIRY_LIGHTS = registerBlock("green_fairy_lights", new FairyLightsBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "green_fairy_lights"))).luminance(state -> 10).noCollision().breakInstantly().sounds(BlockSoundGroup.AMETHYST_BLOCK).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block RED_FAIRY_LIGHTS = registerBlock("red_fairy_lights", new FairyLightsBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "red_fairy_lights"))).luminance(state -> 10).noCollision().breakInstantly().sounds(BlockSoundGroup.AMETHYST_BLOCK).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block WHITE_FAIRY_LIGHTS = registerBlock("white_fairy_lights", new FairyLightsBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "white_fairy_lights"))).luminance(state -> 10).noCollision().breakInstantly().sounds(BlockSoundGroup.AMETHYST_BLOCK).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block FESTIVE_FAIRY_LIGHTS = registerBlock("festive_fairy_lights", new FairyLightsBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SeasonalAdditions.MOD_ID, "festive_fairy_lights"))).luminance(state -> 10).noCollision().breakInstantly().sounds(BlockSoundGroup.AMETHYST_BLOCK).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));

    //Additional Winter themed blocks:
    //Fairy Lights
    //Baubles
    //Snowglobe
    //Presents
    //Christmas Pudding
    //Mistletoe
    //Poinsettia
    //Stocking

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

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(SeasonalAdditions.MOD_ID, name), block);
    }

    public static void registerModBlocks() {

    }
}
