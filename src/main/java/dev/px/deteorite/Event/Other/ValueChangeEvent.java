package dev.px.deteorite.Event.Other;

import dev.px.deteorite.Function.Value.Value;
import net.minecraftforge.fml.common.eventhandler.Event;

public class ValueChangeEvent extends Event {

    private Value value;

    public ValueChangeEvent(Value value) {
        this.value = value;
    }

    public Value getValue() {
        return this.value;
    }

}
