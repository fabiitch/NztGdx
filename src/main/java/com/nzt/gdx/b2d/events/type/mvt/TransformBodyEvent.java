package com.nzt.gdx.b2d.events.impl.mvt;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.nzt.gdx.b2d.events.B2DAbstractEvent;
import com.nzt.gdx.b2d.events.B2DEventsEnum;

public class TransformBodyEvent extends B2DAbstractEvent {

    public Vector2 positionTo = new Vector2();
    public float rotation;

    public TransformBodyEvent() {
        super(B2DEventsEnum.Transform);
    }


    @Override
    public void apply(Body body) {
        body.setTransform(positionTo, rotation);
    }

    @Override
    public void doReset() {
        positionTo.setZero();
        rotation = 0;
    }

}
