package com.nzt.gdx.ashley.systems.b2d;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.ashley.components.mvt.PositionComponent;
import com.nzt.gdx.ashley.components.mvt.Velocity2DComponent;
import com.nzt.gdx.ashley.components.b2d.B2DBodyComponent;
import com.nzt.gdx.ashley.components.physx.Shape2DComponent;
import com.nzt.gdx.debug.perf.frame.PerformanceFrameUtils;

/**
 * System for box2D world it do the world.step
 *
 * @author fabiitch
 */
public class B2DWorldSystem extends IteratingSystem {

	private static final float MAX_STEP_TIME = 1 / 60f;
	private float accumulator = 0f;

	private World world;
	private Array<Entity> bodiesQueue;

	private ComponentMapper<B2DBodyComponent> b2dMapper = B2DBodyComponent.mapper;
	private boolean calculRotation;

	public B2DWorldSystem(World world, boolean calculRotation, int order) {
		super(Family.all(B2DBodyComponent.class, PositionComponent.class).get(), order);
		this.world = world;
		this.bodiesQueue = new Array<Entity>();
		this.calculRotation = calculRotation;
	}

	public B2DWorldSystem(World world, boolean calculRotation) {
		this(world, calculRotation, NztSystemsOrder.B2D);
	}

	public void dispose() {
		this.world.dispose();
		this.bodiesQueue.clear();
		this.bodiesQueue = null;
	}

	public void setContactListener(ContactListener contactListener) {
		world.setContactListener(contactListener);
	}

	@Override
	public void update(float deltaTime) {
		PerformanceFrameUtils.startSystem(this);
		super.update(deltaTime);
		float frameTime = Math.min(deltaTime, 0.25f);
		accumulator += frameTime;
		if (accumulator >= MAX_STEP_TIME) {
			while (accumulator >= MAX_STEP_TIME) {
				world.step(MAX_STEP_TIME, 6, 2);
				for (Entity entity : bodiesQueue) {
					B2DBodyComponent bodyComp = b2dMapper.get(entity);
					if (bodyComp.doDestroy) {
						bodyComp.destroyBody(world);
						bodiesQueue.removeValue(entity, true);
					} else {
						bodyComp.processAllEvents();
					}
				}
				accumulator -= MAX_STEP_TIME;
			}
			// Entity Queue
			for (Entity entity : bodiesQueue) {
				PositionComponent.updatePositionFromBody(entity);
				Velocity2DComponent.updateVelocityFromBody(entity);
				if (calculRotation)
					PositionComponent.updateAngleFromBody(entity);

			}
		}
		bodiesQueue.clear();
		PerformanceFrameUtils.endSystem(this);
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		bodiesQueue.add(entity);
	}
}