package com.nzt.gdx.test.math.vectors;

import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.vectors.Vector2Utils;
import com.nzt.gdx.math.vectors.VectorUtils;

import org.junit.Assert;
import org.junit.Test;

public class Vector2UtilsTest {

    @Test
    public void getClosestTest() {
        Vector2 v1 = v(0, 0);
        Vector2 v2 = v(10, 0);
        Vector2 v3 = v(5, 0);
        Vector2 closest = VectorUtils.getClosest(v1, v2, v3, null, null);
        Assert.assertEquals(closest, v3);
    }
    @Test
    public void getMiddleTest() {
        Vector2 v1 = v(5, 5);
        Vector2 v2 = v(10, 10);
        Vector2 closest = Vector2Utils.getMiddle(v1, v2);
        Assert.assertEquals(closest, new Vector2(7.5f,7.5f));
    }

    private Vector2 v(float a, float b) {
        return new Vector2(a, b);
    }
}
