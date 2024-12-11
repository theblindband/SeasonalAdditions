package net.theblindbandit6.seasonaladditions.datagen;

import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.theblindbandit6.seasonaladditions.recipe.IcecuttingRecipeJsonBuilder;

public abstract class ModRecipeGenerator extends RecipeGenerator {

    protected ModRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        super(registries, exporter);
    }

    protected void createIcecuttingRecipe(RecipeCategory recipeCategory, TagKey<Item> inputTag, String criteria, ItemConvertible output) {
        String tagPath = inputTag.id().getPath();
        Ingredient ingredient = ingredientFromTag(inputTag);

        IcecuttingRecipeJsonBuilder.createIcecutting(recipeCategory, ingredient, output)
                .criterion(criteria, this.conditionsFromTag(inputTag))
                .offerTo(exporter, convertBetween(output, tagPath) + "_icecutting");
    }

    protected void createIcecuttingRecipe(RecipeCategory recipeCategory, TagKey<Item> inputTag, String criteria, int inputCount, ItemConvertible output) {
        String tagPath = inputTag.id().getPath();
        Ingredient ingredient = ingredientFromTag(inputTag);

        IcecuttingRecipeJsonBuilder.createIcecutting(recipeCategory, ingredient, inputCount, output)
                .criterion(criteria, this.conditionsFromTag(inputTag))
                .offerTo(exporter, convertBetween(output, tagPath) + "_icecutting");
    }

    protected void createIcecuttingRecipe(RecipeCategory recipeCategory, TagKey<Item> inputTag, String criteria, ItemConvertible output, int outputCount) {
        String tagPath = inputTag.id().getPath();
        Ingredient ingredient = ingredientFromTag(inputTag);

        IcecuttingRecipeJsonBuilder.createIcecutting(recipeCategory, ingredient, output, outputCount)
                .criterion(criteria, this.conditionsFromTag(inputTag))
                .offerTo(exporter, convertBetween(output, tagPath) + "_icecutting");
    }

    protected void createIcecuttingRecipe(RecipeCategory recipeCategory, ItemConvertible output, ItemConvertible input) {
        Ingredient ingredient = Ingredient.ofItem(input);
        String blockName = Registries.ITEM.getId(input.asItem()).getPath();

        IcecuttingRecipeJsonBuilder.createIcecutting(recipeCategory, ingredient, output)
                .criterion(hasItem(input), this.conditionsFromItem(input))
                .offerTo(exporter, convertBetween(output, blockName) + "_icecutting");
    }

    protected void createIcecuttingRecipe(RecipeCategory recipeCategory, ItemConvertible input, int inputCount, ItemConvertible output) {
        Ingredient ingredient = Ingredient.ofItem(input);
        String blockName = Registries.ITEM.getId(input.asItem()).getPath();

        IcecuttingRecipeJsonBuilder.createIcecutting(recipeCategory, ingredient, inputCount, output)
                .criterion(hasItem(input), this.conditionsFromItem(input))
                .offerTo(exporter, convertBetween(output, blockName) + "_icecutting");
    }

    protected void createIcecuttingRecipe(RecipeCategory recipeCategory, ItemConvertible output, ItemConvertible input, int outputCount) {
        Ingredient ingredient = Ingredient.ofItem(input);
        String blockName = Registries.ITEM.getId(input.asItem()).getPath();

        IcecuttingRecipeJsonBuilder.createIcecutting(recipeCategory, ingredient, output, outputCount)
                .criterion(hasItem(input), this.conditionsFromItem(input))
                .offerTo(exporter, convertBetween(output, blockName) + "_icecutting");
    }

    protected void createIcecuttingRecipe(RecipeCategory recipeCategory, ItemConvertible input, int inputCount, ItemConvertible output, int outputCount) {
        Ingredient ingredient = Ingredient.ofItem(input);
        String blockName = Registries.ITEM.getId(input.asItem()).getPath();

        IcecuttingRecipeJsonBuilder.createIcecutting(recipeCategory, ingredient, inputCount, output, outputCount)
                .criterion(hasItem(input), this.conditionsFromItem(input))
                .offerTo(exporter, convertBetween(output, blockName) + "_icecutting");
    }

    protected static String convertBetween(ItemConvertible to, String from) {
        return getItemPath(to) + "_from_" + from;
    }
}
