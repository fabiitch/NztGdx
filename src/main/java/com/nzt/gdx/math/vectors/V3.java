package com.nzt.gdx.math.vectors;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class V3 {

    private static Vector3 tmp = new Vector3(); // TODO use ? server pb?

    private V3() {

    }

    public static Vector3 tmp(float x, float y) {
        return tmp.set(x, y, 0);
    }

    public static Vector3 tmp(Vector2 vector2) {
        return tmp.set(vector2, 0);
    }

    public static Vector3 tmp(Vector3 vector3) {
        return tmp.set(vector3);
    }

    public static Vector3 set(Vector3 v, Vector2 values) {
        v.x = values.x;
        v.y = values.y;
        return v;
    }
}
