package net.theblindbandit6.seasonaladditions.mixin;

import net.minecraft.client.render.entity.LlamaEntityRenderer;
import net.minecraft.entity.passive.LlamaEntity;
import net.minecraft.util.Identifier;
import net.theblindbandit6.seasonaladditions.SeasonalAdditions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Calendar;

@Mixin(LlamaEntityRenderer.class)
public abstract class LlamaEntityRendererMixin {

    @Unique
    private static final Identifier CHRISTMAS_CREAMY_TEXTURE = SeasonalAdditions.identifier("textures/entity/llama/christmas_creamy.png");
    @Unique
    private static final Identifier CHRISTMAS_WHITE_TEXTURE = SeasonalAdditions.identifier("textures/entity/llama/christmas_white.png");
    @Unique
    private static final Identifier CHRISTMAS_BROWN_TEXTURE = SeasonalAdditions.identifier("textures/entity/llama/christmas_brown.png");
    @Unique
    private static final Identifier CHRISTMAS_GRAY_TEXTURE = SeasonalAdditions.identifier("textures/entity/llama/christmas_gray.png");

    @Inject(method = "getTexture*", at = @At("RETURN"), cancellable = true)
    private void getTexture(LlamaEntity llamaEntity, CallbackInfoReturnable<Identifier> cir) {
        Calendar calendar = Calendar.getInstance();
        boolean christmas = calendar.get(Calendar.MONTH) == Calendar.DECEMBER
                && calendar.get(Calendar.DAY_OF_MONTH) >= 1
                && calendar.get(Calendar.DAY_OF_MONTH) <= 26;

        if (christmas) {
            Identifier texture;
            switch (llamaEntity.getVariant()) {
                case LlamaEntity.Variant.CREAMY -> texture = CHRISTMAS_CREAMY_TEXTURE;
                case LlamaEntity.Variant.WHITE -> texture = CHRISTMAS_WHITE_TEXTURE;
                case LlamaEntity.Variant.BROWN -> texture = CHRISTMAS_BROWN_TEXTURE;
                case LlamaEntity.Variant.GRAY -> texture = CHRISTMAS_GRAY_TEXTURE;
                default -> texture = cir.getReturnValue();
            }
            cir.setReturnValue(texture);
        }
    }
}
