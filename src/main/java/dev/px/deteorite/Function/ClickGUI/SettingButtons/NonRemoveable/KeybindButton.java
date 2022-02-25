package dev.px.deteorite.Function.ClickGUI.SettingButtons.NonRemoveable;

import dev.px.deteorite.Function.ClickGUI.Constructors.Element;
import dev.px.deteorite.Function.ClickGUI.ModuleButton;
import org.lwjgl.input.Keyboard;

public class KeybindButton extends Element {

    private int key;
    private boolean changeable;

    public KeybindButton(ModuleButton button, int x, int y) {
        super(button, x, y, button.getWidth(), 13);
        changeable = false;
        this.key = -1;
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        String s = changeable ? "Press key..." : Keyboard.getKeyName((this.getModuleButton().getModule().getKey()));
    }
}
