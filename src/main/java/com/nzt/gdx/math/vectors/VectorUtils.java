package com.nzt.gdx.math.vectors;

import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class VectorUtils {

    //TODO viré le cpy
    public static <V extends Vector<V>> V directionTo(V from, V to) {
        return from.cpy().sub(to).nor();
    }
    //TODO viré le cpy
    public static <V extends Vector<V>> V getVelocityTo(float time, V from, V to) {
        V directionTo = directionTo(from, to);
        float dst = from.dst(to);
        V scl = directionTo.scl(dst / time);
        return scl;
    }

    //TODO chai pas http://www.3dkingdoms.com/weekly/weekly.php?a=2
    //https://gamedev.stackexchange.com/questions/23672/determine-resulting-angle-of-wall-collision
//    public static <V extends Vector<V>> V reflect(Vector2 vector, Vector2 normal, Vector2 result) {
//        // return vector - 2 * Vector2.Dot(vector, normal) * normal;
//        Vector2 tmp = new Vector2();
//        result.set(vector);
//        tmp.set(vector).dot(normal)
//        return
//    }

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
