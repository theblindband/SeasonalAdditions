package net.theblindbandit6.seasonaladditions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.theblindbandit6.seasonaladditions.block.ModBlocks;
import net.theblindbandit6.seasonaladditions.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.PARROT_POISONOUS_FOOD)
                .add(ModItems.CANDY_CANE);

        getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS)
                .add(ModBlocks.POINSETTIA.asItem());

        getOrCreateTagBuilder(ItemTags.SLABS)
                .add(ModBlocks.ICE_SLAB.asItem())
                .add(ModBlocks.PACKED_ICE_SLAB.asItem())
                .add(ModBlocks.BLUE_ICE_SLAB.asItem())
                .add(ModBlocks.SNOW_SLAB.asItem())
                .add(ModBlocks.SMALL_ICE_BRICKS_SLAB.asItem())
                .add(ModBlocks.LARGE_ICE_BRICKS_SLAB.asItem())
                .add(ModBlocks.POLISHED_ICE_SLAB.asItem())
                .add(ModBlocks.RED_CANDY_CANE_SLAB.asItem())
                .add(ModBlocks.GREEN_CANDY_CANE_SLAB.asItem());

        getOrCreateTagBuilder(ItemTags.STAIRS)
                .add(ModBlocks.ICE_STAIRS.asItem())
                .add(ModBlocks.PACKED_ICE_STAIRS.asItem())
                .add(ModBlocks.BLUE_ICE_STAIRS.asItem())
                .add(ModBlocks.SNOW_STAIRS.asItem())
                .add(ModBlocks.SMALL_ICE_BRICKS_STAIRS.asItem())
                .add(ModBlocks.LARGE_ICE_BRICKS_STAIRS.asItem())
                .add(ModBlocks.POLISHED_ICE_STAIRS.asItem())
                .add(ModBlocks.RED_CANDY_CANE_STAIRS.asItem())
                .add(ModBlocks.GREEN_CANDY_CANE_STAIRS.asItem());

        getOrCreateTagBuilder(ItemTags.WALLS)
                .add(ModBlocks.ICE_WALL.asItem())
                .add(ModBlocks.PACKED_ICE_WALL.asItem())
                .add(ModBlocks.BLUE_ICE_WALL.asItem())
                .add(ModBlocks.SNOW_WALL.asItem())
                .add(ModBlocks.SMALL_ICE_BRICKS_WALL.asItem())
                .add(ModBlocks.LARGE_ICE_BRICKS_WALL.asItem())
                .add(ModBlocks.POLISHED_ICE_WALL.asItem());
    }
}
