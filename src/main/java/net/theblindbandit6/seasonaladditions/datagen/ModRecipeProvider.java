package net.theblindbandit6.seasonaladditions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.theblindbandit6.seasonaladditions.item.ModItems;
import net.theblindbandit6.seasonaladditions.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICECUTTER)
                    .pattern(" R ")
                    .pattern("RSR")
                    .input('R', Blocks.PACKED_ICE)
                    .input('S', Blocks.STONECUTTER)
                    .criterion(hasItem(Blocks.PACKED_ICE), conditionsFromItem(Blocks.PACKED_ICE))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FROSTED_GLOWSTONE)
                        .pattern("RR")
                        .pattern("RR")
                        .input('R', ModItems.FROSTED_GLOWSTONE_DUST)
                        .criterion(hasItem(ModItems.FROSTED_GLOWSTONE_DUST), conditionsFromItem(ModItems.FROSTED_GLOWSTONE_DUST))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BREWING, ModItems.FROSTED_GLOWSTONE_DUST, 8)
                        .pattern("RRR")
                        .pattern("RGR")
                        .pattern("RRR")
                        .input('G', Blocks.PACKED_ICE)
                        .input('R', Items.GLOWSTONE_DUST)
                        .criterion(hasItem(Blocks.PACKED_ICE), conditionsFromItem(Blocks.PACKED_ICE))
                        .offerTo(exporter);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMALL_ICE_BRICKS, Blocks.PACKED_ICE, 4);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LARGE_ICE_BRICKS, Blocks.PACKED_ICE, 4);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE, Blocks.PACKED_ICE, 4);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.PACKED_ICE, Blocks.BLUE_ICE, 9);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.ICE, Blocks.PACKED_ICE, 9);
            }
        };
    }

    @Override
    public String getName() {
        return "Seasonal Additions Recipes";
    }
}
