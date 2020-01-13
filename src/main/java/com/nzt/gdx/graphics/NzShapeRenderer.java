package com.nzt.gdx.graphics;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.nzt.gdx.random.Randoms;

public class NzShapeRenderer extends ShapeRenderer {

	public void rect(Rectangle rect) {
		this.rect(rect.x, rect.y, rect.width, rect.height);
	}

	public void randomColor() {
		this.setColor(Randoms.toRandom(this.getColor()));
	}
}
