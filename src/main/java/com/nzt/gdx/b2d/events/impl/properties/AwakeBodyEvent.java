package com.nzt.gdx.b2d.events.impl.properties;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.b2d.events.B2DEvent;

public class AwakeBodyEvent implements B2DEvent {

	public boolean awake;

	@Override
	public void reset() {
		awake = false;
	}

	@Override
	public void apply(World world, Body body) {
		body.setAwake(awake);
	}

}
