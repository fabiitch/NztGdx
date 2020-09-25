package com.nzt.gdx.b2d.events.impl.mvt;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.b2d.events.B2DEvent;

public class LinearVelocityEvent implements B2DEvent {

	public Vector2 velocity;

	public LinearVelocityEvent() {
		velocity = new Vector2();
	}

	@Override
	public void reset() {
		this.velocity.setZero();
	}

	@Override
	public void apply(World world, Body body) {
		body.setLinearVelocity(velocity);
	}

}
