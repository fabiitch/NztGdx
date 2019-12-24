package com.nzt.gdx.math.shape.rectangles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class RectangleUtils {

	public static void centerX(Rectangle rect) {
		rect.setX(Gdx.graphics.getWidth() / 2 - rect.getWidth() / 2);
	}

}
