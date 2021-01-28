package com.nzt.gdx.ashley.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.ashley.components.RemoveEntityComponent;
import com.nzt.gdx.debug.perf.frame.PerformanceFrameUtils;

public class RemoveEntitySystem extends IteratingSystem {

	private Engine engine;

	public RemoveEntitySystem(Engine engine) {
		this(engine, NztSystemsOrder.REMOVE_ENTITY);
	}

	public RemoveEntitySystem(Engine engine, int order) {
		super(Family.one(RemoveEntityComponent.class).get(), NztSystemsOrder.REMOVE_ENTITY);
		this.engine = engine;
	}

	@Override
	public void update(float dt) {
		PerformanceFrameUtils.startSystem(this);
		super.update(dt);
		PerformanceFrameUtils.endSystem(this);
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		engine.removeEntity(entity);
	}
}
