package com.nzt.gdx.graphics.renderers;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.nzt.gdx.math.random.Randoms;

public class NzShapeRenderer extends ShapeRenderer {

	public void rect(Rectangle rect) {
		this.rect(rect.x, rect.y, rect.width, rect.height);
	}
	
	public void circle(Circle circle ) {
		this.circle(circle.x, circle.y, circle.radius);
	}

	public void randomColor() {
		this.setColor(Randoms.toRandom(this.getColor()));
	}
}
