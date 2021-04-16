package com.nzt.gdx.math.vectors;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/**
 * Static method for Vector2
 */
public class V2 {
    private static Vector2 tmp; // TODO use ? server pb?

    public static float angleDeg(Vector2 v) {
        float angle = MathUtils.atan2(v.y, v.x) * MathUtils.radiansToDegrees;
        if (angle < 0) angle += 360;
        return angle;
    }
    public static float angleRad(Vector2 v) {
        return MathUtils.atan2(v.y, v.x);
    }

    public static float angleDeg(Vector2 v1, Vector2 reference) {
        float angle = MathUtils.atan2(reference.crs(v1), reference.dot(v1)) * MathUtils.radiansToDegrees;
        if (angle < 0) angle += 360;
        return angle;
    }


    //TODO de la merdia ya un new
    public static Vector2 getMiddle(Vector2 vReturn, Vector2 v1, Vector2 v2) {
        vReturn.set((v2.x + v1.x) / 2, (v2.y + v1.y) / 2);
        return vReturn;
    }


}
