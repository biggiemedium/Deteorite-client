package dev.px.deteorite.Manager;

import dev.px.deteorite.Function.Module.Module;
import dev.px.deteorite.Function.Value.Value;

import java.util.ArrayList;
import java.util.List;

public class ValueManager {

    public ArrayList<Value> values;

    public ValueManager() {
        this.values = new ArrayList<>();
    }

    public Value Add(Value value) {
        this.values.add(value);
        return value;
    }

    public List<Value> getValueForMod(Module module) {
        List<Value> valueList = new ArrayList<>();
        for(Value<?> v : values) {
            if(v.getModule() == module) {
                valueList.add(v);
            }
        }
        return valueList;
    }

    public ArrayList<Value> getValues() {
        return this.values;
    }
}
