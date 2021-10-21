package com.nzt.gdx.test.api.math.shape.utils;

import com.nzt.gdx.math.shapes.utils.TriangleRectUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleRectUtilsTest {

    private final static float TOLERANCE = 1f;

    /**
     * result from https://www.calculat.org/fr/aire-perimetre/triangle-rectangle.html
     */
    @Test
    public void hypoFromAdjacentTest() {
        Assertions.assertEquals(14.14f, TriangleRectUtils.hypoFromAdjacent(10, 45), TOLERANCE);
        Assertions.assertEquals(25.56f, TriangleRectUtils.hypoFromAdjacent(25, 12), TOLERANCE);
        Assertions.assertEquals(25.56f, TriangleRectUtils.hypoFromAdjacent(25, 12), TOLERANCE);
        Assertions.assertEquals(190.04f, TriangleRectUtils.hypoFromAdjacent(33, 80), TOLERANCE);
    }
}
