package dev.px.deteorite.Function.Module.Other;

import dev.px.deteorite.Function.ClickGUI.ClickGUI;
import dev.px.deteorite.Function.Module.Module;
import dev.px.deteorite.Function.Value.Value;
import org.lwjgl.input.Keyboard;

public class ClickGUIModule extends Module {

    public ClickGUIModule() {
        super("ClickGUI", Type.Other);
        setKey(Keyboard.KEY_RSHIFT);
        INSTANCE = this;
    }

    public Value<Boolean> customFont = create("Custom Font", true);

    public Value<Boolean> rainbow = create("Rainbow", false);
    public Value<Integer> rainbowSpeed = create("Rainbow Speed", 300, 100, 400, v -> rainbow.getValue());

    public Value<Integer> red = create("Red", 255, 0, 255, v -> !rainbow.getValue());
    public Value<Integer> green = create("Green", 192, 0, 255, v -> !rainbow.getValue());
    public Value<Integer> blue = create("Green", 203, 0, 255, v -> !rainbow.getValue());

    public Value<Integer> buttonred = create("Button Red", 50, 0, 255, v -> !rainbow.getValue());
    public Value<Integer> buttongreen = create("Button Green", 50, 0, 255, v -> !rainbow.getValue());
    public Value<Integer> buttonblue = create("Button Green", 50, 0, 255, v -> !rainbow.getValue());

    public static ClickGUIModule INSTANCE;

    @Override
    public void onEnabled() {
        mc.displayGuiScreen(new ClickGUI());
    }
}
