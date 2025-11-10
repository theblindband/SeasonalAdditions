package net.theblindbandit6.seasonaladditions.mixin;

import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Calendar;

@Mixin(ChestBlockEntityRenderer.class)
public abstract class ChestBlockEntityRendererMixin {

    @Shadow
    private boolean christmas;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void onInit(BlockEntityRendererFactory.Context ctx, CallbackInfo ci) {
        Calendar calendar = Calendar.getInstance();
        christmas = calendar.get(Calendar.MONTH) == Calendar.NOVEMBER
                && calendar.get(Calendar.DAY_OF_MONTH) >= 10
                && calendar.get(Calendar.DAY_OF_MONTH) <= 26;
    }
}