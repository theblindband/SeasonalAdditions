package net.theblindbandit6.seasonaladditions.mixin;

import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import net.minecraft.client.util.SpriteIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Calendar;

@Mixin(ChestBlockEntityRenderer.class)
public abstract class ChestBlockEntityRendererMixin {

    @Inject(at = @At("RETURN"), method = "isAroundChristmas()Z", cancellable = true)
    private static void init(CallbackInfoReturnable<Boolean> cir) {
        Calendar calendar = Calendar.getInstance();
        cir.setReturnValue(calendar.get(2) + 1 == 12 && calendar.get(5) >= 1 && calendar.get(5) <= 31);
    }
}