package com.nzt.gdx.b2d.events.impl.mvt;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.b2d.events.B2DEvent;

public class ApplyForceBodyEvent implements B2DEvent {

	public Vector2 force;
	public Vector2 point;
	public boolean wake;

	@Override
	public void reset() {
		this.force.setZero();
		this.point.setZero();
		this.wake = false;
	}

	@Override
	public void apply(World world, Body body) {
		body.applyForce(force, point, wake);
	}

}
