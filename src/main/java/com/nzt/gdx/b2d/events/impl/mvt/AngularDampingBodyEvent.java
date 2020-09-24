package com.nzt.gdx.b2d.events.impl.mvt;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.b2d.events.B2DEvent;

public class AngularDampingBodyEvent implements B2DEvent {

	public float angularDamping;

	@Override
	public void reset() {
		this.angularDamping = 0f;
	}

	@Override
	public void apply(World world, Body body) {
		body.setAngularDamping(angularDamping);
	}

}
