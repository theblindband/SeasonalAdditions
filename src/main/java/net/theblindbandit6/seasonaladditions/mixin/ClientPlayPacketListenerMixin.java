package net.theblindbandit6.seasonaladditions.mixin;

import net.minecraft.network.listener.ClientPlayPacketListener;
import net.theblindbandit6.seasonaladditions.network.listener.ModClientPlayPacketListener;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ClientPlayPacketListener.class)
public interface ClientPlayPacketListenerMixin extends ModClientPlayPacketListener {
}
