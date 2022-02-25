package dev.px.deteorite.Function.ClickGUI.SettingButtons;

import dev.px.deteorite.Function.ClickGUI.Constructors.Element;
import dev.px.deteorite.Function.ClickGUI.ModuleButton;
import dev.px.deteorite.Function.Value.Value;
import dev.px.deteorite.Util.Render.Fontutil;
import dev.px.deteorite.Util.Render.Renderutil;

import java.awt.*;
import java.io.IOException;

public class ToggleButton extends Element {

    private Value<Boolean> value;

    public ToggleButton(Value<Boolean> value, int x, int y, ModuleButton button) {
        super(value, button, x, y, button.getWidth(), 13);
        this.value = value;
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        Renderutil.drawRect(getX(), getY(), getX() + 2, getY() + getHeight(), new Color(15, 15, 15, 195).getRGB());
        Renderutil.drawRect(getX() + 2, getY(), getX() + 2 + getWidth(), getY() + getHeight() - 1, handleColor(mouseX, mouseY));
        Renderutil.drawRect(getX() + 2, getY() + getHeight() - 1, getX() + 2 + getWidth(), getY() + getHeight(), new Color(10, 10, 10, 200).getRGB());
        Fontutil.drawString(font(), value.getName(), getX() + 4, getY() + 2, -1);
    }

    private int handleColor(int mouseX, int mouseY) {
        Color color = value.getValue() ? new Color(getColor()) : new Color(50, 50, 50, 200);
        return mouseX > getX() + 2 && mouseY > getY() && mouseX < getX() + 2 + getWidth() && mouseY < getY() + getHeight() - 1 ? (value.getValue() ? color.darker().darker().getRGB() : color.brighter().brighter().getRGB()) : color.getRGB();
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) throws IOException {
        if(button == 0 && isHovered(mouseX, mouseY)) {
            value.setValue(!value.getValue());
        }
    }
}
