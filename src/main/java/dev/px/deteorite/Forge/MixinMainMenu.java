package dev.px.deteorite.Forge;

import dev.px.deteorite.Deteorite;
import dev.px.deteorite.Util.Render.Colorutil;
import dev.px.deteorite.Util.Wrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Mixin(GuiMainMenu.class)
public class MixinMainMenu extends GuiScreen {

    @Inject(method = "drawScreen", at = @At("TAIL"), cancellable = true)
    public void drawScreen(int mouseX, int mouseY, float partialTicks, CallbackInfo ci) {
        FontRenderer fr = Minecraft.getMinecraft().fontRenderer;
        ScaledResolution sc = new ScaledResolution(Wrapper.getMC());

        fr.drawStringWithShadow(Deteorite.MODID + " " + Deteorite.VERSION, sc.getScaledWidth() - Wrapper.getMC().fontRenderer.getStringWidth("LeapFrog Client" + Deteorite.VERSION) - 5, 2, Colorutil.Rainbow(300));
    }

    @Inject(method = {"initGui"}, at = { @At("RETURN") }, cancellable = true)
    public void initGui(final CallbackInfo info) {
        this.buttonList.add(new GuiButton(932, 5, 85, this.fontRenderer.getStringWidth("Support me!") + 10, 20, "Support me!"));
        this.buttonList.add(new GuiButton(284, 5, 105, this.fontRenderer.getStringWidth("My github!") + 10, 20, "My github!"));
    }

    @Inject(method = {"actionPerformed"}, at = { @At("HEAD") }, cancellable = true)
    public void actionPerformed(final GuiButton button, final CallbackInfo info) {
        if (button.id == 932) { // youtube
            String link = "https://www.youtube.com/channel/UCqnmK2ZW8X9FRiCRRQ_nNkg";
            try {
                Desktop.getDesktop().browse(new URI(link));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        if (button.id == 284) { // github
            String link = "https://github.com/biggiemedium";
            try {
                Desktop.getDesktop().browse(new URI(link));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

}
