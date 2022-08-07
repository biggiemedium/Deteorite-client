package dev.px.deteorite.GUI.GUI2;

import dev.px.deteorite.Deteorite;
import dev.px.deteorite.Function.Module.Other.ClickGUIModule;
import dev.px.deteorite.GUI.GUI2.Components.Panel;
import dev.px.deteorite.GUI.GUI2.Components.Panels.MainScreenPanel;
import dev.px.deteorite.GUI.GUI2.Components.Panels.ModulePanel;
import dev.px.deteorite.Util.Render.Renderutil;
import dev.px.deteorite.Util.Wrapper;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class ClickGUI2 extends GuiScreen {

    public ClickGUI2() {

        this.panels.add(this.currentPanel = new MainScreenPanel());
        this.panels.add(new ModulePanel());
    }

    private ArrayList<Panel> panels = new ArrayList<>();
    private Panel currentPanel;

    /*
    We must make visuals for panels
     */
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {

        int x = 0;

        for(Panel p : this.panels) {
            int renderX = (new ScaledResolution(Wrapper.getMC()).getScaledWidth() / 2) + x - (panels.size() * mc.fontRenderer.FONT_HEIGHT);
            if(p == this.currentPanel) {
                // highlight current selected panel
                Renderutil.drawRect(renderX - 2, 3, renderX + Deteorite.fontRenderer.getStringWidth(p.getName()) + 5, 15, new Color(ClickGUIModule.INSTANCE.buttonred.getValue(), ClickGUIModule.INSTANCE.buttongreen.getValue(), ClickGUIModule.INSTANCE.buttonblue.getValue(), 200).darker().getRGB());
            }

            if(p != this.currentPanel) {
                Renderutil.drawRect(renderX - 2, 3, renderX + Deteorite.fontRenderer.getStringWidth(p.getName()) + 5, 15, new Color(ClickGUIModule.INSTANCE.red.getValue(), ClickGUIModule.INSTANCE.green.getValue(), ClickGUIModule.INSTANCE.blue.getValue(), 150).getRGB());
            }
            Deteorite.fontRenderer.drawStringWithShadow(p.getName(), renderX, 5, -1);
            x += mc.fontRenderer.getStringWidth(p.getName()) + 2;
        }

        this.currentPanel.draw(mouseX, mouseY);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {

        int x = 0;

        for(Panel p : this.panels) {
            int renderX = (new ScaledResolution(Wrapper.getMC()).getScaledWidth() / 2) + x - (panels.size() * mc.fontRenderer.FONT_HEIGHT);
            if(isHovered(mouseX, mouseY, renderX - 2, 2, renderX + Deteorite.fontRenderer.getStringWidth(p.getName()), 18)) {
                this.currentPanel = p;
            }
            x += mc.fontRenderer.getStringWidth(p.getName()) + mc.fontRenderer.FONT_HEIGHT;
        }

        this.currentPanel.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        this.currentPanel.keyTyped(typedChar, keyCode);
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
        this.currentPanel.mouseReleased(mouseX, mouseY, state);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    public boolean isHovered(int mouseX, int mouseY, int x, int y, int width, int height) {
        return (mouseX >= x && mouseX <= (x + width)) && (mouseY >= y && mouseY <= (y + height));
    }

    public ArrayList<Panel> getPanels() {
        return panels;
    }

    public void setPanels(ArrayList<Panel> panels) {
        this.panels = panels;
    }

    public Panel getCurrentPanel() {
        return currentPanel;
    }

    public void setCurrentPanel(Panel currentPanel) {
        this.currentPanel = currentPanel;
    }
}
