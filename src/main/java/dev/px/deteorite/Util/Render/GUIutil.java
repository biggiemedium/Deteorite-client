package dev.px.deteorite.Util.Render;

import dev.px.deteorite.Deteorite;
import dev.px.deteorite.Function.ClickGUI.ClickGUI;
import dev.px.deteorite.Function.Module.Other.ClickGUIModule;
import dev.px.deteorite.Util.Interfaces.Util;
import net.minecraft.client.gui.GuiChat;

public class GUIutil implements Util {

    public static boolean isChatOpen() {
        return mc.currentScreen instanceof GuiChat;
    }

    public static boolean isClickGUIOpen() {
        return mc.currentScreen instanceof ClickGUI;
    }

}
