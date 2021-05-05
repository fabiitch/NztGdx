package com.nzt.gdx.ashley.systems.logic;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.ashley.base.NzIteratingSystem;
import com.nzt.gdx.ashley.components.properties.RemoveEntityComponent;

public class RemoveEntitySystem extends NzIteratingSystem {

    private Engine engine;

    public RemoveEntitySystem(Engine engine, int order) {
        super(Family.one(RemoveEntityComponent.class).get(), order);
        this.engine = engine;
    }

    public RemoveEntitySystem(Engine engine) {
        this(engine, NztSystemsOrder.REMOVE_ENTITY);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        engine.removeEntity(entity);
    }
}
