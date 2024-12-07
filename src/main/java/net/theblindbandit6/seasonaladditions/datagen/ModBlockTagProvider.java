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
                //Ice
                .add(ModBlocks.ICE_SLAB)
                .add(ModBlocks.ICE_STAIRS)
                .add(ModBlocks.ICE_WALL)
                //Packed Ice
                .add(ModBlocks.PACKED_ICE_SLAB)
                .add(ModBlocks.PACKED_ICE_STAIRS)
                .add(ModBlocks.PACKED_ICE_WALL)
                //Blue Ice
                .add(ModBlocks.BLUE_ICE_SLAB)
                .add(ModBlocks.BLUE_ICE_STAIRS)
                .add(ModBlocks.BLUE_ICE_WALL)
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
                .add(ModBlocks.POLISHED_ICE_SLAB)
                .add(ModBlocks.POLISHED_ICE_STAIRS)
                .add(ModBlocks.POLISHED_ICE_WALL)
                //Chiseled Ice Bricks
                .add(ModBlocks.CHISELED_ICE_BRICKS)
                //Frosted Glowstone
                .add(ModBlocks.FROSTED_GLOWSTONE)
                //Candy Cane Blocks
                .add(ModBlocks.RED_CANDY_CANE_BLOCK)
                .add(ModBlocks.RED_CANDY_CANE_SLAB)
                .add(ModBlocks.RED_CANDY_CANE_STAIRS)
                .add(ModBlocks.GREEN_CANDY_CANE_BLOCK)
                .add(ModBlocks.GREEN_CANDY_CANE_SLAB)
                .add(ModBlocks.GREEN_CANDY_CANE_STAIRS);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                //Snow
                .add(ModBlocks.SNOW_SLAB)
                .add(ModBlocks.SNOW_STAIRS)
                .add(ModBlocks.SNOW_WALL);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.ICE_SLAB)
                .add(ModBlocks.PACKED_ICE_SLAB)
                .add(ModBlocks.BLUE_ICE_SLAB)
                .add(ModBlocks.SNOW_SLAB)
                .add(ModBlocks.SMALL_ICE_BRICKS_SLAB)
                .add(ModBlocks.LARGE_ICE_BRICKS_SLAB)
                .add(ModBlocks.POLISHED_ICE_SLAB)
                .add(ModBlocks.RED_CANDY_CANE_SLAB)
                .add(ModBlocks.GREEN_CANDY_CANE_SLAB);

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.ICE_STAIRS)
                .add(ModBlocks.PACKED_ICE_STAIRS)
                .add(ModBlocks.BLUE_ICE_STAIRS)
                .add(ModBlocks.SNOW_STAIRS)
                .add(ModBlocks.SMALL_ICE_BRICKS_STAIRS)
                .add(ModBlocks.LARGE_ICE_BRICKS_STAIRS)
                .add(ModBlocks.POLISHED_ICE_STAIRS)
                .add(ModBlocks.RED_CANDY_CANE_STAIRS)
                .add(ModBlocks.GREEN_CANDY_CANE_STAIRS);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.ICE_WALL)
                .add(ModBlocks.PACKED_ICE_WALL)
                .add(ModBlocks.BLUE_ICE_WALL)
                .add(ModBlocks.SNOW_WALL)
                .add(ModBlocks.SMALL_ICE_BRICKS_WALL)
                .add(ModBlocks.LARGE_ICE_BRICKS_WALL)
                .add(ModBlocks.POLISHED_ICE_WALL);
    }
}
