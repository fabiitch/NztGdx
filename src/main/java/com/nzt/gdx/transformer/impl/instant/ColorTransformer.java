package com.nzt.gdx.transformer.impl.instant;

import com.badlogic.gdx.graphics.Color;

public class ColorTransformer extends InstantTransformer<Color> {


	@Override
	protected void begin() {

	}

	@Override
	protected void end() {
		value.r = target.r;
		value.g = target.g;
		value.b = target.b;
	}

	@Override
	public void restart() {

	}

}
