package com.nzt.gdx.utils.arrays;

import com.badlogic.gdx.utils.Array;

public class GdxArrayUtils {

    public static <T> Array<T> addIfNotPresent(Array<T> array, T value) {
        if (!array.contains(value, true)) {
            array.add(value);
        }
        return array;
    }
}
