package dev.px.deteorite.Function.HUD;

import dev.px.deteorite.Function.Value.Value;
import dev.px.deteorite.Util.Interfaces.Util;
import dev.px.deteorite.Util.Render.Renderutil;
import dev.px.deteorite.Util.Wrapper;
import net.minecraft.client.gui.ScaledResolution;

import java.util.ArrayList;

public class HUD implements Util {

    private String name;

    private int x;
    private int y;
    private int width;
    private int height;

    private boolean dragging;
    private boolean visible;

    private ArrayList<Value<?>> values;
    private ScaledResolution sr;

    public HUD(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.dragging = false;
        this.visible = false;
        this.values = new ArrayList<>();
        this.sr = new ScaledResolution(Wrapper.getMC());
    }

    public void render(int mouseX, int mouseY, float partialTicks) {

    }

    public void mouseClick(int mouseX, int mouseY, int mouseButton) {

    }

    public void mouseResleased(int mouseX, int mouseY) {

    }

    public Value findValue(String name) {
        for(Value<?> v : this.values) {
            if(v.getName().equalsIgnoreCase(name)) {
                return v;
            }
        }
        return null;
    }

    public boolean hovered(int mouseX, int mouseY) {
        return mouseX >= getX() && mouseX < getX() + getWidth() && mouseY >= getY() && mouseY < getY() + getHeight();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isDragging() {
        return dragging;
    }

    public void setDragging(boolean dragging) {
        this.dragging = dragging;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public ArrayList<Value<?>> getValues() {
        return values;
    }

    public void setValues(ArrayList<Value<?>> values) {
        this.values = values;
    }
}
