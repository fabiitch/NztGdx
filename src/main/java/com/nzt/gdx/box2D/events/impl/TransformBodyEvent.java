package com.nzt.gdx.box2D.events.impl;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.box2D.events.Box2DEvent;

public class TransformBodyEvent implements Box2DEvent {

	public Vector2 positionTo;

	@Override
	public void apply(World world, Body body) {

	}

	@Override
	public void reset() {
		positionTo = null;
	}

}
