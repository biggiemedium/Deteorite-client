package dev.px.deteorite.GUI.GUI2.Components;

import dev.px.deteorite.Util.Interfaces.IComponent;
import dev.px.deteorite.Util.Wrapper;
import net.minecraft.client.Minecraft;

import java.io.IOException;

public class Panel implements IComponent {

    private String name;

    public Panel(String name) {
        this.name = name;
    }

    public Panel() {
        this.name = "";
    }

    @Override
    public void draw(int mouseX, int mouseY) {

    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) throws IOException {

    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int state) {

    }

    @Override
    public void keyTyped(char typedChar, int keyCode) throws IOException {

    }

    public String getName() {
        return name;
    }

    public boolean isNameValid() {
        return !(this.name).equals("");
    }

    protected Minecraft mc = Wrapper.getMC();
}
