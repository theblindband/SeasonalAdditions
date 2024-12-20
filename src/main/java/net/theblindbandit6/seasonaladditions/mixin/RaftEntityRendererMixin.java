package net.theblindbandit6.seasonaladditions.mixin;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import net.minecraft.client.render.entity.RaftEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.BoatEntityRenderState;
import net.minecraft.util.Identifier;
import net.theblindbandit6.seasonaladditions.SeasonalAdditions;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(RaftEntityRenderer.class)
public final class RaftEntityRendererMixin {

    @Shadow @Final private EntityModel<BoatEntityRenderState> model;

    @Shadow @Final private Identifier texture;

    @Inject(at = @At(value = "RETURN"), method = "getRenderLayer", cancellable = true)
    private void getRenderLayer(final CallbackInfoReturnable<RenderLayer> callbackInfoReturnable) {
        if(ChestBlockEntityRenderer.isAroundChristmas()) {
            String chestBoat = getPenultimateEntry(this.texture);
            if (Objects.equals(chestBoat, "chest_boat")) {
                String textureName = getTextureName(this.texture);
                callbackInfoReturnable.setReturnValue(this.model.getLayer(SeasonalAdditions.identifier("textures/entity/chest_boat/christmas_" + textureName)));
            }
        }
    }

    public String getTextureName(Identifier texture) {
        String path = texture.getPath();
        int lastSlashIndex = path.lastIndexOf('/');
        if (lastSlashIndex == -1) {
            return path; // No slashes in the path, return the whole path
        }
        return path.substring(lastSlashIndex + 1); // Extract the file name
    }

    @Unique
    public String getPenultimateEntry(Identifier texture) {
        String path = texture.getPath();
        String[] parts = path.split("/");
        if (parts.length < 2) {
            return path; // If there are less than 2 parts, return the whole path
        }
        return parts[parts.length - 2]; // Return the penultimate entry
    }
}