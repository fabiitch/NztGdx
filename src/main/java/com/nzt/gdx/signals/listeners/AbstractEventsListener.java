package com.nzt.gdx.signals.listeners;

import com.badlogic.ashley.signals.Listener;
import com.badlogic.ashley.signals.Signal;
import com.nzt.gdx.signals.Event;
import com.nzt.gdx.signals.consumers.EventConsumer;

public abstract class AbstractEventsListener<E extends Event> implements Listener<E>, SignalRegister {
    protected final EventConsumer<E>[] consumers;

    public AbstractEventsListener(EventConsumer<E>... consumers) {
        this.consumers = consumers;
        registerToListener();
    }

    @Override
    public void receive(Signal<E> signal, E event) {
        for (EventConsumer<E> consumer : consumers) {
            consumer.accept(event);
        }
    }
}
