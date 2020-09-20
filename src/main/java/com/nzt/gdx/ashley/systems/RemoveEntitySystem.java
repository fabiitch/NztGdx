package com.nzt.gdx.ashley.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.nzt.gdx.ashley.components.RemoveEntityComponent;

public class RemoveEntitySystem extends IteratingSystem {

    private Engine engine;

    public RemoveEntitySystem(Engine engine) {
        super(Family.one(RemoveEntityComponent.class).get(), BaseSystemsContants.REMOVE_ENTITY);
        this.engine = engine;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        engine.removeEntity(entity);
    }
}
