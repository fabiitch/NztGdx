package com.nzt.gdx.math.vectors;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;

public class Vector2Utils {

    private static Vector2 tmp; // TODO use ? server pb?

    public static Vector2 getVelocityTo(float time, Vector2 from, Vector2 to) {
        Vector2 directionTo = directionTo(from, to);
        float dst = from.dst(to);
        Vector2 scl = directionTo.scl(dst / time);
        return scl;
    }

    public static Vector directionTo(Vector from, Vector to) {
        return from.cpy().sub(to).nor();
    }

    public static Vector2 directionTo(Vector2 from, Vector2 to) {
        return from.cpy().sub(to).nor();
    }

    public static float getAngleDegreesOfVector(Vector2 vector) {
        return MathUtils.atan2(vector.y, vector.x) * MathUtils.radDeg;
    }

    public static float getAngleRadianOfVector(Vector2 vector) {
        return MathUtils.atan2(vector.y, vector.x);
    }

    public static Vector2 getMiddle(Vector2 v1, Vector2 v2) {
        Vector2 result = new Vector2();
        result.set((v2.x + v1.x) / 2, (v2.y + v1.y) / 2);
        return result;
    }

    public static Vector2 getClosest(Vector2 v1, Vector2... arrayV2) {
        float dstClose = Float.MAX_VALUE;
        Vector2 tmp = null;
        for (Vector2 v : arrayV2) {
            if (v != null) {
                if (v1.dst(v) < dstClose) {
                    tmp = v;
                }
            }
        }
        return tmp;
    }
}
