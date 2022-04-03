package dev.px.deteorite.Forge.Network;

import dev.px.deteorite.Event.Network.PacketEvent;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetworkManager.class)
public class MixinNetworkManager {


    @Inject(method = "channelRead0", at = @At("HEAD"), cancellable = true)
    private void receive(ChannelHandlerContext context, Packet<?> packet, CallbackInfo callback) {
        PacketEvent eventPacket = new PacketEvent.ReceivePacket(packet);

        MinecraftForge.EVENT_BUS.post(eventPacket);

        if (eventPacket.isCanceled()) {
            callback.cancel();
        }
    }

    @Inject(method = "sendPacket(Lnet/minecraft/network/Packet;)V", at = @At("HEAD"), cancellable = true)
    private void send(Packet<?> packet, CallbackInfo callback) {
        PacketEvent eventPacket = new PacketEvent.SendPacket(packet);

        MinecraftForge.EVENT_BUS.post(eventPacket);

        if (eventPacket.isCanceled()) {
            callback.cancel();
        }
    }
}
