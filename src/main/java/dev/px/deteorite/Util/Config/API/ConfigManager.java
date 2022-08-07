package dev.px.deteorite.Util.Config.API;

import dev.px.deteorite.Util.Config.Config;
import dev.px.deteorite.Util.Config.Configs.ModuleConfig;
import dev.px.deteorite.Util.Config.Configs.SettingConfig;

import java.util.ArrayList;

public class ConfigManager {

    private ArrayList<Config> configs;

    public ConfigManager() {
        this.configs = new ArrayList<>();

        this.configs.add(new ModuleConfig());
        this.configs.add(new SettingConfig());
    }

    public void saves() {
        for(Config c : this.configs) {
            c.saves();
        }
    }

    public void loads() {
        for(Config c : this.configs) {
            c.loads();
        }
    }

    public ArrayList<Config> getConfigs() {
        return configs;
    }

    public static ConfigManager INSTANCE = new ConfigManager();

}
