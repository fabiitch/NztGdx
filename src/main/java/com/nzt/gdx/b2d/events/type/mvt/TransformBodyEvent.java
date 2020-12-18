package com.nzt.gdx.b2d.events.type.mvt;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.nzt.gdx.b2d.events.B2DBaseEvent;
import com.nzt.gdx.b2d.events.B2DEventsEnum;

public class TransformBodyEvent extends B2DBaseEvent<TransformBodyEvent> {

    public Vector2 positionTo = new Vector2();
    public float rotation;
    public short priority;

    public TransformBodyEvent() {
        super(B2DEventsEnum.Transform);
    }


    @Override
    public void apply(Body body) {
        body.setTransform(positionTo, rotation);
    }

    @Override
    public boolean canConcat(TransformBodyEvent event) {
        if (this.priority < event.priority) {
            this.positionTo.set(event.positionTo);
            this.rotation = event.rotation;
            this.priority = event.priority;
        }
        return true;
    }

    @Override
    public void doReset() {
        this.positionTo.setZero();
        this.rotation = 0;
        this.priority = 0;
    }

}
