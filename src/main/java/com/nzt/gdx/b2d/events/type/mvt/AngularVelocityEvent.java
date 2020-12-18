package com.nzt.gdx.b2d.events.impl.mvt;

import com.badlogic.gdx.physics.box2d.Body;
import com.nzt.gdx.b2d.events.B2DAbstractEvent;
import com.nzt.gdx.b2d.events.B2DEventsEnum;

public class AngularVelocityEvent extends B2DAbstractEvent {

    public float velocity;

    public AngularVelocityEvent() {
        super(B2DEventsEnum.AngularVelocity);
    }

    @Override
    public void doReset() {
        this.velocity = 0f;
    }

    @Override
    public void apply(Body body) {
        body.setAngularVelocity(velocity);
    }

}
