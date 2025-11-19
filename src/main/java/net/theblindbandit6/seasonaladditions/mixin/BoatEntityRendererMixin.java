package net.theblindbandit6.seasonaladditions.mixin;

import net.minecraft.client.render.entity.BoatEntityRenderer;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.Identifier;
import net.theblindbandit6.seasonaladditions.SeasonalAdditions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Calendar;

import static net.theblindbandit6.seasonaladditions.SeasonalAdditions.CHRISTMAS_END;
import static net.theblindbandit6.seasonaladditions.SeasonalAdditions.CHRISTMAS_START;

@Mixin(BoatEntityRenderer.class)
public abstract class BoatEntityRendererMixin {

    @Inject(method = "getTexture(Lnet/minecraft/entity/vehicle/BoatEntity$Type;Z)Lnet/minecraft/util/Identifier;", at = @At("RETURN"), cancellable = true)
    private static void getTexture(BoatEntity.Type type, boolean chest, CallbackInfoReturnable<Identifier> cir) {
        Calendar calendar = Calendar.getInstance();
        boolean christmas = calendar.get(Calendar.MONTH) == Calendar.DECEMBER
                && calendar.get(Calendar.DAY_OF_MONTH) >= CHRISTMAS_START
                && calendar.get(Calendar.DAY_OF_MONTH) <= CHRISTMAS_END;
        if (christmas && chest) {
            cir.setReturnValue(SeasonalAdditions.identifier("textures/entity/chest_boat/christmas_" + type.getName() + ".png"));
        }
    }
}
