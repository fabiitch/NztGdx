package com.nzt.gdx.math.shapes.utils;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shapes.Segment;
import com.nzt.gdx.math.vectors.V2;

public class SegmentUtils {

    public static Segment tmpSegment = new Segment();
    private static final Vector2 tmpV1 = new Vector2();

    private SegmentUtils() {

    }

    public static Vector2 closestPoint(Segment segment2D, Vector2 point, Vector2 result) {
        return Intersector.nearestSegmentPoint(segment2D.a, segment2D.b, point, result);
    }

    public static boolean getSegmentIntersection(Segment s1, Segment s2, Vector2 intersection) {
        return Intersector.intersectSegments(s1.a, s1.b, s2.a, s2.b, intersection);
    }

    public static float getAngleReflexionDeg(Segment segment, Vector2 direction) {
        Vector2 normal = segment.getNormal(tmpV1);
        if (normal.hasOppositeDirection(direction))
            normal.rotateDeg(180);
        float angleReflection = V2.angleDeg(normal) - (direction.angleDeg() - normal.angleDeg());
        return angleReflection;
    }

}
