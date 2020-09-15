package com.nzt.gdx.input.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;

public abstract class InputUtils {

	public static int yTo2DCoords(int y) {
		return Gdx.graphics.getHeight() - 1 - y;
	}
	
	
	public static Vector3 getWorldCoord(int screenX, int screenY, Camera camera) {
		Ray ray = camera.getPickRay(screenX, screenY);
		final Plane xzPlane = new Plane(new Vector3(0, 0, 1), 0);
		final Vector3 intersection = new Vector3();
		Intersector.intersectRayPlane(ray, xzPlane, intersection);
		return intersection;
	}
}