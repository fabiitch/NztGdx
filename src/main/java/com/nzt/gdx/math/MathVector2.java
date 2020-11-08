package com.nzt.gdx.math;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;

public class MathVector2 {

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


}
