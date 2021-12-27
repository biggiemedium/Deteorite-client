package dev.px.deteorite.Event.Handler;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.px.deteorite.Deteorite;
import dev.px.deteorite.Command.Command;
import dev.px.deteorite.Function.Module.Module;
import dev.px.deteorite.Util.Wrapper;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class EventProcessor {

    private Minecraft mc = Minecraft.getMinecraft();

    public EventProcessor() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void keyEvent(InputEvent event) {
        if(mc.player == null || mc.world == null) return;

        try {
            if(Keyboard.isCreated()) {
                if(Keyboard.getEventKeyState()) {
                    int keyCode = Keyboard.getEventKey();
                    if(keyCode <= 0)
                        return;
                    for(Module m : Deteorite.moduleManager.modules) {
                        if(m.getKey() == keyCode && keyCode > 0) {
                            m.toggle();
                        }
                    }
                }
            }
        } catch (Exception q) { q.printStackTrace(); }
    }

    @SubscribeEvent
    public void onChat(ClientChatEvent event) {
        if(event.getMessage().startsWith(Command.getPrefix())) {
            event.setCanceled(true);

            try {
                mc.ingameGUI.getChatGUI().addToSentMessages(event.getMessage());
                Deteorite.commandManager.callCommand(event.getMessage().substring(1));
            }
            catch (Exception e) {
                e.printStackTrace();
                Wrapper.sendClientMessage(ChatFormatting.DARK_RED + "Error: " + e.getMessage());
            }
        }
    }
}
