package dev.px.deteorite.Manager;

import dev.px.deteorite.Function.ClickGUI.Constructors.Element;
import dev.px.deteorite.Function.HUD.HUD;
import dev.px.deteorite.Function.HUD.Elements.Watermark;

import java.util.ArrayList;

public class HUDManager {

    private ArrayList<HUD> elements = new ArrayList<>();

    public HUDManager() {
        if(elements == null) {
            elements = new ArrayList<>();
        }

        Add(new Watermark());
    }

    public HUD getElement(String name) {
        for(HUD e : this.elements) {
            if(e.getName().equalsIgnoreCase(name)) {
                return e;
            }
        }
        return null;
    }

    public ArrayList<HUD> getElements() {
        return elements;
    }

    private void Add(HUD element) {
        this.elements.add(element);
    }

    public <T extends HUD> HUD getElementT(Class<T> clazz) {
        return elements.stream().filter(element -> element.getClass() == clazz).map(e -> e).findFirst().orElse(null);
    }

}
