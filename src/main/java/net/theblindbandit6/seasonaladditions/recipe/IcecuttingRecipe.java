package net.theblindbandit6.seasonaladditions.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.recipe.display.RecipeDisplay;
import net.minecraft.recipe.display.SlotDisplay;
import net.theblindbandit6.seasonaladditions.block.ModBlocks;
import net.theblindbandit6.seasonaladditions.recipe.book.ModRecipeBookCategories;
import net.theblindbandit6.seasonaladditions.recipe.display.IcecutterRecipeDisplay;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class IcecuttingRecipe extends SingleStackRecipe {
    public IcecuttingRecipe(String group, Ingredient ingredient, ItemStack result) {
        super(group, ingredient, result);
    }

    @Override
    public @NotNull RecipeSerializer<IcecuttingRecipe> getSerializer() {
        return ModRecipeSerializer.ICECUTTING.get();
    }

    @Override
    public @NotNull RecipeType<IcecuttingRecipe> getType() {
        return ModRecipeTypes.ICECUTTING.get();
    }

    @Override
    public List<RecipeDisplay> getDisplays() {
        return List.of(new IcecutterRecipeDisplay(this.ingredient().toDisplay(), this.createResultDisplay(), new SlotDisplay.ItemSlotDisplay(ModBlocks.ICECUTTER.asItem())));
    }

    public SlotDisplay createResultDisplay() {
        return new SlotDisplay.StackSlotDisplay(this.result());
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return ModRecipeBookCategories.ICECUTTER;
    }
}
