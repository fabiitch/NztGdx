package com.nzt.gdx.ashley.systems.b2d;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.ashley.components.b2d.B2DBodyComponent;

/**
 * apply b2D event
 */
public class B2DApplyEventsSystem extends IteratingSystem {
	private World world;
	private ComponentMapper<B2DBodyComponent> b2dMapper = B2DBodyComponent.mapper;

	public B2DApplyEventsSystem(World world, int order) {
		super(Family.all(B2DBodyComponent.class).get(), order);
		this.world = world;
	}

	public B2DApplyEventsSystem(World world) {
		this(world, NztSystemsOrder.B2D_EVENTS);
	}

	@Override
	public void update(float dt) {
//		PerformanceFrameUtils.startSystem(this);
		super.update(dt);
//		PerformanceFrameUtils.endSystem(this);
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		B2DBodyComponent bodyComp = b2dMapper.get(entity);
		if (bodyComp.doDestroy) {
			bodyComp.destroyBody(world);
		} else {
			bodyComp.processAllEvents();
		}
	}
}
