package dev.px.deteorite.Function.ClickGUI;

import dev.px.deteorite.deteorite;
import dev.px.deteorite.Function.ClickGUI.Constructors.WidgetConstructor;
import dev.px.deteorite.Function.Module.Module;
import dev.px.deteorite.Function.Module.Other.ClickGUIModule;
import dev.px.deteorite.Util.Interfaces.IComponent;
import dev.px.deteorite.Util.Render.Fontutil;
import dev.px.deteorite.Util.Render.Renderutil;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Frame extends WidgetConstructor implements IComponent {

    private String name;
    private int x, y;
    private int height, width;
    private int dragX, dragY;
    private boolean dragging, open;
    private Module.Type type;

    private ArrayList<ModuleButton> moduleButtons;

    public Frame(Module.Type type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.height = 11;
        this.width = 88;
        this.open = false;
        this.dragging = false;
        this.name = type.name();
        this.moduleButtons = new ArrayList<>();

        int offsetY = 13;
        for(Module m : deteorite.moduleManager.getModuleByType(type)) {
            if(this.type == m.getType()) {
                this.moduleButtons.add(new ModuleButton(m, this, this.x, offsetY));
                offsetY += 13;
            }
        }
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        int valueChange = new Color(ClickGUIModule.INSTANCE.red.getValue(), ClickGUIModule.INSTANCE.green.getValue(), ClickGUIModule.INSTANCE.blue.getValue(), 200).getRGB();
        int outline = new Color(ClickGUIModule.INSTANCE.red.getValue(), ClickGUIModule.INSTANCE.green.getValue(), ClickGUIModule.INSTANCE.blue.getValue(), 150).getRGB();

        Renderutil.drawRect(this.x, this.y, x + width, (y + this.height), valueChange);
        Renderutil.drawRectOutline((int)this.x - 1, (int)this.y - 1, (int)(this.x + this.width) + 1, (int)(this.y + this.height), (int)this.x, (int)this.y, (int)(this.x + this.width), (int)(this.y + this.height), outline);
        Fontutil.drawString(font(), type.name(), (int) this.x + 4, (int) this.y + this.height / 2 - 4, -1);
        Fontutil.drawString(font(), "" + getModuleCountForType(type), x + (width - 5), y + 2, -1);

        if(this.dragging){
            this.x = mouseX - dragX;
            this.y = mouseY - dragY;
        }

        if(open && !moduleButtons.isEmpty()) {
            int offset = 0;
            for(ModuleButton b : moduleButtons) {
                if(b.getX() != x) {
                    b.setX(x);
                }
                if(b.getY() != y + height + offset) {
                    b.setY(y + height + offset);
                }
                b.draw(mouseX, mouseY);
                offset += b.getHeight();
            }
        }
    }

    private int getModuleCountForType(Module.Type type) {
        int count = deteorite.moduleManager.getModuleByType(type).size();
        return count;
    }

    private void handlePosition(int x, int y, ModuleButton button, int height) {
        if(button.getX() != x) {
            button.setX(x);
        }
        if(button.getY() != y) {
            button.setY(y + height);
        }
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) throws IOException {
        if(button == 0) {
            if (isHovering(mouseX, mouseY)) {
                this.dragging = true;
                dragX = mouseX - this.x;
                dragY = mouseY - this.y;
            }
        }

        if(button == 1) {
            if(isHovering(mouseX, mouseY)) {
                if(!open) {
                    open = true;
                } else if(open) {
                    open = false;
                }
            }
        }

        if(!open) return;
        for(ModuleButton b : moduleButtons) {
            b.mouseClicked(mouseX, mouseY, button);
        }
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int state) {
        for(ModuleButton b : moduleButtons) {
            b.mouseReleased(mouseX, mouseY, state);
        }
        this.dragging = false;
    }

    @Override
    public void keyTyped(char typedChar, int keyCode) throws IOException {

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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isDragging() {
        return dragging;
    }

    public void setDragging(boolean dragging) {
        this.dragging = dragging;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public Module.Type getType() {
        return type;
    }

    private boolean isHovering(int mouseX, int mouseY) {
        return mouseX >= this.getX() && mouseX <= this.getX() + this.getWidth() && mouseY >= this.getY() && mouseY <= this.getY() + this.getHeight() - (this.open ? 2 : 0);
    }

    private int getOffset() {
        int x = 0;
        for(ModuleButton b : moduleButtons) {
            x += b.getHeight() + this.height;
        }
        return x;
    }
}
