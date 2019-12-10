package com.nzt.gdx.ashley.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.ashley.components.TransformComponent;
import com.nzt.gdx.ashley.components.physx.Box2DBodyComponent;
import com.nzt.gdx.logger.LogTagBase;
import com.nzt.gdx.logger.count.TagCountLogger;

public class PhysicsSystem extends IteratingSystem {

	private static final float MAX_STEP_TIME = 1 / 45f;
	private static float accumulator = 0f;

	private World world;
	private Array<Entity> bodiesQueue;

	private ComponentMapper<Box2DBodyComponent> bm = ComponentMapper.getFor(Box2DBodyComponent.class);
	private ComponentMapper<TransformComponent> tm = ComponentMapper.getFor(TransformComponent.class);

	private boolean rotationCalculed;
	public PhysicsSystem(World world, boolean rotationCalculed) {
		super(Family.all(Box2DBodyComponent.class, TransformComponent.class).get());
		this.world = world;
		this.bodiesQueue = new Array<Entity>();
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
				TransformComponent tfm = tm.get(entity);
				Box2DBodyComponent bodyComp = bm.get(entity);
				Vector2 position = bodyComp.body.getPosition();
				tfm.position.x = position.x;
				tfm.position.y = position.y;
				if(rotationCalculed)
				tfm.angle = bodyComp.body.getAngle() * MathUtils.radiansToDegrees;
			}
		}
		bodiesQueue.clear();
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		bodiesQueue.add(entity);
	}
}