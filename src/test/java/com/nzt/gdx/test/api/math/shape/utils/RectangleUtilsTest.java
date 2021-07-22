package com.nzt.gdx.test.api.math.shape.utils;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shapes.Segment2D;
import com.nzt.gdx.math.shapes.utils.RectangleUtils;
import com.nzt.gdx.test.api.math.vectors.VTestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleUtilsTest {

    @Test
    public void getCenterTest() {
        Rectangle rect1 = new Rectangle(10, 20, 100, 50);
        Vector2 center1 = RectangleUtils.getCenter(rect1, new Vector2());
        VTestUtils.assertEquals(new Vector2(60, 45), center1);

        Rectangle rect2 = new Rectangle(100, 200, 500, 150);
        Vector2 center2 = RectangleUtils.getCenter(rect2, new Vector2());
        VTestUtils.assertEquals(new Vector2(100 + 250, 200 + 75), center2);
    }

    @Test
    public void getAsVerticesTest() {
        Rectangle rect1 = new Rectangle(10, 20, 100, 50);
        float[] asVertices = RectangleUtils.getAsVertices(rect1);
        assertEquals(10, asVertices[0]);
        assertEquals(20, asVertices[1]);
        assertEquals(110, asVertices[2]);
        assertEquals(20, asVertices[3]);
        assertEquals(110, asVertices[4]);
        assertEquals(70, asVertices[5]);
        assertEquals(10, asVertices[6]);
        assertEquals(70, asVertices[7]);
    }

    @Test
    public void getSegmentsTest() {
        Rectangle rect = new Rectangle(0, 0, 100, 50);
        Segment2D segment = new Segment2D();
        Segment2D horizontalTop = RectangleUtils.getHorizontalTop(rect, segment);
        assertEquals(horizontalTop, new Segment2D(0, 50, 100, 50));

        Segment2D horizontalBot = RectangleUtils.getHorizontalBot(rect, segment);
        assertEquals(horizontalBot, new Segment2D(0, 0, 100, 0));

        Segment2D verticalLeft = RectangleUtils.getVerticalLeft(rect, segment);
        assertEquals(verticalLeft, new Segment2D(0, 0, 0, 50));

        Segment2D verticalRight = RectangleUtils.getVerticalRight(rect, segment);
        assertEquals(verticalRight, new Segment2D(100, 0, 100, 50));
    }

    @Test
    public void testIsSquare() {
        boolean isSquare;
        Vector2 v = new Vector2();
        Rectangle rect = new Rectangle(10, 10, 5, 5);
        isSquare = RectangleUtils.isVertex(rect, v.set(10, 10));
        assertTrue(isSquare);

        isSquare = RectangleUtils.isVertex(rect, v.set(15, 10));
        assertTrue(isSquare);

        isSquare = RectangleUtils.isVertex(rect, v.set(10, 15));
        assertTrue(isSquare);

        isSquare = RectangleUtils.isVertex(rect, v.set(15, 15));
        assertTrue(isSquare);

        isSquare = RectangleUtils.isVertex(rect, v.set(11, 10));
        assertFalse(isSquare);
    }

    @Test
    public void getClosestVertexTest() {
        Rectangle rect = new Rectangle(0, 0, 100, 50);

        int vertexClosest = RectangleUtils.getClosestVertex(rect, -1, -1);
        assertTrue(vertexClosest == 1);

        vertexClosest = RectangleUtils.getClosestVertex(rect, 102, 1);
        assertTrue(vertexClosest == 2);

        vertexClosest = RectangleUtils.getClosestVertex(rect, 110, 55);
        assertTrue(vertexClosest == 3);

        vertexClosest = RectangleUtils.getClosestVertex(rect, -1, 55);
        assertTrue(vertexClosest == 4);
    }

    @Test
    public void getNearestPointTest() {
        Rectangle rect = new Rectangle(0, 0, 100, 50);
        Vector2 nearestPoint = new Vector2();

        RectangleUtils.getNearestPoint(rect, new Vector2(50, 150), nearestPoint);
        VTestUtils.assertEquals(new Vector2(50, 50), nearestPoint);

        RectangleUtils.getNearestPoint(rect, new Vector2(150, 25), nearestPoint);
        VTestUtils.assertEquals(new Vector2(100, 25), nearestPoint);

        RectangleUtils.getNearestPoint(rect, new Vector2(-100, 25), nearestPoint);
        VTestUtils.assertEquals(new Vector2(0, 25), nearestPoint);
    }
}
