package com.nzt.gdx.ashley.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.utils.logger.LogTagBase;
import com.nzt.gdx.utils.logger.TagCountLogger;

public class PhysicsDebugSystem extends IteratingSystem {
	private Box2DDebugRenderer debugRenderer;
	private World world;
	private OrthographicCamera camera;

	public PhysicsDebugSystem(World world, OrthographicCamera camera) {
		super(Family.all().get());
		debugRenderer = new Box2DDebugRenderer();
		this.world = world;
		this.camera = camera;
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
