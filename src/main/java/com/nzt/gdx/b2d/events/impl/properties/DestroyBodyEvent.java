package com.nzt.gdx.b2d.events.impl.properties;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.b2d.events.B2DEvent;

public class DestroyBodyEvent implements B2DEvent {

	@Override
	public void apply(World world, Body body) {
		world.destroyBody(body);
		body = null;
	}

	@Override
	public void reset() {
		
	}

}
