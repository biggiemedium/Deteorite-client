package dev.px.deteorite.Util.Interfaces;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.world.World;

public interface Util {

    Minecraft mc = Minecraft.getMinecraft();
    EntityPlayerSP player = mc.player;
    World world = mc.world;

}
