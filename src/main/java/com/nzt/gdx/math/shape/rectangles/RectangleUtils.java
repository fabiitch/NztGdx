package com.nzt.gdx.math.shape.rectangles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class RectangleUtils {

	public static void centerX(Rectangle rect) {
		rect.setX(Gdx.graphics.getWidth() / 2 - rect.getWidth() / 2);
	}

	public static Rectangle toPPM(Rectangle rect, float PPM) {
		rect.setX(rect.getX() / PPM);
		rect.setY(rect.getY() / PPM);
		rect.setWidth(rect.getWidth() / PPM);
		rect.setHeight(rect.getHeight() / PPM);
		return rect;
	}

}
