package com.nzt.gdx.debug.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.TimeUtils;

import java.text.DecimalFormat;

public class DebugDisplayUtils {
    private static DecimalFormat floatFormatter = new DecimalFormat();
    private static DecimalFormat msFormatter = new DecimalFormat();

    {
        floatFormatter.setMaximumFractionDigits(4);
        msFormatter.setMaximumFractionDigits(0);
    }


    public static String printMs(float f) {
        return (int) f + "ms";
    }

    public static String printNanoToMs(long nano) {
        return TimeUtils.nanosToMillis(nano) + "ms";
    }

    public static String printValue(Object o) {
        if (o instanceof Number)
            return floatFormatter.format(o);
        if (o instanceof Vector2)
            return printVector2((Vector2) o);
        if (o instanceof Vector3)
            return printVector3((Vector3) o);

        return o.toString();
    }

    public static String printFloat(float f) {
        if (f == 0)
            return "0";
        return floatFormatter.format(f);
    }

    public static String printVector2(Vector2 v) {
        if (v.isZero())
            return Vector2.Zero.toString();
        return "(" + floatFormatter.format(v.x) + " , " + floatFormatter.format(v.y) + ")";
    }

    public static String printVector3(Vector3 v) {
        if (v.isZero())
            return Vector3.Zero.toString();
        return "(" + floatFormatter.format(v.x) + " , " + floatFormatter.format(v.y) + " , " + floatFormatter.format(v.z) + ")";
    }
}
