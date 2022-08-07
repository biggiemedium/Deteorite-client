package dev.px.deteorite.Function.Module.Other;

import dev.px.deteorite.Function.Module.Module;
import dev.px.deteorite.Function.Value.Value;
import dev.px.deteorite.GUI.GUI2.ClickGUI2;
import org.lwjgl.input.Keyboard;

import java.awt.*;

public class Test extends Module {

    public Test() {
        super("Test", Type.Other);
        setKey(Keyboard.KEY_RCONTROL);
    }

    Value<Boolean> bTest = create("Render", false);
    Value<Boolean> aTest = create("Rainbow", true, v -> bTest.getValue());
    Value<Mode> mode = create("Mode", Mode.NCP, v -> aTest.getValue());
    Value<Color> color = create("Color", new Color(71, 201, 176));



    private enum Mode {
        NCP,
        Vanilla
    }

    @Override
    public void onEnabled() {
        mc.displayGuiScreen(new ClickGUI2());
        disable();
        super.onEnabled();
    }
}
