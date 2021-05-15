package com.nzt.gdx.math.bits;

public class BitsUtils {

    private BitsUtils() {
    }

    public static boolean isOne(int binary, int n) {
        return (binary >>> n & 1) != 0;
    }

    public static boolean isOne(int binary, int... array) {
        for (int i = 0, n = array.length; i < n; i++) {
            if ((binary >>> array[i] & 1) == 0)
                return false;
        }
        return true;
    }

    public static boolean oneTrue(int binary) {
        return binary != 0;
    }

    public static boolean oneFalse(int binary) {
        int total = 0;
        int count = 0;
        while (binary > total) {
            total += 1 << count;
            int compare = binary & total;
            if (compare < 1 << count)
                return true;
        }
        return false;
    }

    public static boolean oneFalse(int binary, int minSize) {
        if (binary < 1 << minSize)
            return false;
        int compare = binary & 1;
        return compare != binary;
    }

    public static boolean isOne(short binary, int n) {
        return (binary >>> n & 1) != 0;
    }

    public static boolean isOne(short binary, int... array) {
        for (int i = 0, n = array.length; i < n; i++) {
            if ((binary >>> array[i] & 1) == 0)
                return false;
        }
        return true;
    }

    public static boolean isOne(long binary, short n) {
        return (binary >>> n & 1) != 0;
    }

    public static boolean isOne(long binary, int... array) {
        for (int i = 0, n = array.length; i < n; i++) {
            if ((binary >>> array[i] & 1) == 0)
                return false;
        }
        return true;
    }
}
