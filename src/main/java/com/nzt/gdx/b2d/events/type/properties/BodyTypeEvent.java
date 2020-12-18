package com.nzt.gdx.b2d.events.impl.properties;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.nzt.gdx.b2d.events.B2DAbstractEvent;
import com.nzt.gdx.b2d.events.B2DEventsEnum;

public class BodyTypeEvent extends B2DAbstractEvent {

    public BodyType bodyType;

    public BodyTypeEvent() {
        super(B2DEventsEnum.BodyType);
    }

    @Override
    public void doReset() {
        bodyType = null;
    }

    @Override
    public void apply(Body body) {
        body.setType(bodyType);
    }

}
