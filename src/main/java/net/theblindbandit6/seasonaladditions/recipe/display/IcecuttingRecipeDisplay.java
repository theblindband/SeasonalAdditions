package net.theblindbandit6.seasonaladditions.recipe.display;

import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.display.SlotDisplay;
import net.theblindbandit6.seasonaladditions.recipe.IcecuttingRecipe;

import java.util.List;
import java.util.Optional;

public record IcecuttingRecipeDisplay(SlotDisplay optionDisplay, Optional<RecipeEntry<IcecuttingRecipe>> recipe) {

    public static PacketCodec<RegistryByteBuf, IcecuttingRecipeDisplay> codec() {
        return PacketCodec.tuple(SlotDisplay.PACKET_CODEC,
                IcecuttingRecipeDisplay::optionDisplay, display -> new IcecuttingRecipeDisplay(display, Optional.empty()));
    }

    public record GroupEntry(Ingredient input, int inputCount, IcecuttingRecipeDisplay recipe) {

        public static PacketCodec<RegistryByteBuf, IcecuttingRecipeDisplay.GroupEntry> codec() {
            return PacketCodec.tuple(
                    Ingredient.PACKET_CODEC,
                    IcecuttingRecipeDisplay.GroupEntry::input,
                    PacketCodecs.INTEGER,
                    IcecuttingRecipeDisplay.GroupEntry::inputCount,
                    IcecuttingRecipeDisplay.codec(),
                    IcecuttingRecipeDisplay.GroupEntry::recipe,
                    IcecuttingRecipeDisplay.GroupEntry::new
            );
        }
    }

    public record Grouping(List<IcecuttingRecipeDisplay.GroupEntry> entries) {

        public static IcecuttingRecipeDisplay.Grouping empty() {
            return new IcecuttingRecipeDisplay.Grouping(List.of());
        }

        public static PacketCodec<RegistryByteBuf, IcecuttingRecipeDisplay.Grouping> codec() {
            return PacketCodec.tuple(
                    IcecuttingRecipeDisplay.GroupEntry.codec().collect(PacketCodecs.toList()),
                    IcecuttingRecipeDisplay.Grouping::entries, IcecuttingRecipeDisplay.Grouping::new
            );
        }

        public boolean contains(ItemStack stack) {
            return this.entries.stream().anyMatch(entry -> entry.input.test(stack));
        }

        public IcecuttingRecipeDisplay.Grouping filter(ItemStack stack) {
            return new IcecuttingRecipeDisplay.Grouping(this.entries.stream().filter(entry -> entry.input.test(stack)).toList());
        }

        public boolean isEmpty() {
            return this.entries.isEmpty();
        }

        public int size() {
            return this.entries.size();
        }
    }
}
