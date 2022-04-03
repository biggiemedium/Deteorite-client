package dev.px.deteorite.Function.HUD.HUDRenderer;

import dev.px.deteorite.Deteorite;
import dev.px.deteorite.Function.HUD.HUD;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;
import java.util.ArrayList;

public class HUDScreen extends GuiScreen {

    public HUDScreen() {

    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        for(HUD hud : Deteorite.HUDManager.getElements()) {
            if(hud.isVisible()) {
                hud.render(mouseX, mouseY, partialTicks);
            }
        }
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        for(HUD hud : Deteorite.HUDManager.getElements()) {
            hud.mouseClick(mouseX, mouseY, mouseButton);
        }
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {

    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
