package com.nzt.gdx.b2d.events;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Pool.Poolable;

public abstract class B2DAbstractEvent<E extends B2DAbstractEvent> implements Poolable {

    public short eventType;

    public B2DAbstractEvent(short eventType) {
        this.eventType = eventType;
    }

    public B2DAbstractEvent(B2DEventsEnum event) {
        this.eventType = event.eventType;
    }

    abstract void add(Body body);

    @Override
    public void reset() {
        this.eventType = 0;
        doReset();
    }

    public abstract void doReset();

    public abstract void apply(Body body);
}
