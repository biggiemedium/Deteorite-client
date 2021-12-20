package dev.px.deteorite.Manager;

import dev.px.deteorite.Function.Module.Combat.AutoWeb;
import dev.px.deteorite.Function.Module.Combat.CrystalAura;
import dev.px.deteorite.Function.Module.Combat.KillAura;
import dev.px.deteorite.Function.Module.Module;
import dev.px.deteorite.Function.Module.Other.ClickGUIModule;
import dev.px.deteorite.Function.Module.Other.Test;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    public static ArrayList<Module> modules = new ArrayList<>();

    public ModuleManager() {
        if(modules == null) {
            modules = new ArrayList<>();
        }

        // Combat
        Add(new AutoWeb());
        Add(new CrystalAura());
        Add(new KillAura());

        Add(new Test());
        Add(new ClickGUIModule());
    }

    public Module getModuleByName(String name) {
        for(Module m : modules) {
            if(m.getName().equals(name)) {
                return m;
            }
        }
        return null;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public List<Module> getModuleByType(Module.Type type) {
        List<Module> modulestype = new ArrayList<>();

        for(Module m : modules) {
            if(m.getType() == type) {
                modulestype.add(m);
            }
        }
        return modulestype;
    }

    public Module getModule(Class clazz) {
        for(Module m : getModules()) {
            if(m.getClass() == clazz) {
                return m;
            }
        }
        return null;
    }

    public <T extends Module> Module getModuleT(Class<T> clazz) {
        return modules.stream().filter(module -> module.getClass() == clazz).map(module -> module).findFirst().orElse(null);
    }

    private void Add(Module module) {
        modules.add(module);
    }
}
