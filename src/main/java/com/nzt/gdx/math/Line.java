package com.nzt.gdx.math;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;

/**
 * Ax + b equation
 * //TODO WIP
 */
public class Line implements Pool.Poolable {
    public float a, b;

    public Line(float a, float b) {
        this.a = a;
        this.b = b;
    }

    public Vector2 point(float x) {
        return new Vector2(x, y(x));
    }

    public float y(float x) {
        return a * x + b;
    }

    @Override
    public void reset() {
        a = b = 0;
    }
}
