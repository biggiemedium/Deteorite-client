package dev.px.deteorite.Function.ClickGUI.Constructors;

import dev.px.deteorite.Function.ClickGUI.ModuleButton;
import dev.px.deteorite.Function.Value.Value;
import dev.px.deteorite.Util.Interfaces.IComponent;

import java.io.IOException;

public class Component extends WidgetConstructor implements IComponent {

    public void update() {}

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

    protected boolean isHovered2(int mouseX, int mouseY, int x, int y, int width, int height) {
        return mouseX > x && mouseY > y && mouseX < x + width && mouseY < y + height;
    }
}
