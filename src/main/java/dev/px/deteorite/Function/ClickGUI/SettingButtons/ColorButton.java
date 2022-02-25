package dev.px.deteorite.Function.ClickGUI.SettingButtons;

import dev.px.deteorite.Function.ClickGUI.Constructors.Element;
import dev.px.deteorite.Function.ClickGUI.ModuleButton;
import dev.px.deteorite.Function.Value.Value;

import java.awt.*;
import java.io.IOException;

public class ColorButton extends Element {

    private Value<Color> value;

    public ColorButton(Value<Color> value, int x, int y, ModuleButton button) {
        super(value, button, x, y, button.getWidth(), 13);
        this.value = value;
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

    private void drawPicker(Value<Color> value, int mouseX, int mouseY) {
        float[] colors = {

        };

    }
}
