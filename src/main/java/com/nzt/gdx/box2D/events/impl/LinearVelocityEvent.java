package com.nzt.gdx.box2D.events.impl;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.box2D.events.Box2DEvent;

public class LinearVelocityEvent implements Box2DEvent {

	public Vector2 velocity;

	@Override
	public void reset() {
		velocity.setZero();
	}

	@Override
	public void apply(World world, Body body) {
		body.setLinearVelocity(velocity);
	}

}
