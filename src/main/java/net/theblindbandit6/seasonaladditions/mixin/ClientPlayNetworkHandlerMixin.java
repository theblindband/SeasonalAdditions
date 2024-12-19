package net.theblindbandit6.seasonaladditions.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientCommonNetworkHandler;
import net.minecraft.client.network.ClientConnectionState;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.NetworkThreadUtils;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.theblindbandit6.seasonaladditions.client.recipebook.ClientModRecipeManager;
import net.theblindbandit6.seasonaladditions.interfaces.MinecraftClientGetter;
import net.theblindbandit6.seasonaladditions.interfaces.ModRecipeManagerGetter;
import net.theblindbandit6.seasonaladditions.network.listener.ModClientPlayPacketListener;
import net.theblindbandit6.seasonaladditions.network.packet.s2c.play.SynchronizeModRecipesS2CPacket;
import net.theblindbandit6.seasonaladditions.recipe.display.IcecuttingRecipeDisplay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Environment(EnvType.CLIENT)
@Mixin(ClientPlayNetworkHandler.class)
public abstract class ClientPlayNetworkHandlerMixin extends ClientCommonNetworkHandler implements ClientPlayPacketListener, ModClientPlayPacketListener, ModRecipeManagerGetter {

    @Unique
    private ClientModRecipeManager modRecipeManager = new ClientModRecipeManager(IcecuttingRecipeDisplay.Grouping.empty());

    protected ClientPlayNetworkHandlerMixin(MinecraftClient client, ClientConnection connection, ClientConnectionState connectionState) {
        super(client, connection, connectionState);
    }

    @Override
    public ClientModRecipeManager seasonalAdditions$getModRecipeManager() {
        return this.modRecipeManager;
    }

    @Override
    public void seasonalAdditions$onSynchronizeModRecipes(SynchronizeModRecipesS2CPacket packet) {
        MinecraftClient client = ((MinecraftClientGetter)this).seasonalAdditions$getMinecraftClient();
        NetworkThreadUtils.forceMainThread(packet, this, client);
        this.modRecipeManager = new ClientModRecipeManager(packet.icecuttingRecipes());
    }
}
