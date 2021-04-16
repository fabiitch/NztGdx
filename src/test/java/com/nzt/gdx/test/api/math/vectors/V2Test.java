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

    private Vector2 v(float a, float b) {
        return new Vector2(a, b);
    }
}
