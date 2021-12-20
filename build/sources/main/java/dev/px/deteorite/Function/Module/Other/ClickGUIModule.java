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

    public Value<Integer> red = create("Red", 255, 0, 255);
    public Value<Integer> green = create("Green", 192, 0, 255);
    public Value<Integer> blue = create("Green", 203, 0, 255);

    public Value<Integer> buttonred = create("Button Red", 50, 0, 255);
    public Value<Integer> buttongreen = create("Button Green", 50, 0, 255);
    public Value<Integer> buttonblue = create("Button Green", 50, 0, 255);

    public static ClickGUIModule INSTANCE;

    @Override
    public void onEnabled() {
        mc.displayGuiScreen(new ClickGUI());
    }
}
