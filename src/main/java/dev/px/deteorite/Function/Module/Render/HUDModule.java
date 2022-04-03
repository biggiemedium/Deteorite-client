package dev.px.deteorite.Function.Module.Render;

import dev.px.deteorite.Deteorite;
import dev.px.deteorite.Function.HUD.HUDRenderer.HUDScreen;
import dev.px.deteorite.Function.Module.Module;
import dev.px.deteorite.Function.Module.Other.ClickGUIModule;

public class HUDModule extends Module {

    public HUDModule() {
        super("Module", Type.Render);
    }

    @Override
    public void onEnabled() {

        if(Deteorite.moduleManager.getModuleByClass(ClickGUIModule.class).isToggled()) {
            Deteorite.moduleManager.getModuleByClass(ClickGUIModule.class).setToggled(false);
        }

        mc.displayGuiScreen(new HUDScreen());
        toggle();
    }
}
