package com.nzt.gdx.math;

import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shape.Segment2D;

public class AngleUtils {

    public static float angleReflexion(Segment2D segment, Vector2 dir) {
        Vector2 normal = segment.getNormale();
        return normal.angleDeg() - (dir.angleDeg() - normal.angleDeg());
    }

    public static float angleIncidence(float angleReflexion) {
        return 180 + angleReflexion;
    }

    public static float angleIncidence(Segment2D segment, Vector2 dir) {
        return 180 + angleReflexion(segment, dir);
    }

    public static float distanceAbs(float alpha, float beta) {
        float phi = Math.abs(beta - alpha) % 360; // This is either the distance or 360 - distance
        float distance = phi > 180 ? 360 - phi : phi;
        return distance;
    }

    public static float distanceAbs(Vector2 dir, Vector2 input) {
        return distanceAbs(dir.angleDeg(), input.angleDeg());
    }

    public static float distanceSigned(float a, float b) {
        float d = Math.abs(a - b) % 360;
        float r = d > 180 ? 360 - d : d;

        //calculate sign
        int sign = (a - b >= 0 && a - b <= 180) || (a - b <= -180 && a - b >= -360) ? 1 : -1;
        r *= sign;
        return r;
    }

    public static float distanceSigned(Vector2 dir, Vector2 input) {
        return distanceSigned(dir.angleDeg(), input.angleDeg());
    }


}
