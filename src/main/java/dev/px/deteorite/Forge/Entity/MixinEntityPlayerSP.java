package dev.px.deteorite.Forge.Entity;

import dev.px.deteorite.Event.Player.PlayerUpdateEvent;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityPlayerSP.class)
public class MixinEntityPlayerSP {

    @Inject(method = "onUpdate", at = @At("HEAD"), cancellable = true)
    public void onUpdate(CallbackInfo ci) {
        PlayerUpdateEvent packet = new PlayerUpdateEvent();
        MinecraftForge.EVENT_BUS.post(packet);
        if(packet.isCanceled()) {
            ci.cancel();
        }
    }

}
