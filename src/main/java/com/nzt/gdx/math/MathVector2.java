package com.nzt.gdx.math;

import com.badlogic.gdx.math.Vector2;

public class MathVector2 {

	private static Vector2 tmp; // TODO use ? server pb?

	public static Vector2 getVelocityTo(float time, Vector2 from, Vector2 to) {
		Vector2 directionTo = directionTo(from, to);
		float dst = from.dst(to);
		Vector2 scl = directionTo.scl(dst / time);
		return scl;
	}

	/**
	 * direction vector is nor
	 */
	public static Vector2 directionTo(Vector2 from, Vector2 to) {
		return from.cpy().sub(to).nor();
	}
}
