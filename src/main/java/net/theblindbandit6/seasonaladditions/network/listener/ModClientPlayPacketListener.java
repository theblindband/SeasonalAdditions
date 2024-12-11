package net.theblindbandit6.seasonaladditions.network.listener;

import net.minecraft.network.listener.ClientPingResultPacketListener;
import net.theblindbandit6.seasonaladditions.network.packet.s2c.play.SynchronizeModRecipesS2CPacket;

public interface ModClientPlayPacketListener extends ClientPingResultPacketListener {

    void nemo_sWoodcutter$onSynchronizeModRecipes(SynchronizeModRecipesS2CPacket packet);
}
