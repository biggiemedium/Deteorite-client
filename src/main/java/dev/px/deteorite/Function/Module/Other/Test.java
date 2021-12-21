package dev.px.deteorite.Function.Module.Other;

import dev.px.deteorite.Function.Module.Module;
import dev.px.deteorite.Function.Value.Value;

public class Test extends Module {

    public Test() {
        super("Test", Type.Other);
    }

    Value<Boolean> bTest = create("Render", false);
    Value<Boolean> aTest = create("Rainbow", true, v -> bTest.getValue());
    Value<Mode> mode = create("Mode", Mode.NCP, v -> aTest.getValue());


    private enum Mode {
        NCP,
        Vanilla
    }

}
