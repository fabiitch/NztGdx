package com.nzt.gdx.box2D.events.impl;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.box2D.events.Box2DEvent;

public class ActiveBodyEvent implements Box2DEvent {

	boolean active;

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	@Override
	public void apply(World world, Body body) {

	}

}
