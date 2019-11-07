package com.nzt.gdx.box2D.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Box2DConverter {
	private static float PPM;
	public static void initMetrics(float ppm) {
		Box2DConverter.PPM = ppm;
		Gdx.app.log("Box2dUtilsMetrics", "IIIII NNNNIIIIT");
	}

	public static float toPPM(float x) {
		return x / PPM;
	}

	public static Vector2 toPPM(Vector2 vector) {
		return new Vector2(vector.x / PPM, vector.y / PPM);
	}

	public static Vector3 toPPM(Vector3 vector) {
		vector.x = vector.x / PPM;
		vector.y = vector.y / PPM;
		vector.z = vector.z / PPM;
		return vector;
	}

	public static Rectangle toPPM(Rectangle rect) {
		rect.setSize(rect.getWidth() / PPM, rect.getHeight() / PPM);
		rect.setPosition(rect.getX() / PPM, rect.getY() / PPM);
		return rect;
	}

	public static float toScreen(float x) {
		return x * PPM;
	}

	public static Vector2 toScreen(Vector2 vector) {
		return new Vector2(vector.x * PPM, vector.y * PPM);
	}

	/**
	 * Return la position relative d'un pointer par rapport a un body en unité box2D
	 * 
	 * @param screenX
	 * @param screenY
	 * @param body
	 * @return
	 */
//	public static Vector2 relativePositionMouseFromOtherPoint(int screenX, int screenY, Vector2 position) {
//		Vector2 screenMetricsBody = toScreenMetrics(position);
//		Vector2 mousePosition = InputCalculUtils.relativePositionPointerFromPoint(screenX, screenY, screenMetricsBody);
//		return toBox2DMetrics(mousePosition);
//	}
}
