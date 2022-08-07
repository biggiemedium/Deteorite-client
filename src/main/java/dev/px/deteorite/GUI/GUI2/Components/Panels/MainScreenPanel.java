package dev.px.deteorite.GUI.GUI2.Components.Panels;

import dev.px.deteorite.GUI.GUI2.Components.Panel;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.opengl.GL11;

public class MainScreenPanel extends Panel {

    public MainScreenPanel() {
        super("Home Screen");
    }

    @Override
    public void draw(int mouseX, int mouseY) {

        String playername = mc.player.getName() == null ? "!" : " " + mc.player.getName();
        float offset = 2.25f;

        GL11.glPushMatrix();
        GL11.glScaled(offset, offset, 1);
        mc.fontRenderer.drawStringWithShadow("Welcome" + playername, new ScaledResolution(mc).getScaledWidth() / 2 - mc.fontRenderer.getStringWidth("Welcome" + playername) * offset, 25, -1);
        GL11.glPopMatrix();
    }
}
