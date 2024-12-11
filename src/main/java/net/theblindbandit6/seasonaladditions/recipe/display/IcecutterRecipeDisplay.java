package net.theblindbandit6.seasonaladditions.recipe.display;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.display.RecipeDisplay;
import net.minecraft.recipe.display.SlotDisplay;

public record IcecutterRecipeDisplay(SlotDisplay input, SlotDisplay result, SlotDisplay craftingStation) implements RecipeDisplay {
    public static final MapCodec<IcecutterRecipeDisplay> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                            SlotDisplay.CODEC.fieldOf("input").forGetter(IcecutterRecipeDisplay::input),
                            SlotDisplay.CODEC.fieldOf("result").forGetter(IcecutterRecipeDisplay::result),
                            SlotDisplay.CODEC.fieldOf("crafting_station").forGetter(IcecutterRecipeDisplay::craftingStation)
                    )
                    .apply(instance, IcecutterRecipeDisplay::new)
    );
    public static final PacketCodec<RegistryByteBuf, IcecutterRecipeDisplay> PACKET_CODEC = PacketCodec.tuple(
            SlotDisplay.PACKET_CODEC,
            IcecutterRecipeDisplay::input,
            SlotDisplay.PACKET_CODEC,
            IcecutterRecipeDisplay::result,
            SlotDisplay.PACKET_CODEC,
            IcecutterRecipeDisplay::craftingStation,
            IcecutterRecipeDisplay::new
    );
    public static final RecipeDisplay.Serializer<IcecutterRecipeDisplay> SERIALIZER = new RecipeDisplay.Serializer<>(CODEC, PACKET_CODEC);

    @Override
    public RecipeDisplay.Serializer<IcecutterRecipeDisplay> serializer() {
        return SERIALIZER;
    }
}