package net.theblindbandit6.seasonaladditions.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SingleStackRecipe;
import net.minecraft.recipe.book.RecipeBookCategories;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.recipe.display.RecipeDisplay;
import net.minecraft.recipe.display.SlotDisplay;
import net.minecraft.recipe.display.StonecutterRecipeDisplay;
import net.theblindbandit6.seasonaladditions.SeasonalAdditions;
import net.theblindbandit6.seasonaladditions.recipe.ModRecipeSerializer;


import java.util.List;

public class IcecuttingRecipe extends ModSingleStackRecipe {
	public IcecuttingRecipe(String group, Ingredient ingredient, ItemStack result) {
		super(group, ingredient, result);
	}

	@Override
	public RecipeType<IcecuttingRecipe> getType() {
		return SeasonalAdditions.ICECUTTING;
	}

	@Override
	public RecipeSerializer<IcecuttingRecipe> getSerializer() {
		return ModRecipeSerializer.ICECUTTING;
	}

	@Override
	public List<RecipeDisplay> getDisplays() {
		return List.of(new StonecutterRecipeDisplay(this.ingredient().toDisplay(), this.createResultDisplay(), new SlotDisplay.ItemSlotDisplay(Items.STONECUTTER)));
	}

	public SlotDisplay createResultDisplay() {
		return new SlotDisplay.StackSlotDisplay(this.result());
	}

	@Override
	public RecipeBookCategory getRecipeBookCategory() {
		return RecipeBookCategories.STONECUTTER;
	}
}
