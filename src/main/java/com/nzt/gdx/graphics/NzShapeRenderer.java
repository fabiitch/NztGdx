package com.nzt.gdx.graphics;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class NzShapeRenderer extends ShapeRenderer {

	public void rect(Rectangle rect) {
		this.rect(rect.x, rect.y, rect.width, rect.height);
	}

	public void randomColor() {
		float r = MathUtils.random();
		float g = MathUtils.random();
		float b = MathUtils.random();
		Color randomColor = new Color(r, g, b, 1);
		this.setColor(randomColor);
	}
}
