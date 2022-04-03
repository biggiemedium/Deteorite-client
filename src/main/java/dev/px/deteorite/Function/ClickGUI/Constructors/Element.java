package dev.px.deteorite.Function.ClickGUI.Constructors;

import dev.px.deteorite.Function.ClickGUI.ModuleButton;
import dev.px.deteorite.Function.Value.Value;
import dev.px.deteorite.Util.Interfaces.IComponent;

import java.io.IOException;

public class Element extends WidgetConstructor implements IComponent {

    private int x;
    private int y;
    private int width;
    private int height;
    private ModuleButton moduleButton;
    private Value value;

    public boolean shown;

    public Element(ModuleButton button, int x, int y, int width, int height) {
        this.moduleButton = button;
        this.x = x;
        this.y = y;
        this. width = width;
        this.height = height;
    }

    public Element(Value<?> value, ModuleButton button, int x, int y, int width, int height) {
        this.moduleButton = button;
        this.x = x;
        this.y = y;
        this. width = width;
        this.height = height;
        this.value = value;
    }

    public void draw(int mouseX, int mouseY) {
    }

    public void mouseClicked(int mouseX, int mouseY, int button) throws IOException {

    }

    public void mouseReleased(int mouseX, int mouseY, int state) {

    }

    public void keyTyped(char typedChar, int keyCode) throws IOException {

    }

    public void update() {

    }

    protected boolean isHovered(int mouseX, int mouseY) {
        return mouseX > getX() + 2 && mouseY > getY() && mouseX < getX() + 2 + getWidth() && mouseY < getY() + getHeight() - 1;
    }

    public boolean isShown() {
        return shown;
    }

    protected void setShown(boolean shown) {
        this.shown = shown;
    }

    public int getDeafultHeight() {
        return 0;
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

    public ModuleButton getModuleButton() {
        return moduleButton;
    }

    public boolean isVisible() {
        if(this.value == null) {
            return false;
        }
        return this.value.isVisible();
    }
}
