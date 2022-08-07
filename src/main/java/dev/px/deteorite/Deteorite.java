package dev.px.deteorite;

import dev.px.deteorite.Event.Handler.EventProcessor;
import dev.px.deteorite.Function.ClickGUI.FontRenderer.CFontRenderer;
import dev.px.deteorite.Manager.CommandManager;
import dev.px.deteorite.Manager.HUDManager;
import dev.px.deteorite.Manager.ModuleManager;
import dev.px.deteorite.Manager.ValueManager;
import dev.px.deteorite.Util.Config.API.ConfigManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

import java.awt.*;

/**
 * @author PX dec 19, 2021
 */

@Mod(modid = Deteorite.MODID, version = Deteorite.VERSION)
public class Deteorite {
    public static final String MODID = "deteorite client";
    public static final String VERSION = "1.0";

    public static final Logger log = LogManager.getLogger("deteorite");
    public static CFontRenderer fontRenderer;

    public static ValueManager valueManager;
    public static ModuleManager moduleManager;
    public static EventProcessor eventProcessor;
    public static CommandManager commandManager;
    public static HUDManager HUDManager;
    public static ConfigManager configManager;

    @EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("Starting Client");
        MinecraftForge.EVENT_BUS.register(this);
        log.info("Starting Client");
        fontRenderer = new CFontRenderer(new Font("Verdana", 0, 16), true, true);


        valueManager = new ValueManager();
        moduleManager = new ModuleManager();
        HUDManager = new HUDManager();
        eventProcessor = new EventProcessor();
        configManager = new ConfigManager();
        commandManager = new CommandManager();

        Display.setTitle(MODID + " " + VERSION);
        configManager.getConfigs().forEach(config -> {
            config.loads();
        });
    }
}
