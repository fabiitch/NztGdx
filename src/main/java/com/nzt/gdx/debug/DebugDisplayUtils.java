package com.nzt.gdx.debug;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.text.DecimalFormat;

public class DebugDisplayUtils {
    private static DecimalFormat df = new DecimalFormat();

    {
        df.setMaximumFractionDigits(4);
    }

    public static String printValue(Object o) {
        if (o instanceof Number)
            return df.format(o);
        if (o instanceof Vector2)
            return printVector2((Vector2) o);
        if (o instanceof Vector3)
            return printVector3((Vector3) o);

        return o.toString();
    }

    public static String printFloat(float f) {
        return df.format(f);
    }

    public static String printVector2(Vector2 v) {
        return "(" + df.format(v.x) + " , " + df.format(v.y) + ")";
    }

    public static String printVector3(Vector3 v) {
        return "(" + df.format(v.x) + " , " + df.format(v.y) + " , " + df.format(v.z) + ")";
    }
}
