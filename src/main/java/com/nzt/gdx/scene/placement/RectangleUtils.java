package com.nzt.gdx.scene.placement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

//TODO un peu foireux la
public class RectangleUtils {

	public static void centerX(Rectangle rect) {
		rect.setX(Gdx.graphics.getWidth() / 2 - rect.getWidth() / 2);
	}
}
