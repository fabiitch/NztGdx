package com.nzt.gdx.ashley.systems.b2d;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.debug.perf.frame.PerformanceFrameUtils;
import com.nzt.gdx.logger.tag.LogTagsBase;

/**
 * System for Box2D, debugRender
 *
 * @author fabiitch
 */
public class B2DDebugSystem extends EntitySystem {
	private Box2DDebugRenderer debugRenderer;
	private World world;
	private Camera camera;

	public B2DDebugSystem(World world, Camera camera, int order) {
		super(order);
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

	public B2DDebugSystem(World world, Camera camera) {
		this(world, camera, NztSystemsOrder.B2D_DEBUG);
	}


    @Override
    public void update(float deltaTime) {
		PerformanceFrameUtils.startSystem(this);
        debugRenderer.render(world, camera.combined);
		PerformanceFrameUtils.endSystem(this);
    }

	public void dispose() {
		this.debugRenderer.dispose();
	}

}