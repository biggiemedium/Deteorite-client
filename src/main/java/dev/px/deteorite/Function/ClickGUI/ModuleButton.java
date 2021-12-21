package dev.px.deteorite.Function.ClickGUI;

import dev.px.deteorite.Function.ClickGUI.Constructors.Component;
import dev.px.deteorite.Function.ClickGUI.SettingButtons.Combos.EnumButton;
import dev.px.deteorite.Function.ClickGUI.SettingButtons.Sliders.DoubleSlider;
import dev.px.deteorite.Function.ClickGUI.SettingButtons.Sliders.FloatSlider;
import dev.px.deteorite.Function.ClickGUI.SettingButtons.Sliders.IntegerSlider;
import dev.px.deteorite.Function.ClickGUI.SettingButtons.ToggleButton;
import dev.px.deteorite.deteorite;
import dev.px.deteorite.Function.ClickGUI.Constructors.WidgetConstructor;
import dev.px.deteorite.Function.Module.Module;
import dev.px.deteorite.Function.Value.Value;
import dev.px.deteorite.Util.Interfaces.IComponent;
import dev.px.deteorite.Util.Render.Fontutil;
import dev.px.deteorite.Util.Render.Renderutil;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class ModuleButton extends WidgetConstructor implements IComponent {

    private int x, y;
    private int width, height;
    private boolean open;

    private Module module;
    private Frame frame;

    public ArrayList<Component> components;

    public ModuleButton(Module module, Frame frame, int x, int y) {
        this.module = module;
        this.frame = frame;
        this.open = false;
        this.x = x;
        this.y = y;
        this.width = frame.getWidth();
        this.height = 13;
        this.open = false;

        this.components = new ArrayList<>();
        if(deteorite.valueManager.getValueForMod(module) != null && !deteorite.valueManager.values.isEmpty()) {
            for (Value v : deteorite.valueManager.getValueForMod(module)) {
                if(v.getValue() instanceof Boolean) {
                    this.components.add(new ToggleButton(v, x, y, this));
                }
                if(v.getValue() instanceof Integer) {

                }
                if(v.getValue() instanceof Enum) {
                    this.components.add(new EnumButton(v, x,  y, this));
                }
                if(v.getValue() instanceof Integer) {
                    this.components.add(new IntegerSlider(v, x, y, this));
                }
                if(v.getValue() instanceof Float) {
                    this.components.add(new FloatSlider(v, x, y, this));
                }
                if(v.getValue() instanceof Double) {
                    this.components.add(new DoubleSlider(v, x, y, this));
                }
            }
        }
    }

    @Override
    public void draw(int mouseX, int mouseY) {

        Renderutil.drawRect(x, y, x + width, y + 12, toggledColor(module, mouseX, mouseY, x, y, width, height));
        Renderutil.drawRect(x, y + 12, x + width, y + 13, new Color(10, 10, 10, 200).getRGB());
        Fontutil.drawStringWithShadow(font(), module.getName(), x + 2, y + 2, -1);

        /**
         * Code follows same format as my old client (Leapfrog)
         */

        this.height = 13;
        if (open) {
            for (Component c : this.components) {
                if (c.isVisible()) {
                    if (c.getX() != x) {
                        c.setX(x);
                    }
                    if (c.getY() != y) {
                        c.setY(y + height);
                    }

                    c.draw(mouseX, mouseY);
                    height += c.getHeight();
                }
            }
        }
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) throws IOException {
        if(mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + 13){
            if(button == 0){
                module.toggle();
            } else if(button == 1){
                open = !open;
            }
            return;
        }

        if(open) {
            for(Component b : components){
                b.mouseClicked(mouseX, mouseY, button);
            }
        }
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int state) {
        for(Component c : components) {
            c.mouseReleased(mouseX, mouseY, state);
        }
    }

    @Override
    public void keyTyped(char typedChar, int keyCode) throws IOException {
        for(Component c : components) {
            c.keyTyped(typedChar, keyCode);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }
}
