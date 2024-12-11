package net.theblindbandit6.seasonaladditions.mixin;

import net.minecraft.recipe.PreparedRecipes;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.ServerRecipeManager;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.theblindbandit6.seasonaladditions.interfaces.IcecutterRecipeGetter;
import net.theblindbandit6.seasonaladditions.recipe.IcecuttingRecipe;
import net.theblindbandit6.seasonaladditions.recipe.display.IcecuttingRecipeDisplay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Mixin(ServerRecipeManager.class)
public abstract class ServerRecipeManagerMixin implements IcecutterRecipeGetter {

    @Shadow public abstract Collection<RecipeEntry<?>> values();

    @Shadow private PreparedRecipes preparedRecipes;
    @Unique
    private IcecuttingRecipeDisplay.Grouping icecutterRecipes;

    @Override
    public IcecuttingRecipeDisplay.Grouping seasonalAdditions$getIcecutterRecipeForSync() {
        return this.icecutterRecipes;
    }

    @Override
    public IcecuttingRecipeDisplay.Grouping seasonalAdditions$getIcecutterRecipes() {
        return this.icecutterRecipes;
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void init(RegistryWrapper.WrapperLookup registries, CallbackInfo ci) {
        icecutterRecipes = IcecuttingRecipeDisplay.Grouping.empty();
    }

    @Inject(method = "initialize", at = @At("TAIL"))
    private void initialize(FeatureSet features, CallbackInfo ci) {
        List<IcecuttingRecipeDisplay.GroupEntry> icecuttingRecipeEntries = new ArrayList<>();
        this.preparedRecipes.recipes().forEach(
                recipeEntry -> {
                    Recipe<?> recipe = recipeEntry.value();
                    if (recipe instanceof IcecuttingRecipe icecuttingRecipe) {
                        icecuttingRecipeEntries.add(new IcecuttingRecipeDisplay.GroupEntry(icecuttingRecipe.ingredient(),
                                icecuttingRecipe.inputCount(), new IcecuttingRecipeDisplay(icecuttingRecipe.createResultDisplay(), Optional.of((RecipeEntry<IcecuttingRecipe>) recipeEntry))));
                    }
                }
        );
        this.icecutterRecipes = new IcecuttingRecipeDisplay.Grouping(icecuttingRecipeEntries);
    }
}
