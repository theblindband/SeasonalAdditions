package net.theblindbandit6.seasonaladditions.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
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
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SMALL_ICE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LARGE_ICE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.POLISHED_ICE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FROSTED_GLOWSTONE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.FROSTED_GLOWSTONE_DUST, Models.GENERATED);
    }
}
