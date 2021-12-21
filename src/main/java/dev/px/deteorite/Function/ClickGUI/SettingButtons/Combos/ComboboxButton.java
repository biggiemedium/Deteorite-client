package dev.px.deteorite.Function.ClickGUI.SettingButtons.Combos;

import dev.px.deteorite.Function.ClickGUI.Constructors.Component;
import dev.px.deteorite.Function.ClickGUI.ModuleButton;
import dev.px.deteorite.Function.Value.Value;

public class ComboboxButton extends Component {

    public ComboboxButton(Value<String> value, int x, int y, ModuleButton button) {
        super(value, button, x, y, button.getWidth(), 13);
    }

}
