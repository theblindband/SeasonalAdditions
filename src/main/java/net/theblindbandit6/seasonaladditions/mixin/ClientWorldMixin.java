package net.theblindbandit6.seasonaladditions.mixin;

import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.world.ClientWorld;
import net.theblindbandit6.seasonaladditions.client.recipebook.ClientModRecipeManager;
import net.theblindbandit6.seasonaladditions.interfaces.ModRecipeManagerGetter;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ClientWorld.class)
public class ClientWorldMixin implements ModRecipeManagerGetter {

    @Shadow @Final
    private ClientPlayNetworkHandler networkHandler;

    @Override
    public ClientModRecipeManager seasonalAdditions$getModRecipeManager() {
        return ((ModRecipeManagerGetter)networkHandler).seasonalAdditions$getModRecipeManager();
    }
}
