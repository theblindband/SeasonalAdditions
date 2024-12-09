package net.theblindbandit6.seasonaladditions.mixin;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.EnderChestBlockEntity;
import net.minecraft.block.entity.TrappedChestBlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import net.theblindbandit6.seasonaladditions.SeasonalAdditions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.client.render.TexturedRenderLayers.NORMAL;
import static net.minecraft.client.render.TexturedRenderLayers.NORMAL_LEFT;
import static net.minecraft.client.render.TexturedRenderLayers.NORMAL_RIGHT;

@Mixin(TexturedRenderLayers.class)
public class TexturedRenderLayerMixin{

    @Unique
    private static final SpriteIdentifier TRAPPED_CHRISTMAS = createChestTextureId("christmas_trapped");
    @Unique
    private static final SpriteIdentifier TRAPPED_CHRISTMAS_LEFT = createChestTextureId("christmas_trapped_left");
    @Unique
    private static final SpriteIdentifier TRAPPED_CHRISTMAS_RIGHT = createChestTextureId("christmas_trapped_right");

    @Inject(at = @At(value = "RETURN"), method = "getChestTextureId(Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/block/enums/ChestType;Z)Lnet/minecraft/client/util/SpriteIdentifier;", cancellable = true)
    private static void getChestTextureId(final BlockEntity blockEntity, final ChestType type, final boolean christmas, final CallbackInfoReturnable<SpriteIdentifier> callbackInfoReturnable) {
        if(christmas) {
            if (blockEntity instanceof EnderChestBlockEntity) {
                callbackInfoReturnable.setReturnValue(new SpriteIdentifier(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, SeasonalAdditions.identifier("entity/chest/christmas_ender")));
            }
            if (blockEntity instanceof TrappedChestBlockEntity) {
                callbackInfoReturnable.setReturnValue(blockEntity instanceof TrappedChestBlockEntity
                        ? getChestTextureId(type, TRAPPED_CHRISTMAS, TRAPPED_CHRISTMAS_LEFT, TRAPPED_CHRISTMAS_RIGHT)
                        : getChestTextureId(type, NORMAL, NORMAL_LEFT, NORMAL_RIGHT));
            }
        }
    }

    @Unique
    private static SpriteIdentifier createChestTextureId(String variant) {
        return new SpriteIdentifier(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, SeasonalAdditions.identifier("entity/chest/" + variant));
    }
    @Unique
    private static SpriteIdentifier getChestTextureId(ChestType type, SpriteIdentifier single, SpriteIdentifier left, SpriteIdentifier right) {
        switch (type) {
            case LEFT:
                return left;
            case RIGHT:
                return right;
            case SINGLE:
            default:
                return single;
        }
    }
}