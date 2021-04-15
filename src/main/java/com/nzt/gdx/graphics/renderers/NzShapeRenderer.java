package com.nzt.gdx.graphics.renderers;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Polyline;
import com.badlogic.gdx.math.Rectangle;
import com.nzt.gdx.math.random.Randoms;
import com.nzt.gdx.math.shape.Triangle;

public class NzShapeRenderer extends ShapeRenderer {

	public void polyline(Polyline polyline) {
		polyline(polyline.getTransformedVertices());
//        float[] transformedVertices = polyline.getTransformedVertices();
//        line(transformedVertices[0], transformedVertices[1], transformedVertices[2], transformedVertices[3]);
	}

	public void triangle(Triangle triangle) {
		this.polygon(triangle.getTransformedVertices());
	}

	public void circle(Circle circle) {
		this.circle(circle.x, circle.y, circle.radius);
	}

	public void rect(Rectangle rect) {
		this.rect(rect.x, rect.y, rect.width, rect.height);
	}

	public void randomColor() {
		this.setColor(Randoms.toRandom(this.getColor()));
	}
}
