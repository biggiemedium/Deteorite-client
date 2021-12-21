package dev.px.deteorite.Function.ClickGUI.SettingButtons.Sliders;

import dev.px.deteorite.Function.ClickGUI.Constructors.Component;
import dev.px.deteorite.Function.ClickGUI.ModuleButton;
import dev.px.deteorite.Function.Value.Value;
import dev.px.deteorite.Util.Render.Fontutil;
import dev.px.deteorite.Util.Render.Renderutil;

import java.awt.*;
import java.io.IOException;
import java.text.DecimalFormat;

public class DoubleSlider extends Component {

    private Value<Double> value;
    private boolean dragging;
    private int w;

    public DoubleSlider(Value<Double> value, int x, int y, ModuleButton button) {
        super(value, button, x ,y ,button.getWidth(), 13);
        this.value = value;
        this.dragging = false;
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        adjustSlider(mouseX);
        Renderutil.drawRect(getX(), getY(), getX() + 2, getY() + getHeight(), new Color(10, 10, 10, 200).getRGB());
        Renderutil.drawRect(getX() + 2, getY(), getX() + 2 + w, getY() + getHeight() - 1, handleColor(mouseX, mouseY));
        Renderutil.drawRect(getX() + 2, getY() + getHeight() - 1, getX() + 2 + getWidth(), getY() + getHeight(), new Color(10, 10, 10, 200).getRGB());
        Fontutil.drawString(font(), value.getName(), getX() + 4, getY() + 2, -1);
        Fontutil.drawString(font(), String.valueOf(value.getValue()), getX() + getWidth() - mc.fontRenderer.getStringWidth(String.valueOf(value.getValue())), getY() + 1, -1);
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int state) {
        this.dragging = false;
    }

    private int handleColor(int mouseX, int mouseY){
        Color color = dragging ? new Color(getColor()) : new Color(50, 50, 50, 200);
        return isHovered(mouseX, mouseY) ? color.darker().darker().getRGB() : color.getRGB();
    }

    private void adjustSlider(int mouseX) {

        // taken from aurora
        float diff = Math.min(getWidth(), Math.max(0, mouseX - getX()));

        double min = value.getMin();
        double max = value.getMax();

        this.w = (int) (getModuleButton().getWidth() * (value.getValue() - min) / (max - min));
        if(dragging) {
            if(diff == 0.0) {
                this.value.setValue(value.getMin());
            } else {
                DecimalFormat format = new DecimalFormat("##.0");
                String newValue = format.format(((diff / getWidth()) * (max - min) + min));
                this.value.setValue(Double.parseDouble(newValue));
            }
        }
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) throws IOException {
        if(isHovered(mouseX, mouseY)) {
            this.dragging = true;
        }
    }

}
