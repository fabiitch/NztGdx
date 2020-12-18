package com.nzt.gdx.b2d.events.type.properties;

import com.badlogic.gdx.physics.box2d.Body;
import com.nzt.gdx.b2d.events.B2DBaseEvent;
import com.nzt.gdx.b2d.events.B2DEventsEnum;

public class DestroyBodyEvent extends B2DBaseEvent<DestroyBodyEvent> {

    public DestroyBodyEvent() {
        super(B2DEventsEnum.Destroy);
    }

    @Override
    public void apply(Body body) {
        body = null;
    }

    @Override
    public boolean canConcat(DestroyBodyEvent event) {
        return true;
    }

    @Override
    public void doReset() {

    }

}
