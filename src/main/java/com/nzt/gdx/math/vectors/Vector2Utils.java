package com.nzt.gdx.math.vectors;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Vector2Utils {

    private static Vector2 tmp; // TODO use ? server pb?

    public static float angleDeg(Vector2 vector) {
        return MathUtils.atan2(vector.y, vector.x) * MathUtils.radDeg;
    }

    public static float angleRad(Vector2 vector) {
        return MathUtils.atan2(vector.y, vector.x);
    }


    //TODO de la merdia ya un new
    public static Vector2 getMiddle(Vector2 v1, Vector2 v2) {
        Vector2 result = new Vector2();
        result.set((v2.x + v1.x) / 2, (v2.y + v1.y) / 2);
        return result;
    }


}
