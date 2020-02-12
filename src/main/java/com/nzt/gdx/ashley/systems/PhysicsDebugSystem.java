package com.nzt.gdx.ashley.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.logger.tag.LogTagBase;
import com.nzt.gdx.logger.tag.count.TagCountLogger;

/**
 * System for Box2D, debugRender 
 * @author fabiitch
 *
 */
public class PhysicsDebugSystem extends IteratingSystem {
	private Box2DDebugRenderer debugRenderer;
	private World world;
	private Camera camera;

	public PhysicsDebugSystem(World world, Camera camera) {
		super(Family.all().get());
		debugRenderer = new Box2DDebugRenderer();
		this.world = world;
		this.camera = camera;
		
		debugRenderer.setDrawBodies(true);
		debugRenderer.setDrawVelocities(true);
		debugRenderer.setDrawJoints(true);
		debugRenderer.setDrawAABBs(true);
		debugRenderer.setDrawContacts(true);
		debugRenderer.setDrawInactiveBodies(true);
	}

	@Override
	public void update(float deltaTime) {
		super.update(deltaTime);
		TagCountLogger.log(LogTagBase.SYSTEMS, "physicsDebug");
		debugRenderer.render(world, camera.combined);
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {

	}
}
