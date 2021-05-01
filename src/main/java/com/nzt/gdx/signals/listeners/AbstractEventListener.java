package com.nzt.gdx.signals.listeners;

import com.badlogic.ashley.signals.Listener;
import com.badlogic.ashley.signals.Signal;
import com.nzt.gdx.signals.Event;
import com.nzt.gdx.signals.consumers.EventConsumer;

//TODO voir le consumern, java8 , si sa pose pas de pb
public abstract class AbstractEventListener<E extends Event> implements Listener<E>, SignalRegister {
    protected final EventConsumer<E> consumer;

    public AbstractEventListener(EventConsumer<E> consumer) {
        this.consumer = consumer;
        registerToListener();
    }

    @Override
    public void receive(Signal<E> signal, E event) {
        consumer.accept(event);
    }
}
