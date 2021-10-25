package com.nzt.gdx.utils;

public class ArrayUtils {


    public static <T> void removeAndDecal(T[] array, int index) {

        for (int i = index, n = array.length - 1; i < n; i++) {
            array[i] = array[i + 1];
        }
        array[array.length-1] = null;
    }
}
