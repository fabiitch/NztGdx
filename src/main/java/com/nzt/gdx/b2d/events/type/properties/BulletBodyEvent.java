package com.nzt.gdx.b2d.events.type.properties;

import com.badlogic.gdx.physics.box2d.Body;
import com.nzt.gdx.b2d.events.B2DBaseEvent;
import com.nzt.gdx.b2d.events.B2DEventsEnum;

public class BulletBodyEvent extends B2DBaseEvent<BulletBodyEvent> {

    public boolean bullet;

    public BulletBodyEvent() {
        super(B2DEventsEnum.Bullet);
    }

    @Override
    public boolean canConcat(BulletBodyEvent event) {
        return true;
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
