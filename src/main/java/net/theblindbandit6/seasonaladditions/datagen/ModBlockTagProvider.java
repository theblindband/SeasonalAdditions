package net.theblindbandit6.seasonaladditions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.theblindbandit6.seasonaladditions.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                //Icecutter
                .add(ModBlocks.ICECUTTER)
                //Small Ice Bricks
                .add(ModBlocks.SMALL_ICE_BRICKS)
                .add(ModBlocks.SMALL_ICE_BRICKS_SLAB)
                .add(ModBlocks.SMALL_ICE_BRICKS_STAIRS)
                .add(ModBlocks.SMALL_ICE_BRICKS_WALL)
                //Large Ice Bricks
                .add(ModBlocks.LARGE_ICE_BRICKS)
                .add(ModBlocks.LARGE_ICE_BRICKS_SLAB)
                .add(ModBlocks.LARGE_ICE_BRICKS_STAIRS)
                .add(ModBlocks.LARGE_ICE_BRICKS_WALL)
                //Polished Ice
                .add(ModBlocks.POLISHED_ICE)
                //Frosted Glowstone
                .add(ModBlocks.FROSTED_GLOWSTONE);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.SMALL_ICE_BRICKS_SLAB)
                .add(ModBlocks.LARGE_ICE_BRICKS_SLAB);

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.SMALL_ICE_BRICKS_STAIRS)
                .add(ModBlocks.LARGE_ICE_BRICKS_STAIRS);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.SMALL_ICE_BRICKS_WALL)
                .add(ModBlocks.LARGE_ICE_BRICKS_WALL);
    }
}
