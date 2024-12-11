package net.theblindbandit6.seasonaladditions;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.theblindbandit6.seasonaladditions.block.ModBlocks;
import net.theblindbandit6.seasonaladditions.screen.IcecutterScreen;

public class SeasonalAdditionsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(SeasonalAdditions.ICECUTTER_SCREEN_HANDLER, IcecutterScreen::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ICECUTTER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ICE_SLAB, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ICE_STAIRS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ICE_WALL, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PEPPERMINT_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_FAIRY_LIGHTS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GREEN_FAIRY_LIGHTS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_FAIRY_LIGHTS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FESTIVE_FAIRY_LIGHTS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POINSETTIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_POINSETTIA, RenderLayer.getCutout());
    }
}
