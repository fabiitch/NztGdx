package com.nzt.gdx.ashley.systems.mvt;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.nzt.gdx.ashley.components.physx.ShapeComponent;

public class PhysxSystem extends IteratingSystem {

    public PhysxSystem(Family family) {
        super(Family.one(ShapeComponent.class).get());
    }

    public PhysxSystem(Family family, int priority) {
        super(family, priority);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

    }
}
