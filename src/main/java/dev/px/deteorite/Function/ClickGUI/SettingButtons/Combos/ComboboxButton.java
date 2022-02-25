package dev.px.deteorite.Function.ClickGUI.SettingButtons.Combos;

import dev.px.deteorite.Function.ClickGUI.Constructors.Element;
import dev.px.deteorite.Function.ClickGUI.ModuleButton;
import dev.px.deteorite.Function.Value.Value;

import java.util.ArrayList;

public class ComboboxButton extends Element {

    private ArrayList<String> values;

    public ComboboxButton(Value<String> value, int x, int y, ModuleButton button) {
        super(value, button, x, y, button.getWidth(), 13);
        this.values = new ArrayList<>();
    }


}
