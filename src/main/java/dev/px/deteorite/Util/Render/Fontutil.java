package dev.px.deteorite.Util.Render;

import dev.px.deteorite.deteorite;
import dev.px.deteorite.Util.Interfaces.Util;

public class Fontutil implements Util {

    public static float drawStringWithShadow(boolean customFont, String text, int x, int y, int color) {
        if (customFont) return deteorite.fontRenderer.drawStringWithShadow(text, x, y, color);
        else return mc.fontRenderer.drawStringWithShadow(text, x, y, color);
    }

    public static float drawString(String text, int x, int y, int color) {
        return deteorite.fontRenderer.drawStringWithShadow(text, x, y, color);
    }

    public static float drawString(boolean customFont, String text, int x, int y, int color) {
        if (customFont) return deteorite.fontRenderer.drawString(text, x, y, color);
        else return mc.fontRenderer.drawString(text, x, y, color);
    }

    public static int getStringWidth(boolean customFont, String str) {
        if (customFont) return deteorite.fontRenderer.getStringWidth(str);
        else return mc.fontRenderer.getStringWidth(str);
    }


    public static int getFontHeight(boolean customFont) {
        if (customFont) return deteorite.fontRenderer.getHeight();
        else return mc.fontRenderer.FONT_HEIGHT;
    }

}
