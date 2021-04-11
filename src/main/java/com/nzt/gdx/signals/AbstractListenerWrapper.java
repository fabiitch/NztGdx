package com.nzt.gdx.signals;

import java.util.function.Consumer;

import com.badlogic.ashley.signals.Listener;
import com.badlogic.ashley.signals.Signal;

//TODO voir le consumern, java8 , si sa pose pas de pb
public abstract class AbstractListenerWrapper<T> implements Listener<T> {
	protected Consumer<T> consumer;

	public AbstractListenerWrapper(Consumer<T> consumer) {
		this.consumer = consumer;
		registerToListener();
	}

	public abstract void registerToListener();

	@Override
	public void receive(Signal<T> signal, T event) {
		consumer.accept(event);
	}
}
