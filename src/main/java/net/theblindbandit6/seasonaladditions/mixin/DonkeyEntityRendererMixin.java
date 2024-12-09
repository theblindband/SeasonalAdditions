package net.theblindbandit6.seasonaladditions.mixin;

import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import net.minecraft.client.render.entity.AbstractDonkeyEntityRenderer;
import net.minecraft.client.render.entity.state.DonkeyEntityRenderState;
import net.minecraft.util.Identifier;
import net.theblindbandit6.seasonaladditions.SeasonalAdditions;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractDonkeyEntityRenderer.class)
public final class DonkeyEntityRendererMixin {

    @Mutable @Shadow @Final
    public static Identifier DONKEY_TEXTURE;
    @Mutable @Shadow @Final
    public static Identifier MULE_TEXTURE;

    @Inject(at = @At("RETURN"), method = "<clinit>")
    private static void modifyVariable(CallbackInfo ci) {
        if(ChestBlockEntityRenderer.isAroundChristmas()) {
            DONKEY_TEXTURE = SeasonalAdditions.identifier("textures/entity/horse/christmas_donkey.png");
            MULE_TEXTURE = SeasonalAdditions.identifier("textures/entity/horse/christmas_mule.png");
        }
    }

    @Inject(at = @At(value = "RETURN"), method = "getTexture(Lnet/minecraft/client/render/entity/state/DonkeyEntityRenderState;)Lnet/minecraft/util/Identifier;", cancellable = true)
    private void getTexture(final DonkeyEntityRenderState donkeyEntityRenderState, final CallbackInfoReturnable<Identifier> callbackInfoReturnable) {
        if(ChestBlockEntityRenderer.isAroundChristmas()) {
            callbackInfoReturnable.setReturnValue(SeasonalAdditions.identifier(callbackInfoReturnable.getReturnValue().getPath()));
        }
    }
}