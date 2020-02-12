package com.nzt.gdx.math.shape.circle;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;


public class CircleUtils {
	
	//TODO remove new Vector2
	public static Vector2 positionOnACircleWithAngle(Vector2 positionStart, float rayon, float angleRadian) {
		Vector2 position = new Vector2();
		position.x = (float) (positionStart.x + rayon * MathUtils.cos(angleRadian));
		position.y = (float) (positionStart.y + rayon * MathUtils.sin(angleRadian));
		return position;
	}
}
