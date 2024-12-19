package net.theblindbandit6.seasonaladditions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
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
        return new ModRecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                //Icecutter
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICECUTTER)
                    .pattern(" S ")
                    .pattern("XRX")
                    .input('R', Blocks.BLUE_ICE)
                    .input('S', Items.IRON_INGOT)
                    .input('X', Blocks.STONE)
                    .criterion(hasItem(Blocks.BLUE_ICE), conditionsFromItem(Blocks.BLUE_ICE))
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
                createFairyLightRecipe(ModBlocks.RED_FAIRY_LIGHTS, Items.RED_DYE);
                createFairyLightRecipe(ModBlocks.GREEN_FAIRY_LIGHTS, Items.GREEN_DYE);
                createFairyLightRecipe(ModBlocks.WHITE_FAIRY_LIGHTS, Items.WHITE_DYE);
                createFairyLightRecipe(ModBlocks.YELLOW_FAIRY_LIGHTS, Items.YELLOW_DYE);
                createFairyLightRecipe(ModBlocks.BLUE_FAIRY_LIGHTS, Items.BLUE_DYE);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FESTIVE_FAIRY_LIGHTS, 16).group("fairy_lights")
                        .pattern("XCX")
                        .pattern("GGG")
                        .pattern("RTY")
                        .input('R', Items.WHITE_DYE)
                        .input('T', Items.RED_DYE)
                        .input('Y', Items.LIME_DYE)
                        .input('G', Items.GLOWSTONE_DUST)
                        .input('X', Items.REDSTONE)
                        .input('C', Items.COPPER_INGOT)
                        .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                        .offerTo(exporter);
                //Poinsettia
                createShapeless(RecipeCategory.MISC,Items.RED_DYE)
                        .input(ModBlocks.POINSETTIA)
                        .criterion("has_poinsettia", this.conditionsFromItem(ModBlocks.POINSETTIA))
                        .offerTo(this.exporter);
                //Banner Patterns
                createShapeless(RecipeCategory.MISC,ModItems.PRESENT_BANNER_PATTERN)
                        .input(Items.PAPER)
                        .input(Blocks.CHEST)
                        .criterion("has_chest", this.conditionsFromItem(Blocks.CHEST))
                        .offerTo(this.exporter);

                //Crafting Recipes - Added since the icecutter doesn't work in a server currently
                createStairsSlabWallRecipes(Blocks.ICE, ModBlocks.ICE_STAIRS, ModBlocks.ICE_SLAB, ModBlocks.ICE_WALL, "ice");
                createSmallSquare(ModBlocks.SMALL_ICE_BRICKS, Blocks.ICE);
                createSmallSquare(ModBlocks.LARGE_ICE_BRICKS, ModBlocks.SMALL_ICE_BRICKS);
                createSmallSquare(ModBlocks.POLISHED_ICE, ModBlocks.LARGE_ICE_BRICKS);
                createSmallSquare(ModBlocks.CHISELED_ICE_BRICKS, ModBlocks.POLISHED_ICE);
                createStairsSlabWallRecipes(Blocks.PACKED_ICE, ModBlocks.PACKED_ICE_STAIRS, ModBlocks.PACKED_ICE_SLAB, ModBlocks.PACKED_ICE_WALL, "ice");
                createStairsSlabWallRecipes(Blocks.BLUE_ICE, ModBlocks.BLUE_ICE_STAIRS, ModBlocks.BLUE_ICE_SLAB, ModBlocks.BLUE_ICE_WALL, "ice");
                createStairsSlabWallRecipes(ModBlocks.SMALL_ICE_BRICKS, ModBlocks.SMALL_ICE_BRICKS_STAIRS, ModBlocks.SMALL_ICE_BRICKS_SLAB, ModBlocks.SMALL_ICE_BRICKS_WALL, "ice");
                createStairsSlabWallRecipes(ModBlocks.LARGE_ICE_BRICKS, ModBlocks.LARGE_ICE_BRICKS_STAIRS, ModBlocks.LARGE_ICE_BRICKS_SLAB, ModBlocks.LARGE_ICE_BRICKS_WALL, "ice");
                createStairsSlabWallRecipes(ModBlocks.POLISHED_ICE, ModBlocks.POLISHED_ICE_STAIRS, ModBlocks.POLISHED_ICE_SLAB, ModBlocks.POLISHED_ICE_WALL, "ice");
                createStairsSlabWallRecipes(Blocks.SNOW_BLOCK, ModBlocks.SNOW_STAIRS, ModBlocks.SNOW_SLAB, ModBlocks.SNOW_WALL, "snow");
                //Icecutting
                //Ice
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_SLAB, Blocks.ICE, 2);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_STAIRS, Blocks.ICE);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_WALL, Blocks.ICE);
                //Packed Ice
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_SLAB, Blocks.PACKED_ICE, 2);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_STAIRS, Blocks.PACKED_ICE);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_WALL, Blocks.PACKED_ICE);
                //Blue Ice
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_ICE_SLAB, Blocks.BLUE_ICE, 2);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_ICE_STAIRS, Blocks.BLUE_ICE);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_ICE_WALL, Blocks.BLUE_ICE);
                //Snow
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.SNOW, Blocks.SNOW_BLOCK, 2);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SNOW_SLAB, Blocks.SNOW_BLOCK, 2);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SNOW_STAIRS, Blocks.SNOW_BLOCK);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SNOW_WALL, Blocks.SNOW_BLOCK);
                //Small Ice Bricks
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMALL_ICE_BRICKS, Blocks.ICE);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMALL_ICE_BRICKS_SLAB, Blocks.ICE, 2);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMALL_ICE_BRICKS_STAIRS, Blocks.ICE);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMALL_ICE_BRICKS_WALL, Blocks.ICE);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMALL_ICE_BRICKS_SLAB, ModBlocks.SMALL_ICE_BRICKS, 2);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMALL_ICE_BRICKS_STAIRS, ModBlocks.SMALL_ICE_BRICKS);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMALL_ICE_BRICKS_WALL, ModBlocks.SMALL_ICE_BRICKS);
                //Large Ice Bricks
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LARGE_ICE_BRICKS, Blocks.ICE);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LARGE_ICE_BRICKS_SLAB, Blocks.ICE, 2);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LARGE_ICE_BRICKS_STAIRS, Blocks.ICE);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LARGE_ICE_BRICKS_WALL, Blocks.ICE);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LARGE_ICE_BRICKS_SLAB, ModBlocks.LARGE_ICE_BRICKS, 2);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LARGE_ICE_BRICKS_STAIRS, ModBlocks.LARGE_ICE_BRICKS);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LARGE_ICE_BRICKS_WALL, ModBlocks.LARGE_ICE_BRICKS);
                //Polished Ice
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE, Blocks.ICE);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE_SLAB, Blocks.ICE, 2);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE_STAIRS, Blocks.ICE);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE_WALL, Blocks.ICE);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE_SLAB, ModBlocks.POLISHED_ICE, 2);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE_STAIRS, ModBlocks.POLISHED_ICE);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE_WALL, ModBlocks.POLISHED_ICE);
                //Chiseled Ice Bricks
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_ICE_BRICKS, Blocks.ICE);
                //Ice Unpacking With Icecutter
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.PACKED_ICE, Blocks.BLUE_ICE, 9);
                createIcecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, Blocks.ICE, Blocks.PACKED_ICE, 9);
            }

            public void createFairyLightRecipe(ItemConvertible fairyLights, ItemConvertible color){
                createShaped(RecipeCategory.BUILDING_BLOCKS, fairyLights, 16).group("fairy_lights")
                        .pattern("XCX")
                        .pattern("GGG")
                        .pattern("RRR")
                        .input('R', color)
                        .input('G', Items.GLOWSTONE_DUST)
                        .input('X', Items.REDSTONE)
                        .input('C', Items.COPPER_INGOT)
                        .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                        .offerTo(exporter);
            }
            public void createStairsSlabWallRecipes(ItemConvertible input, ItemConvertible stair, ItemConvertible slab, ItemConvertible wall, String group){
                createShaped(RecipeCategory.BUILDING_BLOCKS, stair, 6).group(group + "_stairs")
                        .pattern("R  ")
                        .pattern("RR ")
                        .pattern("RRR")
                        .input('R', input)
                        .criterion(hasItem(input), conditionsFromItem(input))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, slab, 6).group(group + "_slabs")
                        .pattern("RRR")
                        .input('R', input)
                        .criterion(hasItem(input), conditionsFromItem(input))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, wall, 6).group(group + "_walls")
                        .pattern("RRR")
                        .pattern("RRR")
                        .input('R', input)
                        .criterion(hasItem(input), conditionsFromItem(input))
                        .offerTo(exporter);
            }
            public void createSmallSquare(ItemConvertible output, ItemConvertible input) {
                createShaped(RecipeCategory.BUILDING_BLOCKS, output, 4)
                        .pattern("RR")
                        .pattern("RR")
                        .input('R', input)
                        .criterion(hasItem(input), conditionsFromItem(input))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "Seasonal Additions Recipes";
    }
}
