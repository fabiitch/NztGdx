package com.nzt.gdx.signals;

import java.util.function.Consumer;

import com.badlogic.ashley.signals.Listener;
import com.badlogic.ashley.signals.Signal;

//TODO voir le consumern, java8 , si sa pose pas de pb
public abstract class AbstractListenerWrapper<T> implements Listener<T> {
	protected final Consumer<T> consumer;
	protected final ListenerFilter<T> filter;

	public AbstractListenerWrapper(Consumer<T> consumer, ListenerFilter<T> filter) {
		this.consumer = consumer;
		this.filter = filter;
		registerToListener();
	}

	public AbstractListenerWrapper(Consumer<T> consumer) {
		this(consumer, null);
	}

	public abstract void registerToListener();

	@Override
	public void receive(Signal<T> signal, T event) {
		if (filter != null && filter.acceptEvent(event))
			consumer.accept(event);
	}
}
