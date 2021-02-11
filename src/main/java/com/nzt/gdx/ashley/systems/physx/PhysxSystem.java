package com.nzt.gdx.ashley.systems.physx;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.ashley.components.mvt.PositionComponent;
import com.nzt.gdx.ashley.components.mvt.Velocity2DComponent;
import com.nzt.gdx.ashley.components.physx.NzShapeComponent;
import com.nzt.gdx.ashley.components.properties.TypeComponent;

public class PhysxSystem extends IteratingSystem {
    private Engine engine;
    private static ComponentMapper<PositionComponent> posMapper = PositionComponent.mapper;
    private static ComponentMapper<NzShapeComponent> shapeMapper = NzShapeComponent.mapper;
    private static ComponentMapper<Velocity2DComponent> velocityMapper = Velocity2DComponent.mapper;

    public PhysxSystem(Engine engine) {
        this(engine, NztSystemsOrder.PHYSX);
    }

    public PhysxSystem(Engine engine, int priority) {
        super(Family.one(NzShapeComponent.class).get(), priority);
        this.engine = engine;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
//        PositionComponent positionComponent = posMapper.get(entity);
//        NzShapeComponent nzShapeComponent = shapeMapper.get(entity);
//
//        Velocity2DComponent velocity2DComponent = velocityMapper.get(entity);
//
//        if (entity.getComponent(TypeComponent.class).mask == 3)
//            positionComponent.position.add(velocity2DComponent.velocity.x * deltaTime, velocity2DComponent.velocity.y * deltaTime, positionComponent.position.x);
////        nzShapeComponent.shape.updatePosition(positionComponent.getPosition());
    }
}
