package com.nzt.gdx.box2D.events.impl;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.nzt.gdx.box2D.events.B2DEvent;
import com.badlogic.gdx.physics.box2d.World;

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
