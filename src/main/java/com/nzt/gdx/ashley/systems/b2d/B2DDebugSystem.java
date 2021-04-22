package com.nzt.gdx.ashley.systems.b2d;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.ashley.NztSystemsOrder;
import com.nzt.gdx.debug.B2DDebugUtils;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.perf.PerformanceFrame;

/**
 * System for Box2D, debugRender
 *
 */
public class B2DDebugSystem extends EntitySystem {
	private Box2DDebugRenderer debugRenderer;
	private World world;
	private Camera camera;

	private boolean displayHud = false;

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

		PerformanceFrame.addSystem(this);
	}

	public B2DDebugSystem(World world, Camera camera) {
		this(world, camera, NztSystemsOrder.B2D_DEBUG);
	}

	public void initHudDebug(int positionOnStage, Color color) {
		B2DDebugUtils.initHudDebug(world, positionOnStage, color);
		this.displayHud = true;
	}

	public void initHudDebug() {
		B2DDebugUtils.initHudDebug(world, HudDebugPosition.TOP_RIGHT, Color.RED);
		this.displayHud = true;
	}

	public void updateHudDebug() {
		B2DDebugUtils.updateHudDebug(world);
	}

	@Override
	public void update(float deltaTime) {
		PerformanceFrame.startSystem(this);
		debugRenderer.render(world, camera.combined);
		if (displayHud)
			updateHudDebug();
		PerformanceFrame.endSystem(this);
	}

	public void dispose() {
		this.debugRenderer.dispose();
	}

}
