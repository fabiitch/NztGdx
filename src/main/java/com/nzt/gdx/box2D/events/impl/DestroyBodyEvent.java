package com.nzt.gdx.box2D.events.impl;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.box2D.events.Box2DEvent;

public class DestroyBodyEvent implements Box2DEvent {

	@Override
	public void apply(World world, Body body) {
		world.destroyBody(body);
		body = null;
	}

	@Override
	public void reset() {
		
	}

}
