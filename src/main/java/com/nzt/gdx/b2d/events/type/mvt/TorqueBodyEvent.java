package com.nzt.gdx.b2d.events.impl.mvt;

import com.badlogic.gdx.physics.box2d.Body;
import com.nzt.gdx.b2d.events.B2DAbstractEvent;
import com.nzt.gdx.b2d.events.B2DEventsEnum;

public class TorqueBodyEvent extends B2DAbstractEvent {

    public float torque;
    public boolean wake;

    public TorqueBodyEvent() {
        super(B2DEventsEnum.Torque);
    }

    @Override
    public void doReset() {
        this.torque = 0f;
        this.wake = false;
    }

    @Override
    public void apply(Body body) {
        body.applyTorque(torque, wake);
    }

}
