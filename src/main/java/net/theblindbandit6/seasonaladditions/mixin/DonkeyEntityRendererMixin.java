package net.theblindbandit6.seasonaladditions.mixin;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.client.render.entity.DonkeyEntityRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.theblindbandit6.seasonaladditions.SeasonalAdditions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Calendar;
import java.util.Map;

@Mixin(DonkeyEntityRenderer.class)
public abstract class DonkeyEntityRendererMixin {
    @Shadow
    private static final Map<EntityType<?>, Identifier> TEXTURES = Maps.newHashMap(ImmutableMap.of(EntityType.DONKEY, Identifier.ofVanilla("textures/entity/horse/donkey.png"), EntityType.MULE, Identifier.ofVanilla("textures/entity/horse/mule.png")));

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void onClinit(CallbackInfo ci) {
        Calendar calendar = Calendar.getInstance();
        boolean christmas = calendar.get(Calendar.MONTH) == Calendar.DECEMBER
                && calendar.get(Calendar.DAY_OF_MONTH) >= 1
                && calendar.get(Calendar.DAY_OF_MONTH) <= 26;

        if (christmas) {
            TEXTURES.put(EntityType.DONKEY, SeasonalAdditions.identifier("textures/entity/horse/christmas_donkey.png"));
            TEXTURES.put(EntityType.MULE, SeasonalAdditions.identifier("textures/entity/horse/christmas_mule.png"));
        }
    }
}
