package dev.px.deteorite.Function.ClickGUI.SettingButtons.Combos;

import dev.px.deteorite.Function.ClickGUI.Constructors.Component;
import dev.px.deteorite.Function.ClickGUI.ModuleButton;
import dev.px.deteorite.Function.Value.Value;
import dev.px.deteorite.Util.Render.Fontutil;
import dev.px.deteorite.Util.Render.Renderutil;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class EnumButton extends Component {

    private Value<Enum> value;

    public EnumButton(Value<Enum> value, int x, int y, ModuleButton button) {
        super(value, button, x, y, button.getWidth(), 13);
        this.value = value;
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        Renderutil.drawRect(getX(), getY(), getX() + 2, getY() + getHeight(), new Color(15, 15, 15, 195).getRGB());
        Renderutil.drawRect(getX() + 2, getY(), getX() + 2 + getWidth(), getY() + getHeight() - 1, isHovered(mouseX, mouseY) ? new Color(getColor()).darker().getRGB() : getColor());
        Renderutil.drawRect(getX() + 2, getY() + getHeight() - 1, getX() + 2 + getWidth(), getY() + getHeight(), new Color(10, 10, 10, 200).getRGB());
        Fontutil.drawString(font(), value.getName() + " " + value.getValue(), getX() + 4, getY() + 2, -1);
        Fontutil.drawString(font(), "...", getX() + getWidth() - 5, getY() + 2, -1);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) throws IOException {
        if (isHovered(mouseX, mouseY)) {
            List<Enum> values = Arrays.asList(getValues().getEnumConstants());
            int in = values.indexOf(value.getValue());
            if (button == 0) {
                value.setValue(in + 1 < values.size() ? values.get(in + 1) : values.get(0));
            }
        }
    }

    private Class<Enum> getValues() {
        return value.getValue().getDeclaringClass();
    }
}
