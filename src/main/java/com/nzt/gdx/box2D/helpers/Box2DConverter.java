package com.nzt.gdx.box2D.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.nzt.gdx.logger.tag.LogTagBase;
import com.nzt.gdx.logger.tag.TagLogger;

public class Box2DConverter {
	private static float PPM;

	public static void initMetrics(float ppm) {
		Box2DConverter.PPM = ppm;
		TagLogger.log(LogTagBase.INIT, "Box2DConverter PPM = " + PPM);
	}

	public static float heightScreenToPPM() {
		return Gdx.graphics.getHeight() / PPM;
	}

	public static float widthScreenToPPM() {
		return Gdx.graphics.getWidth() / PPM;
	}

	public static float toPPM(float x) {
		return x / PPM;
	}

	public static Vector2 newToPPM(Vector2 vector) {
		return new Vector2(vector.x / PPM, vector.y / PPM);
	}

	public static Vector2 toPPM(Vector2 vector) {
		return vector.set(vector.x / PPM, vector.y / PPM);
	}

	public static Vector3 newToPPM(Vector3 vector) {
		return new Vector3(vector.x / PPM, vector.y / PPM, vector.z / PPM);
	}

	public static Vector3 toPPM(Vector3 vector) {
		return vector.set(vector.x / PPM, vector.y / PPM, vector.z / PPM);
	}

	public static Rectangle toPPM(Rectangle rect) {
		return rect.set(rect.getX() / PPM, rect.getY() / PPM, rect.getWidth() / PPM, rect.getHeight() / PPM);
	}

	public static float toScreen(float x) {
		return x * PPM;
	}

	public static Vector2 newToScreen(Vector2 vector) {
		return new Vector2(vector.x * PPM, vector.y * PPM);
	}

	public static Vector2 newToToScreen(Vector2 vector) {
		return new Vector2(vector.x * PPM, vector.y * PPM);
	}

	public static Vector2 toScreen(Vector2 vector) {
		return vector.set(vector.x * PPM, vector.y * PPM);
	}

	public static Vector3 newToScreen(Vector3 vector) {
		return new Vector3(vector.x * PPM, vector.y * PPM, vector.z * PPM);
	}

	public static Vector3 toScreen(Vector3 vector) {
		return vector.set(vector.x * PPM, vector.y * PPM, vector.z * PPM);
	}

	/**
	 * Return la position relative d'un pointer par rapport a un body en unité
	 * box2D
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
