package com.nzt.gdx.signals.filters;

import com.badlogic.ashley.core.Entity;
import com.nzt.gdx.signals.Event;

public abstract class BaseEventFilter<E extends Event> implements EventFilter<E> {

    protected boolean findEntity(Entity[] entities, Entity search) {
        if (entities == null)
            return true;
        for (int i = 0, n = entities.length; i < n; i++) {
            if (entities[i] == search)
                return true;
        }
        return false;
    }

    protected boolean findInt(int[] array, int search) {
        if (array == null)
            return true;
        for (int i = 0, n = array.length; i < n; i++) {
            if (array[i] == search)
                return true;
        }
        return false;
    }
}
