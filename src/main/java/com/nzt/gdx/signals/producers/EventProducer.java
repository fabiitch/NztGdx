package com.nzt.gdx.signals.producers;

import com.badlogic.ashley.signals.Signal;
import com.nzt.gdx.signals.Event;
import com.nzt.gdx.signals.listeners.SignalRegister;

//TODO chai pas
public abstract class EventProducer<E extends Event> implements SignalRegister {
    private Signal<E> signal;

    public EventProducer(Signal<E> signal) {
        this.signal = signal;
    }

    @Override
    public void unregisterSignal() {
        signal = null;
    }

    public void dispatch(E event) {
        signal.dispatch(event);
    }
}
