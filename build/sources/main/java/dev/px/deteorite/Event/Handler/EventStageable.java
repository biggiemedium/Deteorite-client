package dev.px.deteorite.Event.Handler;

public class EventStageable {

    private EventStage stage;

    public EventStageable() {

    }

    public EventStageable(EventStage stage) {
        this.stage = stage;
    }

    public EventStage getStage() {
        return stage;
    }

    public enum EventStage {
        PRE, POST
    }

}
