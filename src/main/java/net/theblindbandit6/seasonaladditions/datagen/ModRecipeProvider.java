package net.theblindbandit6.seasonaladditions.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.theblindbandit6.seasonaladditions.block.ModBlocks;
import net.theblindbandit6.seasonaladditions.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        //Icecutter
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICECUTTER)
                .pattern(" S ")
                .pattern("XRX")
                .input('R', Blocks.BLUE_ICE)
                .input('S', Items.IRON_INGOT)
                .input('X', Blocks.STONE)
                .criterion(hasItem(Blocks.BLUE_ICE), conditionsFromItem(Blocks.BLUE_ICE))
                .offerTo(exporter);
        //Frosted Glowstone
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FROSTED_GLOWSTONE)
                .pattern("RR")
                .pattern("RR")
                .input('R', ModItems.FROSTED_GLOWSTONE_DUST)
                .criterion(hasItem(ModItems.FROSTED_GLOWSTONE_DUST), conditionsFromItem(ModItems.FROSTED_GLOWSTONE_DUST))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BREWING, ModItems.FROSTED_GLOWSTONE_DUST, 8)
                .pattern("RRR")
                .pattern("RGR")
                .pattern("RRR")
                .input('G', Blocks.PACKED_ICE)
                .input('R', Items.GLOWSTONE_DUST)
                .criterion(hasItem(Blocks.PACKED_ICE), conditionsFromItem(Blocks.PACKED_ICE))
                .offerTo(exporter);
        //Candy Cane
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CANDY_CANE, 4)
                .input(ModItems.PEPPERMINT)
                .input(Items.SUGAR)
                .input(Items.RED_DYE)
                .input(Items.WHITE_DYE)
                .criterion(hasItem(ModItems.PEPPERMINT), conditionsFromItem(ModItems.PEPPERMINT))
                .offerTo(exporter);
        createCondensingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_CANDY_CANE_BLOCK, Ingredient.ofItems(ModBlocks.RED_CANDY_CANE_BLOCK));
        offerStairsRecipe(exporter, ModBlocks.RED_CANDY_CANE_STAIRS, ModBlocks.RED_CANDY_CANE_BLOCK);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_CANDY_CANE_SLAB, ModBlocks.RED_CANDY_CANE_BLOCK);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_CANDY_CANE_BLOCK, 8)
                .pattern("RRR")
                .pattern("RGR")
                .pattern("RRR")
                .input('G', Items.LIME_DYE)
                .input('R', ModBlocks.RED_CANDY_CANE_BLOCK)
                .criterion(hasItem(ModBlocks.RED_CANDY_CANE_BLOCK), conditionsFromItem(ModBlocks.RED_CANDY_CANE_BLOCK))
                .offerTo(exporter);
        offerStairsRecipe(exporter, ModBlocks.GREEN_CANDY_CANE_STAIRS, ModBlocks.GREEN_CANDY_CANE_BLOCK);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_CANDY_CANE_SLAB, ModBlocks.GREEN_CANDY_CANE_BLOCK);
        //Fairy Lights
        createFairyLightRecipe(exporter, ModBlocks.RED_FAIRY_LIGHTS, Items.RED_DYE);
        createFairyLightRecipe(exporter, ModBlocks.GREEN_FAIRY_LIGHTS, Items.GREEN_DYE);
        createFairyLightRecipe(exporter, ModBlocks.WHITE_FAIRY_LIGHTS, Items.WHITE_DYE);
        createFairyLightRecipe(exporter, ModBlocks.YELLOW_FAIRY_LIGHTS, Items.YELLOW_DYE);
        createFairyLightRecipe(exporter, ModBlocks.BLUE_FAIRY_LIGHTS, Items.BLUE_DYE);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FESTIVE_FAIRY_LIGHTS, 16).group("fairy_lights")
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
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,Items.RED_DYE)
                .input(ModBlocks.POINSETTIA)
                .criterion("has_poinsettia", conditionsFromItem(ModBlocks.POINSETTIA))
                .offerTo(exporter);
        //Banner Patterns
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.PRESENT_BANNER_PATTERN)
                .input(Items.PAPER)
                .input(Blocks.CHEST)
                .criterion("has_chest", conditionsFromItem(Blocks.CHEST))
                .offerTo(exporter);

        //Crafting Recipes - Added since the icecutter doesn't work in a server currently
        createStairsSlabWallRecipes(exporter, Blocks.ICE, ModBlocks.ICE_STAIRS, ModBlocks.ICE_SLAB, ModBlocks.ICE_WALL, "ice");
        createSmallSquare(exporter, ModBlocks.SMALL_ICE_BRICKS, Blocks.ICE);
        createSmallSquare(exporter, ModBlocks.LARGE_ICE_BRICKS, ModBlocks.SMALL_ICE_BRICKS);
        createSmallSquare(exporter, ModBlocks.POLISHED_ICE, ModBlocks.LARGE_ICE_BRICKS);
        createSmallSquare(exporter, ModBlocks.CHISELED_ICE_BRICKS, ModBlocks.POLISHED_ICE);
        createStairsSlabWallRecipes(exporter, Blocks.PACKED_ICE, ModBlocks.PACKED_ICE_STAIRS, ModBlocks.PACKED_ICE_SLAB, ModBlocks.PACKED_ICE_WALL, "ice");
        createStairsSlabWallRecipes(exporter, Blocks.BLUE_ICE, ModBlocks.BLUE_ICE_STAIRS, ModBlocks.BLUE_ICE_SLAB, ModBlocks.BLUE_ICE_WALL, "ice");
        createStairsSlabWallRecipes(exporter, ModBlocks.SMALL_ICE_BRICKS, ModBlocks.SMALL_ICE_BRICKS_STAIRS, ModBlocks.SMALL_ICE_BRICKS_SLAB, ModBlocks.SMALL_ICE_BRICKS_WALL, "ice");
        createStairsSlabWallRecipes(exporter, ModBlocks.LARGE_ICE_BRICKS, ModBlocks.LARGE_ICE_BRICKS_STAIRS, ModBlocks.LARGE_ICE_BRICKS_SLAB, ModBlocks.LARGE_ICE_BRICKS_WALL, "ice");
        createStairsSlabWallRecipes(exporter, ModBlocks.POLISHED_ICE, ModBlocks.POLISHED_ICE_STAIRS, ModBlocks.POLISHED_ICE_SLAB, ModBlocks.POLISHED_ICE_WALL, "ice");
        createStairsSlabWallRecipes(exporter, Blocks.SNOW_BLOCK, ModBlocks.SNOW_STAIRS, ModBlocks.SNOW_SLAB, ModBlocks.SNOW_WALL, "snow");
        //Icecutting
        //Ice
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_SLAB, Blocks.ICE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_STAIRS, Blocks.ICE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_WALL, Blocks.ICE);
        //Packed Ice
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_SLAB, Blocks.PACKED_ICE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_STAIRS, Blocks.PACKED_ICE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_WALL, Blocks.PACKED_ICE);
        //Blue Ice
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_ICE_SLAB, Blocks.BLUE_ICE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_ICE_STAIRS, Blocks.BLUE_ICE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_ICE_WALL, Blocks.BLUE_ICE);
        //Snow
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.SNOW, Blocks.SNOW_BLOCK, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SNOW_SLAB, Blocks.SNOW_BLOCK, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SNOW_STAIRS, Blocks.SNOW_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SNOW_WALL, Blocks.SNOW_BLOCK);
        //Small Ice Bricks
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMALL_ICE_BRICKS, Blocks.PACKED_ICE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMALL_ICE_BRICKS_SLAB, Blocks.PACKED_ICE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMALL_ICE_BRICKS_STAIRS, Blocks.PACKED_ICE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMALL_ICE_BRICKS_WALL, Blocks.PACKED_ICE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMALL_ICE_BRICKS_SLAB, ModBlocks.SMALL_ICE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMALL_ICE_BRICKS_STAIRS, ModBlocks.SMALL_ICE_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMALL_ICE_BRICKS_WALL, ModBlocks.SMALL_ICE_BRICKS);
        //Large Ice Bricks
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LARGE_ICE_BRICKS, Blocks.PACKED_ICE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LARGE_ICE_BRICKS_SLAB, Blocks.PACKED_ICE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LARGE_ICE_BRICKS_STAIRS, Blocks.PACKED_ICE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LARGE_ICE_BRICKS_WALL, Blocks.PACKED_ICE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LARGE_ICE_BRICKS_SLAB, ModBlocks.LARGE_ICE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LARGE_ICE_BRICKS_STAIRS, ModBlocks.LARGE_ICE_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LARGE_ICE_BRICKS_WALL, ModBlocks.LARGE_ICE_BRICKS);
        //Polished Ice
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE, Blocks.PACKED_ICE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE_SLAB, Blocks.PACKED_ICE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE_STAIRS, Blocks.PACKED_ICE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE_WALL, Blocks.PACKED_ICE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE_SLAB, ModBlocks.POLISHED_ICE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE_STAIRS, ModBlocks.POLISHED_ICE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ICE_WALL, ModBlocks.POLISHED_ICE);
        //Chiseled Ice Bricks
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_ICE_BRICKS, Blocks.PACKED_ICE);
        //Ice Unpacking With Icecutter
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.PACKED_ICE, Blocks.BLUE_ICE, 9);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.ICE, Blocks.PACKED_ICE, 9);
    }

    public void createFairyLightRecipe(RecipeExporter exporter, ItemConvertible fairyLights, ItemConvertible color){
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, fairyLights, 16).group("fairy_lights")
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
    public void createStairsSlabWallRecipes(RecipeExporter exporter, ItemConvertible input, ItemConvertible stair, ItemConvertible slab, ItemConvertible wall, String group){
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, stair, 6).group(group + "_stairs")
                .pattern("R  ")
                .pattern("RR ")
                .pattern("RRR")
                .input('R', input)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, slab, 6).group(group + "_slabs")
                .pattern("RRR")
                .input('R', input)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, wall, 6).group(group + "_walls")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', input)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
    public void createSmallSquare(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 4)
                .pattern("RR")
                .pattern("RR")
                .input('R', input)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
    public static void offerStairsRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        createStairsRecipe(output, Ingredient.ofItems(input)).criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
    }

    @Override
    public String getName() {
        return "Seasonal Additions Recipes";
    }
}
