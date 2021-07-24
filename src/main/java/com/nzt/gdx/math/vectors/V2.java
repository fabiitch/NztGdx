package com.nzt.gdx.math.vectors;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

/**
 * Static method for Vector2 using mathUtils (no native)
 */
public class V2 {
    private static Vector2 tmp = new Vector2(); // TODO use ? server pb?

    private V2() {

    }

    public static Vector2 tmp(float x, float y) {
        return tmp.set(x, y);
    }

    public static Vector2 tmp(Vector2 vector2) {
        return tmp.set(vector2.x, vector2.y);
    }

    public static Vector2 tmp(Vector3 vector3) {
        return tmp.set(vector3.x, vector3.y);
    }


    public static Vector2 changeDirection(Vector2 velocity, Vector2 dir) {
        dir.nor();
        float len = velocity.len();
        velocity.set(dir).setLength(len);
        return velocity;
    }

    public static Vector2 inv(Vector2 v) {
        v.x = -v.x;
        v.y = -v.y;
        return v;
    }

    public static Vector2 directionTo(Vector2 from, Vector2 to, Vector2 result) {
        return result.set(to.x - from.x, to.y - from.y).nor();
    }

    public static float[] toFloatArray(Array<Vector2> array) {
        return toFloatArray(array.toArray(Vector2.class));
    }

    public static float[] toFloatArray(Vector2[] array) {
        float[] verts = new float[array.length * 2];
        for (int i = 0, j = 0; i < array.length * 2; i += 2, j++) {
            verts[i] = array[j].x;
            verts[i + 1] = array[j].y;
        }
        return verts;
    }

    public static float angleDeg(Vector2 v) {
        float angle = MathUtils.atan2(v.y, v.x) * MathUtils.radiansToDegrees;
        if (angle < 0)
            angle += 360;
        return angle;
    }

    public static float angleRad(Vector2 v) {
        return MathUtils.atan2(v.y, v.x);
    }

    public static float angleDeg(Vector2 v1, Vector2 reference) {
        float angle = MathUtils.atan2(reference.crs(v1), reference.dot(v1)) * MathUtils.radiansToDegrees;
        if (angle < 0)
            angle += 360;
        return angle;
    }

    // TODO de la merdia ya un new
    public static Vector2 getMiddle(Vector2 vReturn, Vector2 v1, Vector2 v2) {
        vReturn.set((v2.x + v1.x) / 2, (v2.y + v1.y) / 2);
        return vReturn;
    }

}
