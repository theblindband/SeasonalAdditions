package net.theblindbandit6.seasonaladditions.network.packet.s2c.play;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.PacketType;
import net.theblindbandit6.seasonaladditions.network.listener.ModClientPlayPacketListener;
import net.theblindbandit6.seasonaladditions.network.packet.ModPlayPackets;
import net.theblindbandit6.seasonaladditions.recipe.display.IcecuttingRecipeDisplay;

public record SynchronizeModRecipesS2CPacket(IcecuttingRecipeDisplay.Grouping icecuttingRecipes) implements Packet<ClientPlayPacketListener> {

    public static final PacketCodec<RegistryByteBuf, SynchronizeModRecipesS2CPacket> CODEC = PacketCodec.tuple(
            IcecuttingRecipeDisplay.Grouping.codec(),
            SynchronizeModRecipesS2CPacket::icecuttingRecipes,
            SynchronizeModRecipesS2CPacket::new
    );

    @Override
    public PacketType<? extends Packet<ClientPlayPacketListener>> getPacketType() {
        return ModPlayPackets.UPDATE_RECIPES;
    }

    @Override
    public void apply(ClientPlayPacketListener clientPlayPacketListener) {
        ((ModClientPlayPacketListener) clientPlayPacketListener).seasonalAdditions$onSynchronizeModRecipes(this);
    }
}
