package com.nzt.gdx.ashley.systems.physx;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.systems.IteratingSystem;
import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.ashley.components.mvt.PositionComponent;
import com.nzt.gdx.ashley.components.mvt.Velocity2DComponent;
import com.nzt.gdx.ashley.components.physx.PhysxComponent;
import com.nzt.gdx.ashley.components.properties.TypeComponent;
import com.nzt.gdx.debug.perf.frame.PerformanceFrameUtils;

public class PhysxSystem extends EntitySystem implements EntityListener {

    private static Family family = Family.all(PhysxComponent.class, TypeComponent.class).get();
    private static ComponentMapper<PositionComponent> posMapper = PositionComponent.mapper;
    private static ComponentMapper<PhysxComponent> shapeMapper = PhysxComponent.mapper;
    private static ComponentMapper<Velocity2DComponent> velocityMapper = Velocity2DComponent.mapper;

    private Engine engine;
    private PhysX physX;


    public PhysxSystem(Engine engine) {
        this(engine, NztSystemsOrder.PHYSX);
    }

    public PhysxSystem(Engine engine, int priority) {
        super(priority);
        this.engine = engine;
        engine.addEntityListener(family, NztSystemsOrder.PHYSX, this);
        this.physX = new PhysX();
    }

    @Override
    public void update(float dt) {
        PerformanceFrameUtils.startSystem(this);
        physX.update(dt);
        PerformanceFrameUtils.endSystem(this);
    }

    @Override
    public void entityAdded(Entity entity) {
        PhysxComponent nzShapeComponent = shapeMapper.get(entity);
        if (nzShapeComponent.isStatic) {
            physX.staticBodies.add(entity);
        } else {
            physX.dynamicBodies.add(entity);
        }
    }

    @Override
    public void entityRemoved(Entity entity) {
        System.out.println("aaaaaaaaaaaa");
    }
}
