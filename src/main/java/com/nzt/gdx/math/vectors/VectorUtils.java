package com.nzt.gdx.math.vectors;

import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.utils.Array;

public class VectorUtils {

    public static <V extends Vector<V>> V directionTo(V from, V to) {
        return from.cpy().sub(to).nor();
    }

    public static <V extends Vector<V>> V getVelocityTo(float time, V from, V to) {
        V directionTo = directionTo(from, to);
        float dst = from.dst(to);
        V scl = directionTo.scl(dst / time);
        return scl;
    }

    public static <V extends Vector<V>> V getFarthest(V v1, Array<V> arrayV2) {
        float dstClose = 0;
        V tmp = null;
        for (V v : arrayV2) {
            if (v != null) {
                float newDst = v1.dst(v);
                if (newDst > dstClose) {
                    tmp = v;
                    dstClose = newDst;
                }
            }
        }
        return tmp;
    }

    public static <V extends Vector<V>> V getClosest(V v1, Array<V> arrayV2) {
        float dstClose = Float.MAX_VALUE;
        V tmp = null;
        for (V v : arrayV2) {
            if (v != null) {
                float newDst = v1.dst(v);
                if (newDst < dstClose) {
                    tmp = v;
                    dstClose = newDst;
                }
            }
        }
        return tmp;
    }
}
