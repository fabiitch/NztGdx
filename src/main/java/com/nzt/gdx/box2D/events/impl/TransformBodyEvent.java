package com.nzt.gdx.box2D.events.impl;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.box2D.events.B2DEvent;

public class TransformBodyEvent implements B2DEvent {

	public Vector2 positionTo;
	public float rotation;

	@Override
	public void apply(World world, Body body) {
		body.setTransform(positionTo, rotation);
	}

	@Override
	public void reset() {
		positionTo.setZero();
		rotation = 0;
	}

}
