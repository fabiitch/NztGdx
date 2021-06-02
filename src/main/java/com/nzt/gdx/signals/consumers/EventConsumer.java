package com.nzt.gdx.signals.consumers;

import com.nzt.gdx.signals.Event;
import com.nzt.gdx.signals.filters.EventFilter;

public abstract class EventConsumer<E extends Event> {

    public final EventFilter<E> filter;

    public EventConsumer() {
        this.filter = setFilter();
    }

    public void accept(E event) {
        if (filter == null || filter.acceptEvent(event)) {
            consumeEvent(event);
        }
    }

    public abstract EventFilter setFilter();

    protected abstract void consumeEvent(E event);
}
