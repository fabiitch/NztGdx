package com.nzt.gdx.utils;

public class ArrayUtils {

    /**
     * all value to null
     */
    public static <T> void clearValues(T[] array) {
        for (int i = 0, n = array.length; i < n; i++) {
            array[i] = null;
        }
    }

    public static <T> void removeAndDecal(T[] array, int index) { //TODO voir si plus rapid
        for (int i = index, n = array.length - 1; i < n; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = null;
    }
}
