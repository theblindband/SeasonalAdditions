package net.theblindbandit6.seasonaladditions.mixin;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import net.minecraft.client.render.entity.model.LoadedEntityModels;
import net.minecraft.client.render.item.model.special.ChestModelRenderer;
import net.minecraft.client.render.item.model.special.SpecialModelRenderer;
import net.minecraft.client.render.item.model.special.SpecialModelTypes;
import net.minecraft.util.Identifier;
import net.theblindbandit6.seasonaladditions.SeasonalAdditions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static net.theblindbandit6.seasonaladditions.SeasonalAdditions.LOGGER;

@Mixin(SpecialModelTypes.class)
public class SpecialModelTypesMixin {
    @Unique
    private static final ChestModelRenderer.Unbaked CHRISTMAS_CHEST = new ChestModelRenderer.Unbaked(ChestModelRenderer.CHRISTMAS_ID);
    @Unique
    private static final ChestModelRenderer.Unbaked TRAPPED_CHRISTMAS_CHEST = new ChestModelRenderer.Unbaked(SeasonalAdditions.TRAPPED_CHRISTMAS_ID);
    @Unique
    private static final Map<Block, SpecialModelRenderer.Unbaked> BLOCK_TO_MODEL_TYPE = ImmutableMap.<Block, SpecialModelRenderer.Unbaked>builder()
            .put(Blocks.CHEST, new ChestModelRenderer.Unbaked(ChestModelRenderer.NORMAL_ID))
            .put(Blocks.TRAPPED_CHEST, new ChestModelRenderer.Unbaked(ChestModelRenderer.TRAPPED_ID))
            .build();

    @Inject(method = "buildBlockToModelTypeMap", at = @At("RETURN"), cancellable = true)
    private static void buildBlockToModelTypeMapMixin(LoadedEntityModels entityModels, CallbackInfoReturnable<Map<Block, SpecialModelRenderer<?>>> cir) {
        Map<Block, SpecialModelRenderer.Unbaked> map = new HashMap<>(BLOCK_TO_MODEL_TYPE);
        if (ChestBlockEntityRenderer.isAroundChristmas()) {
            map.put(Blocks.CHEST, CHRISTMAS_CHEST);
            map.put(Blocks.TRAPPED_CHEST, TRAPPED_CHRISTMAS_CHEST);
        }

        ImmutableMap.Builder<Block, SpecialModelRenderer<?>> builder = ImmutableMap.builder();
        map.forEach((block, modelType) -> {
            SpecialModelRenderer<?> specialModelRenderer = modelType.bake(entityModels);
            if (specialModelRenderer != null) {
                builder.put(block, specialModelRenderer);
            }
        });
        cir.setReturnValue(builder.build());
    }
}