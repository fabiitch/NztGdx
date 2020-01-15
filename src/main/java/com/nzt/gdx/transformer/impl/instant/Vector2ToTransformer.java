package com.nzt.gdx.transformer.impl.instant;

import com.badlogic.gdx.math.Vector2;

public class Vector2ToTransformer extends InstantTransformer<Vector2> {

	@Override
	protected void begin() {

	}

	protected void end() {
		value.x = target.x;
		value.y = target.y;
	}

	@Override
	public void restart() {

	}
}
