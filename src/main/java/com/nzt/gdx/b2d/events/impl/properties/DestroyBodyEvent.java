package com.nzt.gdx.b2D.events.impl;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.b2D.events.B2DEvent;

public class DestroyBodyEvent implements B2DEvent {

	@Override
	public void apply(World world, Body body) {
		world.destroyBody(body);
		body = null;
		System.err.println("DESTROY");
	}

	@Override
	public void reset() {
		
	}

}