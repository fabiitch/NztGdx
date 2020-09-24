package com.nzt.gdx.b2D.events.impl;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.b2D.events.B2DEvent;

public class BodyTypeEvent implements B2DEvent {

	public BodyType bodyType;

	@Override
	public void apply(World world, Body body) {
		body.setType(bodyType);
	}

	@Override
	public void reset() {
		bodyType = null;
	}

}
