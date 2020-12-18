package com.nzt.gdx.b2d.events.impl.properties;

import com.badlogic.gdx.physics.box2d.Body;
import com.nzt.gdx.b2d.events.B2DAbstractEvent;
import com.nzt.gdx.b2d.events.B2DEventsEnum;

public class FixedRotationBodyEvent extends B2DAbstractEvent {

    public boolean fixedRotation;

    public FixedRotationBodyEvent() {
        super(B2DEventsEnum.AngularDamping);
    }

    @Override
    public void doReset() {
        fixedRotation = false;
    }

    @Override
    public void apply(Body body) {
        body.setFixedRotation(fixedRotation);
    }

}
