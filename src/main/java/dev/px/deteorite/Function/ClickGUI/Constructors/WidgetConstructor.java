package dev.px.deteorite.Function.ClickGUI.Constructors;

import dev.px.deteorite.Function.Module.Module;
import dev.px.deteorite.Function.Module.Other.ClickGUIModule;
import dev.px.deteorite.Util.Render.Renderutil;
import net.minecraft.client.Minecraft;

import java.awt.*;

public class WidgetConstructor {

    protected Minecraft mc = Minecraft.getMinecraft();

    public int getColor() {
        return new Color(ClickGUIModule.INSTANCE.buttonred.getValue(), ClickGUIModule.INSTANCE.buttongreen.getValue(), ClickGUIModule.INSTANCE.buttonblue.getValue(), 200).getRGB();
    }

    public int getColorHighlighted() {
        return new Color(ClickGUIModule.INSTANCE.buttonred.getValue(), ClickGUIModule.INSTANCE.buttongreen.getValue(), ClickGUIModule.INSTANCE.buttonblue.getValue(), 200).darker().darker().getRGB();
    }

    public boolean isHovered(int mouseX, int mouseY, int x, int y, int width, int height) {
        return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
    }

    public int toggledColor(Module m, int mouseX, int mouseY, int x, int y, int width, int height) {
        if(!m.isToggled() && isHovered(mouseX, mouseY, x, y, width, height)) {
            return new Color(ClickGUIModule.INSTANCE.buttonred.getValue(), ClickGUIModule.INSTANCE.buttongreen.getValue(), ClickGUIModule.INSTANCE.buttonblue.getValue(), 200).brighter().brighter().getRGB();
        } else if(!m.isToggled() && !isHovered(mouseX, mouseY, x, y, width, height)) {
            return new Color(ClickGUIModule.INSTANCE.buttonred.getValue(), ClickGUIModule.INSTANCE.buttongreen.getValue(), ClickGUIModule.INSTANCE.buttonblue.getValue(), 200).getRGB();
        } else if(m.isToggled() && !isHovered(mouseX, mouseY, x, y, width, height)) {
            return new Color(ClickGUIModule.INSTANCE.buttonred.getValue(), ClickGUIModule.INSTANCE.buttongreen.getValue(), ClickGUIModule.INSTANCE.buttonblue.getValue(), 200).darker().darker().getRGB();
        } else if(m.isToggled() && isHovered(mouseX, mouseY, x, y, width, height)) {
            return new Color(ClickGUIModule.INSTANCE.buttonred.getValue(), ClickGUIModule.INSTANCE.buttongreen.getValue(), ClickGUIModule.INSTANCE.buttonblue.getValue(), 200).darker().darker().getRGB();
        }
        return -1;
    }

    public void drawRect(float x, float y, float width, float height, int color) {
        Renderutil.drawRect(x, y, width, height, color);
    }

    public void drawRect(float x, float y, float width, float height, int r, int g, int b, int alpha) {
        Renderutil.drawRect(x, y, width, height, r, g, b, alpha);
    }

    public boolean font() {
        return ClickGUIModule.INSTANCE.customFont.getValue();
    }
}
