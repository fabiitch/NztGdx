package com.nzt.gdx.b2d.events.type.mvt;

import com.badlogic.gdx.physics.box2d.Body;
import com.nzt.gdx.b2d.events.B2DBaseEvent;
import com.nzt.gdx.b2d.events.B2DEventsEnum;

public class AngularImpulseBodyEvent extends B2DBaseEvent<AngularImpulseBodyEvent> {

    public float impulse;
    public boolean wake;

    public AngularImpulseBodyEvent() {
        super(B2DEventsEnum.AngularImpulse);
    }

    @Override
    public boolean canConcat(AngularImpulseBodyEvent event) {
        this.impulse = event.impulse;
        this.wake = event.wake;
        return true;
    }

    @Override
    public void doReset() {
        this.impulse = 0f;
        this.wake = false;
    }

    @Override
    public void apply(Body body) {
        body.applyAngularImpulse(impulse, wake);
    }

}
