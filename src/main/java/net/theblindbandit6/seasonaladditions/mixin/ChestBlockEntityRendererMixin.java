package net.theblindbandit6.seasonaladditions.mixin;

import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Calendar;

import static net.theblindbandit6.seasonaladditions.SeasonalAdditions.CHRISTMAS_END;
import static net.theblindbandit6.seasonaladditions.SeasonalAdditions.CHRISTMAS_START;

@Mixin(ChestBlockEntityRenderer.class)
public abstract class ChestBlockEntityRendererMixin {

    @Shadow
    private boolean christmas;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void onInit(BlockEntityRendererFactory.Context ctx, CallbackInfo ci) {
        Calendar calendar = Calendar.getInstance();
        boolean christmas = calendar.get(Calendar.MONTH) == Calendar.DECEMBER
                && calendar.get(Calendar.DAY_OF_MONTH) >= CHRISTMAS_START
                && calendar.get(Calendar.DAY_OF_MONTH) <= CHRISTMAS_END;
    }
}