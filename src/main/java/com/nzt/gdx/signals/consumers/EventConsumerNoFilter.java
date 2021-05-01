package com.nzt.gdx.signals.consumers;

import com.nzt.gdx.signals.Event;
import com.nzt.gdx.signals.filters.EventFilter;

public abstract class EventConsumerNoFilter<E extends Event> extends EventConsumer<E> {
    @Override
    public final EventFilter setFilter() {
        return null;
    }
}
