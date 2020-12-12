package com.nzt.gdx.b2d.events.impl.mvt;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.b2d.events.B2DEvent;

public class TorqueBodyEvent implements B2DEvent {

	public float torque;
	public boolean wake;

	@Override
	public void reset() {
		this.torque = 0f;
		this.wake = false;
	}

	@Override
	public void apply(Body body) {
		body.applyTorque(torque, wake);
	}

}
