package dev.px.deteorite.Forge;

import dev.px.deteorite.Command.Command;
import dev.px.deteorite.GUI.CommandBox;
import dev.px.deteorite.Util.Render.GUIutil;
import dev.px.deteorite.Util.Wrapper;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiTextField;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiChat.class)
public abstract class MixinGuiChat {

    @Shadow
    protected GuiTextField inputField;

    @Shadow public String historyBuffer;

    @Shadow public int sentHistoryCursor;

    @Shadow public abstract void initGui();

    @Inject(method = "Lnet/minecraft/client/gui/GuiChat;keyTyped(CI)V", at = @At("RETURN"))
    public void keyTyped(char typedChar, int keyCode, CallbackInfo ci) {
        if(GUIutil.isChatOpen()) {
            if(inputField.getText().startsWith(Command.getPrefix())) {
                Wrapper.getMC().displayGuiScreen(new CommandBox(inputField.getText(), historyBuffer, sentHistoryCursor));
            }
        }
    }

}
