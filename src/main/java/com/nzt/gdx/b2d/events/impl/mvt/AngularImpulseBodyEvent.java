package com.nzt.gdx.b2d.events.impl.mvt;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.b2d.events.B2DEvent;

public class AngularImpulseBodyEvent implements B2DEvent {

	public float impulse;
	public boolean wake;

	@Override
	public void reset() {
		this.impulse = 0f;
		this.wake = false;
	}

	@Override
	public void apply(Body body) {
		body.applyAngularImpulse(impulse, wake);
	}

}
