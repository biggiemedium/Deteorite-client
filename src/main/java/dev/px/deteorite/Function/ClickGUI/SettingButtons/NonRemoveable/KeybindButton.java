package dev.px.deteorite.Function.ClickGUI.SettingButtons.NonRemoveable;

import dev.px.deteorite.Function.ClickGUI.Constructors.Element;
import dev.px.deteorite.Function.ClickGUI.ModuleButton;
import dev.px.deteorite.Util.Render.Fontutil;
import dev.px.deteorite.Util.Render.Renderutil;
import org.lwjgl.input.Keyboard;

import java.awt.*;
import java.io.IOException;

public class KeybindButton extends Element {

    private int key;
    private boolean changeable;

    public KeybindButton(ModuleButton button, int x, int y) {
        super(button, x, y, button.getWidth(), 13);
        this.changeable = false;
        this.key = -1;
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        Renderutil.drawRect(getX(), getY(), getX() + 2, getY() + getHeight(), new Color(15, 15, 15, 195).getRGB());
        Renderutil.drawRect(getX() + 2, getY(), getX() + 2 + getWidth(), getY() + getHeight() - 1, handleColor(mouseX, mouseY));
        Renderutil.drawRect(getX() + 2, getY() + getHeight() - 1, getX() + 2 + getWidth(), getY() + getHeight(), new Color(10, 10, 10, 200).getRGB());

        String s = this.changeable ? "Press key..." : ("Key" + Keyboard.getKeyName((this.getModuleButton().getModule().getKey())));
        Fontutil.drawString(font(), s, getX() + 4, getY() + 2, -1);
    }

    private int handleColor(int mouseX, int mouseY) {
        Color color = this.changeable ? new Color(getColor()) : new Color(50, 50, 50, 200);
        return mouseX > getX() + 2 && mouseY > getY() && mouseX < getX() + 2 + getWidth() && mouseY < getY() + getHeight() - 1 ? (this.changeable ? color.darker().darker().getRGB() : color.brighter().brighter().getRGB()) : color.getRGB();
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) throws IOException {
        if(isHovered(mouseX, mouseY)) {
            if(button == 0 && this.getModuleButton().isOpen()) {
                if(!changeable) {
                    this.changeable = true;
                } else { this.changeable = false; }
            } else if(button == 1 && this.getModuleButton().isOpen()) {
                this.changeable = !changeable;
            }
        }
    }

    @Override
    public void keyTyped(char typedChar, int keyCode) throws IOException {
        this.key = keyCode;

        if(this.changeable) {
            if(keyCode > 0 && keyCode != Keyboard.KEY_ESCAPE) {
                // if key returns null / other errors replace this.key with keyCode
            /*
            keycode 211 is escape key
             */
                if (this.key == Keyboard.KEY_BACK || this.key == 211) {
                    this.getModuleButton().getModule().setKey(-1);
                } else {
                    this.getModuleButton().getModule().setKey(this.key);
                }
            }
            this.changeable = false;
        }
    }
}
