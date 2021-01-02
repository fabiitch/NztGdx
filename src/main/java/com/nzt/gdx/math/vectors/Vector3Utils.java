package com.nzt.gdx.math.vectors;

import com.badlogic.gdx.math.Vector3;

public class Vector3Utils {

    private static Vector3 tmp; // TODO use ? server pb?

    public static Vector3 getVelocityTo(float time, Vector3 from, Vector3 to) {
        Vector3 directionTo = directionTo(from, to);
        float dst = from.dst(to);
        Vector3 scl = directionTo.scl(dst / time);
        return scl;
    }

    /**
     * direction vector is nor
     */
    public static Vector3 directionTo(Vector3 from, Vector3 to) {
        return from.cpy().sub(to).nor();
    }
}
