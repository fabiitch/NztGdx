package com.nzt.gdx.b2d.events.impl.properties;

import com.badlogic.gdx.physics.box2d.Body;
import com.nzt.gdx.b2d.events.B2DAbstractEvent;
import com.nzt.gdx.b2d.events.B2DEventsEnum;

public class AwakeBodyEvent extends B2DAbstractEvent {

    public boolean awake;

    public AwakeBodyEvent() {
        super(B2DEventsEnum.Awake);
    }

    @Override
    public void doReset() {
        awake = false;
    }

    @Override
    public void apply(Body body) {
        body.setAwake(awake);
    }

}
