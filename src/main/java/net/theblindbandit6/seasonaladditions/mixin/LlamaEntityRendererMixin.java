package net.theblindbandit6.seasonaladditions.mixin;

import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import net.minecraft.client.render.entity.LlamaEntityRenderer;
import net.minecraft.client.render.entity.state.LlamaEntityRenderState;
import net.minecraft.util.Identifier;
import net.theblindbandit6.seasonaladditions.SeasonalAdditions;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LlamaEntityRenderer.class)
public final class LlamaEntityRendererMixin {
    @Mutable @Shadow @Final
    public static Identifier CREAMY_TEXTURE;
    @Mutable @Shadow @Final
    public static Identifier WHITE_TEXTURE;
    @Mutable @Shadow @Final
    public static Identifier BROWN_TEXTURE;
    @Mutable @Shadow @Final
    public static Identifier GRAY_TEXTURE;

    @Inject(at = @At("RETURN"), method = "<clinit>")
    private static void modifyVariable(CallbackInfo ci) {
        if(ChestBlockEntityRenderer.isAroundChristmas()) {
            CREAMY_TEXTURE = SeasonalAdditions.identifier("textures/entity/llama/christmas_creamy.png");
            WHITE_TEXTURE = SeasonalAdditions.identifier("textures/entity/llama/christmas_white.png");
            BROWN_TEXTURE = SeasonalAdditions.identifier("textures/entity/llama/christmas_brown.png");
            GRAY_TEXTURE = SeasonalAdditions.identifier("textures/entity/llama/christmas_gray.png");
        }
    }

    @Inject(at = @At(value = "RETURN"), method = "getTexture(Lnet/minecraft/client/render/entity/state/LlamaEntityRenderState;)Lnet/minecraft/util/Identifier;", cancellable = true)
    private void getTexture(final LlamaEntityRenderState llamaEntityRenderState, final CallbackInfoReturnable<Identifier> callbackInfoReturnable) {
        if(ChestBlockEntityRenderer.isAroundChristmas()) {
            callbackInfoReturnable.setReturnValue(SeasonalAdditions.identifier(callbackInfoReturnable.getReturnValue().getPath()));
        }
    }
}