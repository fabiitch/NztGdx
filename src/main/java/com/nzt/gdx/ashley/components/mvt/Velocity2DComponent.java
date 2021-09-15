package com.nzt.gdx.ashley.components.mvt;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.ashley.base.components.PoolableComponent;

public class Velocity2DComponent extends PoolableComponent {

    public static final ComponentMapper<Velocity2DComponent> mapper = ComponentMapper.getFor(Velocity2DComponent.class);

    public Vector2 velocity = new Vector2();
    public Vector2 direction = new Vector2();

    public Velocity2DComponent() {
        super();
    }

    @Override
    public void reset() {
        this.velocity.setZero();
        this.direction.setZero();
    }


    public void setVelocity(Vector2 vel) {
        this.velocity.set(vel);
        this.direction.set(vel).nor();
    }

    public Vector2 getDirection() {
        return direction;
    }

    public float getSpeed() {
        return velocity.len();
    }
}
