package com.nzt.gdx.test.api.math.shape.utils;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shapes.Triangle;
import com.nzt.gdx.math.shapes.builders.TriangleBuilder;
import com.nzt.gdx.math.shapes.utils.PolygonUtils;
import com.nzt.gdx.test.api.math.vectors.VTestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PolygonUtilsTest {
    private static Vector2 tmp = new Vector2();

    float[] vertices = new float[]{0, 0, 50, 50, 60, 60, 300, 0};
    Polygon polygon = new Polygon(vertices);

    @Test
    public void getMaxDstFromZeroTest() {
        float maxDstVertexFromZero = PolygonUtils.getMaxDstVertexFromZero(polygon, tmp);
        float maxDstVertexFromZero2 = PolygonUtils.getMaxDstVertexFromZero(polygon);

        VTestUtils.assertEquals(new Vector2(300, 0), tmp);
        Assertions.assertEquals(300, maxDstVertexFromZero);
        Assertions.assertEquals(300, maxDstVertexFromZero2);
    }

    @Test
    public void getVertex() {
        PolygonUtils.getVertex(polygon, 0, tmp);
        VTestUtils.assertEquals(new Vector2(0, 0), tmp);

        PolygonUtils.getVertex(polygon, 1, tmp);
        VTestUtils.assertEquals(new Vector2(50, 50), tmp);

        PolygonUtils.getVertex(polygon, 2, tmp);
        VTestUtils.assertEquals(new Vector2(60, 60), tmp);

        PolygonUtils.getVertex(polygon, 3, tmp);
        VTestUtils.assertEquals(new Vector2(300, 0), tmp);
    }

    @Test
    public void getVertexAngleTest() {
        Polygon rect = new Polygon(new float[]{0, 0, 100, 0, 100, 50, 0, 50});
        float angleA = PolygonUtils.getVertexAngleDeg(rect, 0);
        Assertions.assertEquals(90, angleA, 0);

        float angleB = PolygonUtils.getVertexAngleDeg(rect, 1);
        Assertions.assertEquals(90, angleB, 0);

        float angleC = PolygonUtils.getVertexAngleDeg(rect, 2);
        Assertions.assertEquals(90, angleC, 0);

        float angleD = PolygonUtils.getVertexAngleDeg(rect, 3);
        Assertions.assertEquals(90, angleD, 0);

    }

    @Test
    public void getVertexAngleTest2() {
        Triangle triangle = TriangleBuilder.isoscelesRectangle(0, new Vector2(), 50);

        float angleA = PolygonUtils.getVertexAngleDeg(triangle, 0);
        Assertions.assertEquals(90, angleA, 0);

        float angleB = PolygonUtils.getVertexAngleDeg(triangle, 1);
        Assertions.assertEquals(45, angleB, 0);

        float angleC = PolygonUtils.getVertexAngleDeg(triangle, 2);
        Assertions.assertEquals(45, angleC, 0);

    }

    @Test
    public void isConvex() {
        Polygon rect = new Polygon(new float[]{0, 0, 100, 0, 100, 50, 0, 50});
        Assertions.assertTrue(PolygonUtils.isConvex(rect));

        Triangle triangle = TriangleBuilder.isoscelesRectangle(0, new Vector2(), 50);
        Assertions.assertTrue(PolygonUtils.isConvex(triangle));

        Assertions.assertTrue(PolygonUtils.isConvex(polygon));

        Polygon concavePoly = new Polygon(new float[]{0, 0, 5, 5, 0, 10, 20, 10, 20, 0});
        Assertions.assertFalse(PolygonUtils.isConvex(concavePoly));
    }
}
