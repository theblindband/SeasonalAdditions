package net.theblindbandit6.seasonaladditions.mixin;

import net.minecraft.network.NetworkStateBuilder;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.state.PlayStateFactories;
import net.theblindbandit6.seasonaladditions.network.packet.ModPlayPackets;
import net.theblindbandit6.seasonaladditions.network.packet.s2c.play.SynchronizeModRecipesS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.function.Consumer;

@Mixin(PlayStateFactories.class)
public class PlayStateFactoriesMixin {

    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/NetworkStateBuilder;s2c(Lnet/minecraft/network/NetworkPhase;Ljava/util/function/Consumer;)Lnet/minecraft/network/NetworkState$Factory;"))
    private static Consumer<NetworkStateBuilder<ClientPlayPacketListener, RegistryByteBuf>> sc2(Consumer<NetworkStateBuilder<ClientPlayPacketListener, RegistryByteBuf>> registrar) {
        return registrar.andThen(builder -> builder.add(ModPlayPackets.UPDATE_RECIPES, SynchronizeModRecipesS2CPacket.CODEC));
    }
}
