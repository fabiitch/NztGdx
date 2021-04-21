package com.nzt.gdx.ashley.systems.physx;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntityListener;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.ashley.components.mvt.PositionComponent;
import com.nzt.gdx.ashley.components.mvt.Velocity2DComponent;
import com.nzt.gdx.ashley.components.physx.PhysXComponent;
import com.nzt.gdx.ashley.components.properties.TypeComponent;

//TODO 
public class PhysXSystem extends EntitySystem implements EntityListener {

	private static Family family = Family.all(PhysXComponent.class, TypeComponent.class).get();
	private static ComponentMapper<PositionComponent> posMapper = PositionComponent.mapper;
	private static ComponentMapper<PhysXComponent> shapeMapper = PhysXComponent.mapper;
	private static ComponentMapper<Velocity2DComponent> velocityMapper = Velocity2DComponent.mapper;

	private Engine engine;

	public PhysXSystem(Engine engine) {
		this(engine, NztSystemsOrder.PHYSX);
	}

	public PhysXSystem(Engine engine, int priority) {
		super(priority);
		this.engine = engine;
		engine.addEntityListener(family, NztSystemsOrder.PHYSX, this);
	}

	private static final float MAX_STEP_TIME = 1 / 120f;
	private float accumulator = 0f;
	int nbPassage = 0;

	@Override
	public void update(float dt) {
		float frameTime = Math.min(dt, 0.25f);
		accumulator += frameTime;
		while (accumulator >= MAX_STEP_TIME) {
//            physX.step(dt);
			accumulator -= MAX_STEP_TIME;
			nbPassage++;
		}
		nbPassage = 0;
	}

	@Override
	public void entityAdded(Entity entity) {
		PhysXComponent nzShapeComponent = shapeMapper.get(entity);
		if (nzShapeComponent.isStatic) {
//            physX.staticBodies.add(entity);
		} else {
//            physX.dynamicBodies.add(entity);
		}
	}

	@Override
	public void entityRemoved(Entity entity) {
	}
}
