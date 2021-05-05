package com.nzt.gdx.test.api.math.vectors;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.math.vectors.V2;
import com.nzt.gdx.math.vectors.V;

import org.junit.Assert;
import org.junit.Test;

public class V2Test {

    @Test
    public void getClosestTest() {
        Vector2 start = v(0, 0);
        Vector2 v1 = v(8, 2);
        Vector2 v2 = v(10, 0);
        Vector2 v3 = v(5, 0);
        Array<Vector2> vector2Array = new Array<>();
        vector2Array.add(v1, v2, v3, null);

        Vector2 closest = V.getClosest(start, vector2Array);
        Assert.assertEquals(closest, v3);
    }

    @Test
    public void getMiddleTest() {
        Vector2 v1 = v(5, 5);
        Vector2 v2 = v(10, 10);
        Vector2 closest = V2.getMiddle(new Vector2(), v1, v2);
        Assert.assertEquals(closest, new Vector2(7.5f, 7.5f));
    }

    @Test
    public void toFloatArrayTest() {
        Array<Vector2> array = new Array<>();
        array.add(v(0, 0));
        array.add(v(10, 10));
        array.add(v(15, 15));
        array.add(v(5, 5));

        float[] floats = V2.toFloatArray(array);

        Assert.assertEquals(0, floats[0] + floats[1], 0);
        Assert.assertEquals(20, floats[2] + floats[3], 0);
        Assert.assertEquals(30, floats[4] + floats[5], 0);
        Assert.assertEquals(10, floats[6] + floats[7], 0);

    }

    private Vector2 v(float a, float b) {
        return new Vector2(a, b);
    }
}
