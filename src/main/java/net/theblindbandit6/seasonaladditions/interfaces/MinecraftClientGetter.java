package net.theblindbandit6.seasonaladditions.interfaces;

import net.minecraft.client.MinecraftClient;

public interface MinecraftClientGetter {

    default MinecraftClient seasonalAdditions$getMinecraftClient() {
        return null;
    }
}
