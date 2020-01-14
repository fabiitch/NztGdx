package com.nzt.gdx.transformer.impl;

import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.transformer.BaseTransformer;

public class ColorTransfomer extends BaseTransformer<Color> {

	private float r, g, b;

	@Override
	protected void begin() {
		r = value.r;
		g = value.g;
		b = value.b;
	}

	@Override
	protected void act(float percent) {
		value.r = r + (target.r - r) * percent;
		value.g = g + (target.g - g) * percent;
		value.b = b + (target.b - b) * percent;

	}

	@Override
	public void restart() {

	}

}
