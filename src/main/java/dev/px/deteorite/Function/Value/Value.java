package dev.px.deteorite.Function.Value;

import dev.px.deteorite.Event.Other.ValueChangeEvent;
import dev.px.deteorite.Function.Module.Module;
import net.minecraftforge.common.MinecraftForge;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class Value<T> {

    private String name;
    private String description;

    private T value;
    private T min;
    private T max;

    private ArrayList<T> comboBox;
    private Color color;

    private Module module;
    private Predicate<T> visible;

    public Value(String name, Module module, T value) {
        this.name = name;
        this.description = "";
        this.module = module;
        this.value = value;
    }

    public Value(String name, Module module, T value, T min, T max) {
        this.name = name;
        this.description = "";
        this.module = module;
        this.value = value;
        this.min = min;
        this.max = max;
    }

    public Value(String name, Module module, T value, Predicate<T> visible) {
        this.name = name;
        this.value = value;
        this.module = module;
        this.visible = visible;
    }

    public Value(String name, Module module, T value, T min, T max, Predicate<T> visible) {
        this.name = name;
        this.value = value;
        this.min = min;
        this.max = max;
        this.module = module;
        this.visible = visible;
    }

    public Value(String name, Module module, T value, Color color) {
        this.name = name;
        this.value = value;
        this.module = module;
        this.color = color;
    }

    public Value(String name, Module module, T value, Color color, Predicate<T> predicate) {
        this.name = name;
        this.value = value;
        this.module = module;
        this.color = color;
        this.visible = predicate;
    }

    public Value(String name, Module module, T value, T... values) {
        this.name = name;
        this.description = "";
        this.module = module;
        this.value = value;
        this.comboBox = new ArrayList<>(Arrays.asList(values));
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

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
        //MinecraftForge.EVENT_BUS.post(new ValueChangeEvent(this));
    }

    public T getMin() {
        return min;
    }

    public void setMin(T min) {
        this.min = min;
    }

    public T getMax() {
        return max;
    }

    public void setMax(T max) {
        this.max = max;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Predicate<T> getVisible() {
        return visible;
    }

    public void setVisible(Predicate<T> visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        if (this.visible == null) {
            return true;
        }
        return this.visible.test(this.getValue());
    }
}
