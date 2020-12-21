package com.nzt.gdx.b2d.events.type.mvt;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.nzt.gdx.b2d.events.B2DBaseEvent;
import com.nzt.gdx.b2d.events.B2DEventsEnum;

public class ApplyForceCenterBodyEvent extends B2DBaseEvent<ApplyForceCenterBodyEvent> {

    public Vector2 force;
    public boolean wake;

    public ApplyForceCenterBodyEvent() {
        super(B2DEventsEnum.ApplyForceToCenter);
    }

    @Override
    public boolean canConcat(ApplyForceCenterBodyEvent event) {
        return false;
    }

    @Override
    public void doReset() {
        this.force.setZero();
        this.wake = false;
    }

    @Override
    public void apply(Body body) {
        body.applyForceToCenter(force, wake);

    }

}