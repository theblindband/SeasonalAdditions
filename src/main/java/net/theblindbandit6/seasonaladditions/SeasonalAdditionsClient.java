package net.theblindbandit6.seasonaladditions;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.theblindbandit6.seasonaladditions.block.ModBlocks;

public class SeasonalAdditionsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ICECUTTER, RenderLayer.getCutout());
    }
}
