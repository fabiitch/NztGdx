package com.nzt.gdx.math;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shapes.Segment2D;
import com.nzt.gdx.math.vectors.V2;

public class AngleUtils {
    private AngleUtils() {

    }

    private static Vector2 tmp = new Vector2();

    public static float angleIncidenceDeg(float angleReflexionDeg) {
        return 180 + angleReflexionDeg;
    }

    public static float angleIncidenceRad(float angleReflexionRad) {
        return MathUtils.PI + angleReflexionRad;
    }

    public static float angleReflexionDeg(Segment2D segment, Vector2 dir) {
        Vector2 normal = segment.getNormale(tmp);
        return V2.angleDeg(normal) - (V2.angleDeg(dir) - V2.angleDeg(normal));
    }

    public static float angleReflexionRad(Segment2D segment, Vector2 dir) {
        Vector2 normal = segment.getNormale(tmp);
        return V2.angleRad(normal) - (V2.angleRad(dir) - V2.angleRad(normal));
    }

    public static float angleIncidenceDeg(Segment2D segment, Vector2 dir) {
        return 180 + angleReflexionDeg(segment, dir);
    }

    public static float angleIncidenceRad(Segment2D segment, Vector2 dir) {
        return MathUtils.PI + angleIncidenceRad(segment, dir);
    }

    public static float distanceAbs(float alpha, float beta) {
        float phi = Math.abs(beta - alpha) % 360; // This is either the distance or 360 - distance
        float distance = phi > 180 ? 360 - phi : phi;
        return distance;
    }

    public static float distanceAbs(Vector2 dir, Vector2 input) {
        return distanceAbs(V2.angleDeg(dir), V2.angleDeg(input));
    }

    public static float distanceSigned(float a, float b) {
        float d = Math.abs(a - b) % 360;
        float r = d > 180 ? 360 - d : d;

        // calculate sign
        int sign = (a - b >= 0 && a - b <= 180) || (a - b <= -180 && a - b >= -360) ? 1 : -1;
        r *= sign;
        return r;
    }

    public static float distanceSigned(Vector2 dir, Vector2 input) {
        return distanceSigned(V2.angleDeg(dir), V2.angleDeg(input));
    }
}
