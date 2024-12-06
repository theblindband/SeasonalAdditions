package net.theblindbandit6.seasonaladditions.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.util.Identifier;
import net.theblindbandit6.seasonaladditions.item.ModItems;
import net.theblindbandit6.seasonaladditions.block.ModBlocks;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //Small Ice Bricks
        generateStoneSet(blockStateModelGenerator, ModBlocks.SMALL_ICE_BRICKS,
                ModBlocks.SMALL_ICE_BRICKS_SLAB,ModBlocks.SMALL_ICE_BRICKS_STAIRS,ModBlocks.SMALL_ICE_BRICKS_WALL);
        //Large Ice Bricks
        generateStoneSet(blockStateModelGenerator, ModBlocks.LARGE_ICE_BRICKS,
                ModBlocks.LARGE_ICE_BRICKS_SLAB,ModBlocks.LARGE_ICE_BRICKS_STAIRS,ModBlocks.LARGE_ICE_BRICKS_WALL);
        //Polished Ice
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.POLISHED_ICE);
        //Frosted Glowstone
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FROSTED_GLOWSTONE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //Frosted Glowstone
        itemModelGenerator.register(ModItems.FROSTED_GLOWSTONE_DUST, Models.GENERATED);
    }

    public void generateStoneSet(BlockStateModelGenerator blockStateModelGenerator, Block base, Block slab, Block stairs, Block wall){
        BlockStateModelGenerator.BlockTexturePool blockTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(base);
        blockTexturePool.slab(slab);
        blockTexturePool.stairs(stairs);
        blockTexturePool.wall(wall);
    }
}
