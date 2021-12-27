package dev.px.deteorite.Command;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.px.deteorite.Deteorite;
import dev.px.deteorite.Util.Interfaces.Util;
import net.minecraft.util.text.TextComponentString;

public abstract class Command implements Util {

    protected static String prefix = "?";

    protected void sendMessage(String message) {
        if(mc.player == null || mc.world == null) return;

        mc.ingameGUI.getChatGUI().printChatMessage(new TextComponentString(ChatFormatting.LIGHT_PURPLE + Deteorite.MODID + " > " + ChatFormatting.RESET + message));
    }

    public static String getPrefix() {
        return prefix;
    }

    public static void setPrefix(String p) {
        prefix = p;
    }

    public abstract String[] getArgs();

    public abstract String getSyntax();

    public abstract void exec(String command, String[] args);

}
