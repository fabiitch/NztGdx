package com.nzt.gdx.b2d.events.impl.properties;

import com.badlogic.gdx.physics.box2d.Body;
import com.nzt.gdx.b2d.events.B2DAbstractEvent;
import com.nzt.gdx.b2d.events.B2DEventsEnum;

public class BulletBodyEvent extends B2DAbstractEvent {

    public boolean bullet;

    public BulletBodyEvent() {
        super(B2DEventsEnum.Bullet);
    }

    @Override
    public void doReset() {
        bullet = false;
    }

    @Override
    public void apply(Body body) {
        body.setBullet(bullet);
    }

}
