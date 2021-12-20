package dev.px.deteorite.Util.Render;

import java.awt.*;

public class Colorutil {

    public static int Rainbow(int delay) { // example Rainbow(counter[0] * 300)
        double RainbowState = Math.ceil((System.currentTimeMillis() + delay) / 20.0);
        RainbowState %= 360;
        return Color.getHSBColor((float) (RainbowState / 360.0f), 0.5f, 1.0f).getRGB();
    }

    public static int changeAlpha(int origColor, int userInputedAlpha) {
        origColor &= 0xFFFFFF;
        return userInputedAlpha << 24 | origColor;
    }

}
