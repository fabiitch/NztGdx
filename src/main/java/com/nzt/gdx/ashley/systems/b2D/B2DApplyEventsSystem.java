package com.nzt.gdx.ashley.systems.b2D;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.ashley.components.physx.B2DBodyComponent;
import com.nzt.gdx.ashley.NztSystemsOrder;

/**
 * apply b2D event
 */
public class B2DApplyEventsSystem extends IteratingSystem{
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
	protected void processEntity(Entity entity, float deltaTime) {
		B2DBodyComponent bodyComp = b2dMapper.get(entity);
		bodyComp.processAllEvents(world);
	}
}
