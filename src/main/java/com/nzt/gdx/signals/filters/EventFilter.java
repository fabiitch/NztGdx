package com.nzt.gdx.signals.filters;

import com.nzt.gdx.signals.Event;

public interface EventFilter<E extends Event> {

	boolean acceptEvent(E event);
}
