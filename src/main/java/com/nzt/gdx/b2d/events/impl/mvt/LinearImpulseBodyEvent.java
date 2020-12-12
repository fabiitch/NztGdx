package com.nzt.gdx.b2d.events.impl.mvt;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.b2d.events.B2DEvent;

public class LinearImpulseBodyEvent implements B2DEvent {

	public Vector2 impulse;
	public Vector2 point;
	public boolean wake;

	@Override
	public void reset() {
		this.impulse.setZero();
		this.point.setZero();
		this.wake = false;
	}

	@Override
	public void apply(Body body) {
		body.applyLinearImpulse(impulse, point, wake);
	}

}
