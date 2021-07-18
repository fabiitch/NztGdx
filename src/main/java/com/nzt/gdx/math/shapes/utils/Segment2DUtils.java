package com.nzt.gdx.math.shapes.utils;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shapes.Segment2D;

public class Segment2DUtils {

	private Segment2DUtils() {

	}

	public static Vector2 getSegmentIntersection(Segment2D s1, Segment2D s2) {
		return getSegmentIntersection(s1.a, s1.b, s2.a, s2.b);
	}

	public static Vector2 intersect(Segment2D s1, Segment2D s2) {
		return getSegmentIntersection(s1.a, s1.b, s2.a, s2.b);
	}

	public static boolean getSegmentIntersection(Segment2D s1, Segment2D s2, Vector2 intersection) {
		return Intersector.intersectSegments(s1.a, s1.b, s2.a, s2.b, intersection);
	}

	public static Vector2 getSegmentIntersection(Vector2 p1Start, Vector2 p1End, Vector2 p2Start, Vector2 p2End) {
		Vector2 intersection = new Vector2();
		boolean b = Intersector.intersectSegments(p1Start, p1End, p2Start, p2End, intersection);
		return b ? intersection : null;
	}

	public static float getAngleReflexion(Segment2D segment, Vector2 direction) {
		Vector2 normal = segment.getNormale();
		float angleReflection = normal.angleDeg() - (direction.angleDeg() - normal.angleDeg());
		return angleReflection;
	}

}
