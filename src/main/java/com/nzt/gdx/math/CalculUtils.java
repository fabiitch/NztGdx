package com.nzt.gdx.math;

public class CalculUtils {
    //TODO présent en java8 sur Math
    public static int floorMod(int x, int y) {
        int r = x - floorDiv(x, y) * y;
        return r;
    }

    //TODO présent en java8 sur Math
    public static int floorDiv(int x, int y) {
        int r = x / y;
        // if the signs are different and modulo not zero, round down
        if ((x ^ y) < 0 && (r * y != x)) {
            r--;
        }
        return r;
    }
}
