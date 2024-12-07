package net.theblindbandit6.seasonaladditions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
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
                //Icecutter
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICECUTTER)
                    .pattern("R")
                    .pattern("S")
                    .input('R', Blocks.BLUE_ICE)
                    .input('S', Blocks.STONECUTTER)
                    .criterion(hasItem(Blocks.BLUE_ICE), conditionsFromItem(Blocks.BLUE_ICE))
                    .offerTo(exporter);
                //Snow
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SNOW_SLAB, Ingredient.ofItem(Blocks.SNOW_BLOCK))
                        .criterion(hasItem(Blocks.SNOW_BLOCK), conditionsFromItem(Blocks.SNOW_BLOCK))
                        .offerTo(exporter);
                createStairsRecipe(ModBlocks.SNOW_STAIRS, Ingredient.ofItem(Blocks.SNOW_BLOCK))
                        .criterion(hasItem(Blocks.SNOW_BLOCK), conditionsFromItem(Blocks.SNOW_BLOCK))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SNOW_WALL, 6)
                        .pattern("RRR")
                        .pattern("RRR")
                        .input('R', Blocks.SNOW_BLOCK)
                        .criterion(hasItem(Blocks.SNOW_BLOCK), conditionsFromItem(Blocks.SNOW_BLOCK))
                        .offerTo(exporter);
                //Frosted Glowstone
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
                //Candy Cane
                createShapeless(RecipeCategory.MISC, ModItems.CANDY_CANE, 4)
                        .input(ModItems.PEPPERMINT)
                        .input(Items.SUGAR)
                        .input(Items.RED_DYE)
                        .input(Items.RESIN_CLUMP)
                        .criterion(hasItem(ModItems.PEPPERMINT), conditionsFromItem(ModItems.PEPPERMINT))
                        .offerTo(exporter);
                createCondensingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_CANDY_CANE_BLOCK, Ingredient.ofItem(ModItems.CANDY_CANE))
                        .criterion(hasItem(ModItems.CANDY_CANE), conditionsFromItem(ModItems.CANDY_CANE))
                        .offerTo(exporter);
                createStairsRecipe(ModBlocks.RED_CANDY_CANE_STAIRS, Ingredient.ofItem(ModBlocks.RED_CANDY_CANE_BLOCK))
                        .criterion(hasItem(ModBlocks.RED_CANDY_CANE_BLOCK), conditionsFromItem(ModBlocks.RED_CANDY_CANE_BLOCK))
                        .offerTo(exporter);
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_CANDY_CANE_SLAB, Ingredient.ofItem(ModBlocks.RED_CANDY_CANE_BLOCK))
                        .criterion(hasItem(ModBlocks.RED_CANDY_CANE_BLOCK), conditionsFromItem(ModBlocks.RED_CANDY_CANE_BLOCK))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_CANDY_CANE_BLOCK, 8)
                        .pattern("RRR")
                        .pattern("RGR")
                        .pattern("RRR")
                        .input('G', Items.LIME_DYE)
                        .input('R', ModBlocks.RED_CANDY_CANE_BLOCK)
                        .criterion(hasItem(ModBlocks.RED_CANDY_CANE_BLOCK), conditionsFromItem(ModBlocks.RED_CANDY_CANE_BLOCK))
                        .offerTo(exporter);
                createStairsRecipe(ModBlocks.GREEN_CANDY_CANE_STAIRS, Ingredient.ofItem(ModBlocks.GREEN_CANDY_CANE_BLOCK))
                        .criterion(hasItem(ModBlocks.GREEN_CANDY_CANE_BLOCK), conditionsFromItem(ModBlocks.GREEN_CANDY_CANE_BLOCK))
                        .offerTo(exporter);
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_CANDY_CANE_SLAB, Ingredient.ofItem(ModBlocks.GREEN_CANDY_CANE_BLOCK))
                        .criterion(hasItem(ModBlocks.GREEN_CANDY_CANE_BLOCK), conditionsFromItem(ModBlocks.GREEN_CANDY_CANE_BLOCK))
                        .offerTo(exporter);
                //Fairy Lights
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_FAIRY_LIGHTS, 16).group("fairy_lights")
                        .pattern("XXX")
                        .pattern("GGG")
                        .pattern("RRR")
                        .input('R', Items.LIME_DYE)
                        .input('G', Items.GLOWSTONE_DUST)
                        .input('X', Items.REDSTONE)
                        .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_FAIRY_LIGHTS, 16).group("fairy_lights")
                        .pattern("XXX")
                        .pattern("GGG")
                        .pattern("RRR")
                        .input('R', Items.RED_DYE)
                        .input('G', Items.GLOWSTONE_DUST)
                        .input('X', Items.REDSTONE)
                        .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHITE_FAIRY_LIGHTS, 16).group("fairy_lights")
                        .pattern("XXX")
                        .pattern("GGG")
                        .pattern("RRR")
                        .input('R', Items.WHITE_DYE)
                        .input('G', Items.GLOWSTONE_DUST)
                        .input('X', Items.REDSTONE)
                        .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FESTIVE_FAIRY_LIGHTS, 16).group("fairy_lights")
                        .pattern("XXX")
                        .pattern("GGG")
                        .pattern("RTY")
                        .input('R', Items.WHITE_DYE)
                        .input('T', Items.RED_DYE)
                        .input('Y', Items.LIME_DYE)
                        .input('G', Items.GLOWSTONE_DUST)
                        .input('X', Items.REDSTONE)
                        .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                        .offerTo(exporter);
                //Stonecutting
                //Ice
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_SLAB, Blocks.ICE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_STAIRS, Blocks.ICE, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_WALL, Blocks.ICE, 1);
                //Packed Ice
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_SLAB, Blocks.PACKED_ICE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_STAIRS, Blocks.PACKED_ICE, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_WALL, Blocks.PACKED_ICE, 1);
                //Blue Ice
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_ICE_SLAB, Blocks.BLUE_ICE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_ICE_STAIRS, Blocks.BLUE_ICE, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_ICE_WALL, Blocks.BLUE_ICE, 1);
                //Small Ice Bricks
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMALL_ICE_BRICKS, Blocks.PACKED_ICE, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMALL_ICE_BRICKS_SLAB, ModBlocks.SMALL_ICE_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMALL_ICE_BRICKS_STAIRS, ModBlocks.SMALL_ICE_BRICKS, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMALL_ICE_BRICKS_WALL, ModBlocks.SMALL_ICE_BRICKS, 1);
                //Large Ice Bricks
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LARGE_ICE_BRICKS, Blocks.PACKED_ICE, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LARGE_ICE_BRICKS_SLAB, ModBlocks.LARGE_ICE_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LARGE_ICE_BRICKS_STAIRS, ModBlocks.LARGE_ICE_BRICKS, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LARGE_ICE_BRICKS_WALL, ModBlocks.LARGE_ICE_BRICKS, 1);
                //Polished Ice
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE, Blocks.PACKED_ICE, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE_SLAB, ModBlocks.POLISHED_ICE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE_STAIRS, ModBlocks.POLISHED_ICE, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE_WALL, ModBlocks.POLISHED_ICE, 1);
                //Chiseled Ice Bricks
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_ICE_BRICKS, Blocks.PACKED_ICE, 1);
                //Ice Unpacking With Stonecutter
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
