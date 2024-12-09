package net.theblindbandit6.seasonaladditions.mixin;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import net.minecraft.client.render.entity.RaftEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.BoatEntityRenderState;
import net.minecraft.util.Identifier;
import net.theblindbandit6.seasonaladditions.SeasonalAdditions;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RaftEntityRenderer.class)
public final class RaftEntityRendererMixin {

    @Shadow @Final private EntityModel<BoatEntityRenderState> model;

    @Shadow @Final private Identifier texture;

    @Inject(at = @At(value = "RETURN"), method = "getRenderLayer", cancellable = true)
    private void getRenderLayer(final CallbackInfoReturnable<RenderLayer> callbackInfoReturnable) {
        if(ChestBlockEntityRenderer.isAroundChristmas()) {
            callbackInfoReturnable.setReturnValue(this.model.getLayer(SeasonalAdditions.identifier("christmas_textures/"+this.texture.getPath())));
        }
    }

}