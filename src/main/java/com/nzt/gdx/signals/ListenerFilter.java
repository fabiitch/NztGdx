package com.nzt.gdx.signals;

public interface ListenerFilter<T> {

	boolean acceptEvent(T event);
}
