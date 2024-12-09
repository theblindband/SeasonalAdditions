package net.theblindbandit6.seasonaladditions.mixin;

import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import net.minecraft.client.render.entity.LlamaEntityRenderer;
import net.minecraft.client.render.entity.state.LlamaEntityRenderState;
import net.minecraft.util.Identifier;
import net.theblindbandit6.seasonaladditions.SeasonalAdditions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LlamaEntityRenderer.class)
public final class LlamaEntityRendererMixin {

    @Inject(at = @At(value = "RETURN"), method = "getTexture(Lnet/minecraft/client/render/entity/state/LlamaEntityRenderState;)Lnet/minecraft/util/Identifier;", cancellable = true)
    private void getTexture(final LlamaEntityRenderState llamaEntityRenderState, final CallbackInfoReturnable<Identifier> callbackInfoReturnable) {
        if(ChestBlockEntityRenderer.isAroundChristmas()) {
            callbackInfoReturnable.setReturnValue(SeasonalAdditions.identifier("christmas_textures/"+callbackInfoReturnable.getReturnValue().getPath()));
        }
    }
}