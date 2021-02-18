package com.nzt.gdx.perf;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;

//TODO a voir avec le multithread
public class Vector2Pool extends Pool<Vector2> {
    @Override
    protected Vector2 newObject() {
        return new Vector2();
    }
}
