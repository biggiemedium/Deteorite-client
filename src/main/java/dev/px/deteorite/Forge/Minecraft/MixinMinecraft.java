package dev.px.deteorite.Forge.Minecraft;

import dev.px.deteorite.Deteorite;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {

    @Inject(method = "shutdown", at = @At("HEAD"), cancellable = true)
    public void onShutdown(CallbackInfo ci) {
        Deteorite.configManager.saves();
    }

}
