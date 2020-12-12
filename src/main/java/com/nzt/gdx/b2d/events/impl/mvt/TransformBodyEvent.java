package com.nzt.gdx.b2d.events.impl.mvt;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.b2d.events.B2DEvent;

public class TransformBodyEvent implements B2DEvent {

	public Vector2 positionTo;
	public float rotation;

	public TransformBodyEvent() {
		positionTo = new Vector2();
	}

	@Override
	public void apply(Body body) {
		body.setTransform(positionTo, rotation);
	}

	@Override
	public void reset() {
		positionTo.setZero();
		rotation = 0;
	}

}
