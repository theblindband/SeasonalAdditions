package net.theblindbandit6.seasonaladditions.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.SlabType;
import net.minecraft.client.data.*;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.theblindbandit6.seasonaladditions.block.custom.PeppermintBushBlock;
import net.theblindbandit6.seasonaladditions.item.ModItems;
import net.theblindbandit6.seasonaladditions.block.ModBlocks;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //Generators that are commented out have been moved from the generated folder into the resources folder
        //Vanilla Textures
        //Ice
        generateSlabStairWall(blockStateModelGenerator, Blocks.ICE,
                ModBlocks.ICE_SLAB,ModBlocks.ICE_STAIRS,ModBlocks.ICE_WALL);
        //Packed Ice
        generateSlabStairWall(blockStateModelGenerator, Blocks.PACKED_ICE,
               ModBlocks.PACKED_ICE_SLAB,ModBlocks.PACKED_ICE_STAIRS,ModBlocks.PACKED_ICE_WALL);
        //Blue Ice
        generateSlabStairWall(blockStateModelGenerator, Blocks.BLUE_ICE,
                ModBlocks.BLUE_ICE_SLAB,ModBlocks.BLUE_ICE_STAIRS,ModBlocks.BLUE_ICE_WALL);
        //Snow
        generateSlabStairWall(blockStateModelGenerator, Blocks.SNOW_BLOCK,
                ModBlocks.SNOW_SLAB,ModBlocks.SNOW_STAIRS,ModBlocks.SNOW_WALL);

        //Modded Textures
        //Small Ice Bricks
        generateSlabStairWall(blockStateModelGenerator, ModBlocks.SMALL_ICE_BRICKS,
                ModBlocks.SMALL_ICE_BRICKS_SLAB,ModBlocks.SMALL_ICE_BRICKS_STAIRS,ModBlocks.SMALL_ICE_BRICKS_WALL);
        //Large Ice Bricks
        generateSlabStairWall(blockStateModelGenerator, ModBlocks.LARGE_ICE_BRICKS,
                ModBlocks.LARGE_ICE_BRICKS_SLAB,ModBlocks.LARGE_ICE_BRICKS_STAIRS,ModBlocks.LARGE_ICE_BRICKS_WALL);
        //Polished Ice
        generateSlabStairWall(blockStateModelGenerator, ModBlocks.POLISHED_ICE,
                ModBlocks.POLISHED_ICE_SLAB,ModBlocks.POLISHED_ICE_STAIRS,ModBlocks.POLISHED_ICE_WALL);
        //Chiseled Ice Bricks
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_ICE_BRICKS);
        //Frosted Glowstone
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FROSTED_GLOWSTONE);
        //Candy Cane Blocks
        generateSlabStair(blockStateModelGenerator, ModBlocks.RED_CANDY_CANE_BLOCK,
                ModBlocks.RED_CANDY_CANE_SLAB,ModBlocks.RED_CANDY_CANE_STAIRS);
        generateSlabStair(blockStateModelGenerator, ModBlocks.GREEN_CANDY_CANE_BLOCK,
                ModBlocks.GREEN_CANDY_CANE_SLAB,ModBlocks.GREEN_CANDY_CANE_STAIRS);
        //Peppermint
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.PEPPERMINT_BUSH, BlockStateModelGenerator.CrossType.NOT_TINTED,
                PeppermintBushBlock.AGE, 0, 1, 2, 3);
        //Fairy Lights
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.RED_FAIRY_LIGHTS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.GREEN_FAIRY_LIGHTS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.WHITE_FAIRY_LIGHTS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.YELLOW_FAIRY_LIGHTS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.BLUE_FAIRY_LIGHTS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.FESTIVE_FAIRY_LIGHTS);
        //Poinsettia
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.POINSETTIA, ModBlocks.POTTED_POINSETTIA, BlockStateModelGenerator.CrossType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //Frosted Glowstone Dust
        itemModelGenerator.register(ModItems.FROSTED_GLOWSTONE_DUST, Models.GENERATED);
        //Candy Cane
        itemModelGenerator.register(ModItems.CANDY_CANE, Models.GENERATED);
        //Banner Patterns
        itemModelGenerator.register(ModItems.PRESENT_BANNER_PATTERN, Models.GENERATED);
    }

    public void generateSlabStair(BlockStateModelGenerator blockStateModelGenerator, Block base, Block slab, Block stairs){
        BlockStateModelGenerator.BlockTexturePool blockTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(base);
        blockTexturePool.slab(slab);
        blockTexturePool.stairs(stairs);
    }
    public void generateSlabStairWall(BlockStateModelGenerator blockStateModelGenerator, Block base, Block slab, Block stairs, Block wall){
        BlockStateModelGenerator.BlockTexturePool blockTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(base);
        blockTexturePool.slab(slab);
        blockTexturePool.stairs(stairs);
        blockTexturePool.wall(wall);
    }
}

