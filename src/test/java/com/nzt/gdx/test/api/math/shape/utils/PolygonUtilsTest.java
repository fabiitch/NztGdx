package com.nzt.gdx.test.api.math.shape.utils;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shapes.Segment;
import com.nzt.gdx.math.shapes.Triangle;
import com.nzt.gdx.math.shapes.builders.TriangleBuilder;
import com.nzt.gdx.math.shapes.utils.PolygonUtils;
import com.nzt.gdx.test.api.math.vectors.VTestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PolygonUtilsTest {
    private static final Vector2 tmp = new Vector2();

    float[] vertices = new float[]{0, 0, 50, 50, 60, 60, 300, 0};
    Polygon polygon = new Polygon(vertices);

    @Test
    public void verticesAsVectorsTest() {
        Vector2[] verticesAsVectors = PolygonUtils.getVerticesAsVectors(polygon);
        VTestUtils.assertEquals(new Vector2(0, 0), verticesAsVectors[0]);
        VTestUtils.assertEquals(new Vector2(50, 50), verticesAsVectors[1]);
        VTestUtils.assertEquals(new Vector2(60, 60), verticesAsVectors[2]);
        VTestUtils.assertEquals(new Vector2(300, 0), verticesAsVectors[3]);
    }

    @Test
    public void getVertexBeforeTest() {
        int maxIndex = vertices.length / 2 - 1; //3
        Assertions.assertEquals(maxIndex, PolygonUtils.getVertexBefore(polygon, 0));
        Assertions.assertEquals(0, PolygonUtils.getVertexBefore(polygon, 1));
        Assertions.assertEquals(1, PolygonUtils.getVertexBefore(polygon, 2));
        Assertions.assertEquals(2, PolygonUtils.getVertexBefore(polygon, 3));
        Assertions.assertEquals(maxIndex, PolygonUtils.getVertexBefore(polygon, 4));
        Assertions.assertEquals(0, PolygonUtils.getVertexBefore(polygon, 5));
        Assertions.assertEquals(1, PolygonUtils.getVertexBefore(polygon, 6));
    }

    @Test
    public void getVertexAfterTest() {
        Assertions.assertEquals(1, PolygonUtils.getVertexAfter(polygon, 0));
        Assertions.assertEquals(2, PolygonUtils.getVertexAfter(polygon, 1));
        Assertions.assertEquals(3, PolygonUtils.getVertexAfter(polygon, 2));
        Assertions.assertEquals(0, PolygonUtils.getVertexAfter(polygon, 3));
        Assertions.assertEquals(1, PolygonUtils.getVertexAfter(polygon, 4));
        Assertions.assertEquals(2, PolygonUtils.getVertexAfter(polygon, 5));
        Assertions.assertEquals(3, PolygonUtils.getVertexAfter(polygon, 6));
    }

    @Test
    public void getMaxDstFromZeroTest() {
        float maxDstVertexFromZero = PolygonUtils.getMaxDstVertex(polygon, tmp);
        float maxDstVertexFromZero2 = PolygonUtils.getMaxDstVertex(polygon);

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

    @Test
    public void getNearestSegment() {
        Segment result = new Segment();
        Polygon rect = new Polygon(new float[]{0, 0, 100, 0, 100, 50, 0, 50});

        PolygonUtils.getNearestSegment(rect, new Vector2(50, 150), result);
        Assertions.assertTrue(result.equalsPoints(new Segment(0, 50, 100, 50)));

        PolygonUtils.getNearestSegment(rect, new Vector2(-25, 25), result);
        Assertions.assertTrue(result.equalsPoints(new Segment(0, 0, 0, 50)));

        PolygonUtils.getNearestSegment(rect, new Vector2(600, 25), result);
        Assertions.assertTrue(result.equalsPoints(new Segment(100, 0, 100, 50)));

        PolygonUtils.getNearestSegment(rect, new Vector2(50, -150), result);
        Assertions.assertTrue(result.equalsPoints(new Segment(0, 0, 100, 0)));

        //inside
        PolygonUtils.getNearestSegment(rect, new Vector2(50, 10), result);
        Assertions.assertTrue(result.equalsPoints(new Segment(0, 0, 100, 0)));
    }
}
