package virtuoel.pehkui.mixin.client.compat1202plus;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.packet.s2c.play.CommonPlayerSpawnInfo;
import net.minecraft.network.packet.s2c.play.PlayerRespawnS2CPacket;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import virtuoel.pehkui.util.ScaleUtils;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin
{
	@Inject(method = "onPlayerRespawn(Lnet/minecraft/network/packet/s2c/play/PlayerRespawnS2CPacket;)V", locals = LocalCapture.CAPTURE_FAILHARD, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;init()V"))
	private void pehkui$onPlayerRespawn(PlayerRespawnS2CPacket packet, CallbackInfo info, CommonPlayerSpawnInfo spawnInfo, RegistryKey<World> dimension, RegistryEntry<DimensionType> dimensionType, ClientPlayerEntity oldPlayer, ClientPlayerEntity newPlayer)
	{
		ScaleUtils.loadScaleOnRespawn(newPlayer, oldPlayer, packet.hasFlag((byte) 1));
	}
}
