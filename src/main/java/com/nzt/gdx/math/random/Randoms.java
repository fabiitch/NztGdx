package com.nzt.gdx.math.random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;

public class Randoms {

	public static Color newRandomColor() {
		float r = MathUtils.random();
		float g = MathUtils.random();
		float b = MathUtils.random();
		Color randomColor = new Color(r, g, b, 1);
		return randomColor;
	}

	public static Color toRandom(Color color) {
		float r = MathUtils.random();
		float g = MathUtils.random();
		float b = MathUtils.random();
		color.r = r;
		color.g = g;
		color.b = b;
		return color;
	}
}
