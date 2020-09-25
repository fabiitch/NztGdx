package com.nzt.gdx.ashley.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.ashley.components.PositionComponent;
import com.nzt.gdx.ashley.components.physx.B2DBodyComponent;
import com.nzt.gdx.logger.tag.LogTagBase;
import com.nzt.gdx.logger.tag.count.TagCountLogger;

/**
 * System for box2D world it do the world.step
 * 
 * @author fabiitch
 *
 */
public class B2DSystem extends IteratingSystem {

	private static final float MAX_STEP_TIME = 1 / 60f;
	private static float accumulator = 0f;

	private World world;
	private Array<Entity> bodiesQueue;

	private ComponentMapper<B2DBodyComponent> b2dMapper = B2DBodyComponent.mapper;
	private ComponentMapper<PositionComponent> positionMapper = PositionComponent.mapper;
	private boolean calculRotation;

	public B2DSystem(World world, boolean calculRotation) {
		super(Family.all(B2DBodyComponent.class, PositionComponent.class).get(), BaseSystemsContants.B2D);
		this.world = world;
		this.bodiesQueue = new Array<Entity>();
		this.calculRotation = calculRotation;
	}

	@Override
	public void update(float deltaTime) {
		super.update(deltaTime);
		TagCountLogger.log(LogTagBase.SYSTEMS, "physics");
		float frameTime = Math.min(deltaTime, 0.25f);
		accumulator += frameTime;
		if (accumulator >= MAX_STEP_TIME) {
			while (accumulator >= MAX_STEP_TIME) {
				world.step(MAX_STEP_TIME, 6, 2);
				accumulator -= MAX_STEP_TIME;
			}
			// Entity Queue
			for (Entity entity : bodiesQueue) {
				PositionComponent tfm = positionMapper.get(entity);
				B2DBodyComponent bodyComp = b2dMapper.get(entity);
				Vector2 position = bodyComp.body.getPosition();
				tfm.position.x = position.x;
				tfm.position.y = position.y;

				if (calculRotation)
					tfm.angleRadian = bodyComp.body.getAngle();

				bodyComp.processAllEvents(world);
			}
		}
		bodiesQueue.clear();
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		bodiesQueue.add(entity);
	}
}