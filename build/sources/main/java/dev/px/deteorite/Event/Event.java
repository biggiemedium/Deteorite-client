package dev.px.deteorite.Event;

import dev.px.deteorite.Event.Handler.EventStageable;

public class Event extends EventStageable {

    private boolean canceled;

    public Event() {
    }

    public Event(EventStageable.EventStage stage) {
        super(stage);
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

}
