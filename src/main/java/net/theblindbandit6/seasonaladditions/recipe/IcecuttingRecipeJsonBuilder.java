package net.theblindbandit6.seasonaladditions.recipe;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class IcecuttingRecipeJsonBuilder implements CraftingRecipeJsonBuilder {

    private final RecipeCategory category;
    private final SingleStackWithCountRecipe.RecipeFactory<?> recipeFactory;
    private final Ingredient input;
    private final int inputCount;
    private final Item output;
    private final int count;
    private final Map<String, AdvancementCriterion<?>> criteria = new LinkedHashMap();
    @Nullable
    private String group;

    public IcecuttingRecipeJsonBuilder(
            RecipeCategory category, SingleStackWithCountRecipe.RecipeFactory<?> recipeFactory, Ingredient input,
            int inputCount, ItemConvertible output, int count) {
        this.category = category;
        this.recipeFactory = recipeFactory;
        this.input = input;
        this.inputCount = inputCount;
        this.output = output.asItem();
        this.count = count;
    }

    public static IcecuttingRecipeJsonBuilder createIcecutting(RecipeCategory category, Ingredient input, ItemConvertible output) {
        return new IcecuttingRecipeJsonBuilder(category, IcecuttingRecipe::new, input, 1, output, 1);
    }

    public static IcecuttingRecipeJsonBuilder createIcecutting(RecipeCategory category, Ingredient input, ItemConvertible output, int count) {
        return new IcecuttingRecipeJsonBuilder(category, IcecuttingRecipe::new, input, 1, output, count);
    }

    public static IcecuttingRecipeJsonBuilder createIcecutting(RecipeCategory category, Ingredient input, int inputCount, ItemConvertible output) {
        return new IcecuttingRecipeJsonBuilder(category, IcecuttingRecipe::new, input, inputCount, output, 1);
    }

    public static IcecuttingRecipeJsonBuilder createIcecutting(RecipeCategory category, Ingredient input, int inputCount, ItemConvertible output, int count) {
        return new IcecuttingRecipeJsonBuilder(category, IcecuttingRecipe::new, input, inputCount, output, count);
    }

    @Override
    public CraftingRecipeJsonBuilder criterion(String name, AdvancementCriterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public CraftingRecipeJsonBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    @Override
    public Item getOutputItem() {
        return this.output;
    }

    @Override
    public void offerTo(RecipeExporter exporter, RegistryKey<Recipe<?>> recipeKey) {
        this.validate(recipeKey);
        Advancement.Builder builder = exporter.getAdvancementBuilder()
                .criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeKey))
                .rewards(AdvancementRewards.Builder.recipe(recipeKey))
                .criteriaMerger(AdvancementRequirements.CriterionMerger.OR);
        this.criteria.forEach(builder::criterion);
        SingleStackWithCountRecipe singleStackWithCountRecipe = this.recipeFactory
                .create(Objects.requireNonNullElse(this.group, ""), this.input, this.inputCount, new ItemStack(this.output, this.count));
        exporter.accept(recipeKey, singleStackWithCountRecipe, builder.build(recipeKey.getValue().withPrefixedPath("recipes/" + this.category.getName() + "/")));
    }

    private void validate(RegistryKey<Recipe<?>> recipeKey) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + recipeKey.getValue());
        }
    }
}
