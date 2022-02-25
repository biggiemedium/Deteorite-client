package dev.px.deteorite.Function.HUD;

import dev.px.deteorite.Function.Value.Value;

import java.util.ArrayList;

public class Element {

    private String name;
    private String description;

    private int x;
    private int y;
    private int width;
    private int height;

    private ArrayList<Value<?>> values;

    public Element(String name) {
        this.name = name;
    }

    public Element(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
