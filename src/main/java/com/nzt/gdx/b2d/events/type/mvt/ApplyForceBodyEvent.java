package com.nzt.gdx.b2d.events.impl.mvt;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.nzt.gdx.b2d.events.B2DAbstractEvent;
import com.nzt.gdx.b2d.events.B2DEventsEnum;

public class ApplyForceBodyEvent extends B2DAbstractEvent {

    public Vector2 force;
    public Vector2 point;
    public boolean wake;

    public ApplyForceBodyEvent() {
        super(B2DEventsEnum.ApplyForce);
    }

    @Override
    public void doReset() {
        this.force.setZero();
        this.point.setZero();
        this.wake = false;
    }

    @Override
    public void apply(Body body) {
        body.applyForce(force, point, wake);
    }

}
