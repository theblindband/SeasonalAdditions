package net.theblindbandit6.seasonaladditions.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientCommonNetworkHandler;
import net.theblindbandit6.seasonaladditions.interfaces.MinecraftClientGetter;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Environment(EnvType.CLIENT)
@Mixin(ClientCommonNetworkHandler.class)
public class ClientCommonNetworkHandlerMixin implements MinecraftClientGetter {

    @Shadow @Final protected MinecraftClient client;

    @Override
    public MinecraftClient seasonalAdditions$getMinecraftClient() {
        return client;
    }
}
