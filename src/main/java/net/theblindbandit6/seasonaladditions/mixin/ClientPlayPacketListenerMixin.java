package net.theblindbandit6.seasonaladditions.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.theblindbandit6.seasonaladditions.network.listener.ModClientPlayPacketListener;
import org.spongepowered.asm.mixin.Mixin;

@Environment(EnvType.CLIENT)
@Mixin(ClientPlayPacketListener.class)
public interface ClientPlayPacketListenerMixin extends ModClientPlayPacketListener {
}
