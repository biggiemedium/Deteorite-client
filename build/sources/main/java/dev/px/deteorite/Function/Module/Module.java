package dev.px.deteorite.Function.Module;

import dev.px.deteorite.deteorite;
import dev.px.deteorite.Function.Constructor;
import dev.px.deteorite.Function.Value.Value;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

import java.util.function.Predicate;

public class Module extends Constructor {

    private String name;
    private String description;
    private Type type;
    private int key;
    private boolean toggled;

    protected Minecraft mc = Minecraft.getMinecraft();

    public Module(String name, String description, Type type) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.key = -1;
        this.toggled = false;
    }

    public Module(String name, Type type) {
        this.name = name;
        this.description = "";
        this.type = type;
        this.key = -1;
        this.toggled = false;
    }

    public void onEnabled() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void onDisabled() {
        MinecraftForge.EVENT_BUS.unregister(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean isToggled() {
        return toggled;
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;

        if(this.toggled) {
            this.onEnabled();
        } else {
            this.onDisabled();
        }
    }

    public void disable() {
        this.toggled = !this.toggled;

        if(this.toggled) {
            this.onEnabled();
        } else {
            this.onDisabled();
        }
    }

    public void toggle() {
        this.toggled = !this.toggled;

        if(this.toggled) {
            this.onEnabled();
        } else {
            this.onDisabled();
        }

    }

    protected Value create(String name, Object value) {
        return deteorite.valueManager.Add(new Value(name, this, value));
    }

    protected Value create(String name, Object value, Predicate<Object> predicate) {
        return deteorite.valueManager.Add(new Value(name, this, value, predicate));
    }

    protected Value create(String name, Object value, Object min, Object max) {
        return deteorite.valueManager.Add(new Value(name, this, value, min, max));
    }

    protected Value create(String name, Object value, Object min, Object max, Predicate<Object> predicate) {
        return deteorite.valueManager.Add(new Value(name, this, value, min, max, predicate));
    }

    public <T> Value create(Value<T> value) {
        deteorite.valueManager.Add(value);
        return value;
    }

    @Override
    public void log() {
        deteorite.log.info("Module Constructor running!");
    }

    public enum Type {
        Combat,
        Misc,
        Movement,
        Render,
        Other
    }
}
