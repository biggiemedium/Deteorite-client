package dev.px.deteorite.Function.ClickGUI;

import dev.px.deteorite.Function.Module.Module;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;
import java.util.ArrayList;

public class ClickGUI extends GuiScreen {

    private ArrayList<Frame> frames;

    public ClickGUI() {
        this.frames = new ArrayList<>();

        int offset = 0;
        for(Module.Type t : Module.Type.values()) {
            frames.add(new Frame(t, offset + 10, 20));
            offset += 120;
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        for(Frame f : frames) {
            f.draw(mouseX, mouseY);
        }
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        for(Frame f : frames) {
            f.mouseClicked(mouseX, mouseY, mouseButton);
        }
    }


    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
        for(Frame f : frames) {
            f.mouseReleased(mouseX, mouseY, state);
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
