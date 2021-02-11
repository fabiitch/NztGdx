package com.nzt.gdx.ashley.systems.mvt;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.ashley.components.mvt.PositionComponent;
import com.nzt.gdx.ashley.components.mvt.Velocity2DComponent;
import com.nzt.gdx.debug.perf.frame.PerformanceFrameUtils;

/*
Simple update position with velocity
 */
public class Velocity2DSystem extends IteratingSystem {
    private static ComponentMapper<PositionComponent> posMapper = PositionComponent.mapper;
    private static ComponentMapper<Velocity2DComponent> velocityMapper = Velocity2DComponent.mapper;

    public Velocity2DSystem() {
        this(NztSystemsOrder.MVT);
    }

    public Velocity2DSystem(int priority) {
        super(Family.all(Velocity2DComponent.class, PositionComponent.class).get(), priority);
    }

    @Override
    public void update(float dt) {
        PerformanceFrameUtils.startSystem(this);
        super.update(dt);
        PerformanceFrameUtils.endSystem(this);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent positionComponent = posMapper.get(entity);
        Velocity2DComponent velocity2DComponent = velocityMapper.get(entity);
        positionComponent.position.add(velocity2DComponent.velocity.x * deltaTime, velocity2DComponent.velocity.y * deltaTime, positionComponent.position.x);

    }
}
