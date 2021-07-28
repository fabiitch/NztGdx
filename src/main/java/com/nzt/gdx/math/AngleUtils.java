package com.nzt.gdx.math;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shapes.Segment;
import com.nzt.gdx.math.vectors.V2;

public class AngleUtils {
    private AngleUtils() {

    }
    private static Vector2 tmp = new Vector2();

    /**
     *  Angle incidence, angle collision
     *  Angle reflexion, angle rebond
     * https://fr.wikipedia.org/wiki/Lois_de_Snell-Descartes
     * https://upload.wikimedia.org/wikipedia/commons/9/91/Reflexion_fr.png?uselang=fr
     * */

    public static float reflexionToIncidence(float angleReflexionDeg) {
        return 180 + angleReflexionDeg;
    }

    public static float angleIncidenceRad(float angleReflexionRad) {
        return MathUtils.PI + angleReflexionRad;
    }

    public static float angleIncidenceDeg(Segment segment, Vector2 dir) {
        return reflexionToIncidence(angleReflexionDeg(segment, dir));
    }

    public static float angleReflexionDeg(Segment segmentIntersect, Vector2 dir) {
        Vector2 normal = segmentIntersect.getNormale(tmp);
        return V2.angleDeg(normal) - (V2.angleDeg(dir) - V2.angleDeg(normal));
    }

    public static float angleReflexionRad(Segment segment, Vector2 dir) {
        Vector2 normal = segment.getNormale(tmp);
        return V2.angleRad(normal) - (V2.angleRad(dir) - V2.angleRad(normal));
    }

    public static float reflexionToIncidence(Segment segment, Vector2 dir) {
        return 180 + angleReflexionDeg(segment, dir);
    }

    public static float angleIncidenceRad(Segment segment, Vector2 dir) {
        return MathUtils.PI + angleIncidenceRad(segment, dir);
    }

    public static float angleReflexionDeg(Vector2 dirEdge, Vector2 dirBullet) {
        Vector2 normal = V2.getNormal(dirEdge, tmp);
        return V2.angleDeg(normal) - (V2.angleDeg(dirBullet) - V2.angleDeg(normal));
    }

    public static float angleReflexionRad(Vector2 dirEdge, Vector2 dirBullet) {
        Vector2 normal = V2.getNormal(dirEdge, tmp);
        return V2.angleRad(normal) - (V2.angleRad(dirBullet) - V2.angleRad(normal));
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

    public static float distanceSigned(Vector2 v1, Vector2 v2) {
        return distanceSigned(V2.angleDeg(v1), V2.angleDeg(v2));
    }
}
