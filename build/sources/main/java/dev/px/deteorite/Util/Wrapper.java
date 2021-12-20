package dev.px.deteorite.Util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class Wrapper {

    private static Minecraft mc = Minecraft.getMinecraft();

    public static Minecraft getMC() {
        return mc;
    }

    public static EntityPlayerSP getPlayer() {
        return mc.player;
    }

    public static World getWorld() {
        return mc.world;
    }

    public static void sendClientMessage(String message) {
        if(mc.player == null || mc.world == null) return;

        mc.ingameGUI.getChatGUI().printChatMessage(new TextComponentString(message));
    }

}
