package dev.px.deteorite.Function.HUD.Elements;

import dev.px.deteorite.Deteorite;
import dev.px.deteorite.Function.HUD.HUD;

public class Watermark extends HUD {

    public Watermark() {
        super("Watermark", 1, 1);
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        mc.fontRenderer.drawStringWithShadow(Deteorite.MODID, this.getX(), this.getY(), -1);
        setWidth(mc.fontRenderer.getStringWidth(Deteorite.MODID));
        setHeight(mc.fontRenderer.FONT_HEIGHT);
    }
}
