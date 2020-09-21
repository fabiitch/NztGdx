package com.nzt.gdx.ashley.systems.render;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.ashley.systems.BaseSystemsContants;
import com.nzt.gdx.logger.tag.LogTagBase;
import com.nzt.gdx.logger.tag.count.TagCountLogger;

/**
 * System for Box2D, debugRender
 * 
 * @author fabiitch
 *
 */
public class B2DDebugSystem extends EntitySystem {
	private Box2DDebugRenderer debugRenderer;
	private World world;
	private Camera camera;

	public B2DDebugSystem(World world, Camera camera) {
		super(BaseSystemsContants.B2D_DEBUG);
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
}
