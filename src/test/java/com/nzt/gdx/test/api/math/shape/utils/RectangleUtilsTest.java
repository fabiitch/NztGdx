package com.nzt.gdx.test.api.math.shape.utils;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shapes.Segment;
import com.nzt.gdx.math.shapes.utils.RectangleUtils;
import com.nzt.gdx.test.api.math.vectors.VTestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleUtilsTest {

    private final static float DELTA = MathUtils.FLOAT_ROUNDING_ERROR;

    @Test
    public void getVertexTest() {
        Rectangle rect = new Rectangle(10, 20, 100, 50);
        Vector2 vertexPos = new Vector2();
        VTestUtils.assertEquals(10, 20, RectangleUtils.getA(rect, vertexPos));
        VTestUtils.assertEquals(110, 20, RectangleUtils.getB(rect, vertexPos));
        VTestUtils.assertEquals(110, 70, RectangleUtils.getC(rect, vertexPos));
        VTestUtils.assertEquals(10, 70, RectangleUtils.getD(rect, vertexPos));

        VTestUtils.assertEquals(10, 20, RectangleUtils.getVertex(rect, 0, vertexPos));
        VTestUtils.assertEquals(110, 20, RectangleUtils.getVertex(rect, 1, vertexPos));
        VTestUtils.assertEquals(110, 70, RectangleUtils.getVertex(rect, 2, vertexPos));
        VTestUtils.assertEquals(10, 70, RectangleUtils.getVertex(rect, 3, vertexPos));
    }

    @Test
    public void getEdgeTest() {
        Rectangle rect = new Rectangle(10, 20, 100, 50);
        Segment tmp1 = new Segment();
        Segment tmp2 = new Segment();
        Assertions.assertTrue(RectangleUtils.getAB(rect, tmp1).equalsPoints(tmp2.set(10, 20, 110, 20)));
        Assertions.assertTrue(RectangleUtils.getBC(rect, tmp1).equalsPoints(tmp2.set(110, 20, 110, 70)));
        Assertions.assertTrue(RectangleUtils.getCD(rect, tmp1).equalsPoints(tmp2.set(110, 70, 10, 70)));
        Assertions.assertTrue(RectangleUtils.getAD(rect, tmp1).equalsPoints(tmp2.set(10, 20, 10, 70)));
    }

    @Test
    public void getCenterTest() {
        Rectangle rect1 = new Rectangle(10, 20, 100, 50);
        Vector2 center1 = RectangleUtils.getCenter(rect1, new Vector2());
        VTestUtils.assertEquals(60, 45, center1);

        Rectangle rect2 = new Rectangle(100, 200, 500, 150);
        Vector2 center2 = RectangleUtils.getCenter(rect2, new Vector2());
        VTestUtils.assertEquals(100 + 250, 200 + 75, center2);
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
        Segment segment = new Segment();
        Segment horizontalTop = RectangleUtils.getHorizontalTop(rect, segment);
        assertEquals(horizontalTop, new Segment(0, 50, 100, 50));

        Segment horizontalBot = RectangleUtils.getHorizontalBot(rect, segment);
        assertEquals(horizontalBot, new Segment(0, 0, 100, 0));

        Segment verticalLeft = RectangleUtils.getVerticalLeft(rect, segment);
        assertEquals(verticalLeft, new Segment(0, 0, 0, 50));

        Segment verticalRight = RectangleUtils.getVerticalRight(rect, segment);
        assertEquals(verticalRight, new Segment(100, 0, 100, 50));
    }

    @Test
    public void testIsVertex() {
        int vertexNum;
        Vector2 v = new Vector2();
        Rectangle rect = new Rectangle(10, 10, 5, 5);
        vertexNum = RectangleUtils.isVertex(rect, v.set(10, 10));
        assertEquals(0, vertexNum);

        vertexNum = RectangleUtils.isVertex(rect, v.set(15, 10));
        assertEquals(1, vertexNum);

        vertexNum = RectangleUtils.isVertex(rect, v.set(15, 15));
        assertEquals(2, vertexNum);

        vertexNum = RectangleUtils.isVertex(rect, v.set(10, 15));
        assertEquals(3, vertexNum);

        vertexNum = RectangleUtils.isVertex(rect, v.set(11, 10));
        assertEquals(-1, vertexNum);
    }

    @Test
    public void getClosestVertexTest() {
        Rectangle rect = new Rectangle(0, 0, 100, 50);
        Vector2 closestVertex = new Vector2();

        int vertexClosest = RectangleUtils.getNumClosestVertex(rect, -1, -1);
        RectangleUtils.getNumClosestVertex(rect, -1, -1, closestVertex);
        assertTrue(vertexClosest == 0);

        vertexClosest = RectangleUtils.getNumClosestVertex(rect, 102, 1);
        assertTrue(vertexClosest == 1);

        vertexClosest = RectangleUtils.getNumClosestVertex(rect, 110, 55);
        assertTrue(vertexClosest == 2);

        vertexClosest = RectangleUtils.getNumClosestVertex(rect, -1, 55);
        assertTrue(vertexClosest == 3);
    }

    @Test
    public void getClosestPointTest() {
        Rectangle rect = new Rectangle(0, 0, 100, 50);
        Vector2 closestPoint = new Vector2();

        RectangleUtils.closestPoint(rect, new Vector2(50, 150), closestPoint);
        VTestUtils.assertEquals(new Vector2(50, 50), closestPoint);

        RectangleUtils.closestPoint(rect, new Vector2(150, 25), closestPoint);
        VTestUtils.assertEquals(new Vector2(100, 25), closestPoint);

        RectangleUtils.closestPoint(rect, new Vector2(-100, 25), closestPoint);
        VTestUtils.assertEquals(new Vector2(0, 25), closestPoint);
    }

    @Test
    public void getClosestSegmentTest() {
        Rectangle rect = new Rectangle(0, 0, 100, 50);
        Segment tmp = new Segment();
        Segment closestSegment = new Segment();

        RectangleUtils.closestSegment(rect, new Vector2(50, 150), closestSegment);
        Assertions.assertTrue(RectangleUtils.getHorizontalTop(rect, tmp).equalsPoints(closestSegment));

        RectangleUtils.closestSegment(rect, new Vector2(50, -10), closestSegment);
        Assertions.assertTrue(RectangleUtils.getHorizontalBot(rect, tmp).equalsPoints(closestSegment));

        RectangleUtils.closestSegment(rect, new Vector2(-15, 25), closestSegment);
        Assertions.assertTrue(RectangleUtils.getVerticalLeft(rect, tmp).equalsPoints(closestSegment));

        RectangleUtils.closestSegment(rect, new Vector2(300, 25), closestSegment);
        Assertions.assertTrue(RectangleUtils.getVerticalRight(rect, tmp).equalsPoints(closestSegment));
    }

    @Test
    public void getDiagDst() {
        Rectangle rect = new Rectangle(0, 0, 10, 20);
        float diagDst = RectangleUtils.getDiagDst(rect);

        Assertions.assertEquals(Math.sqrt(500), diagDst, 1);
    }

    @Test
    public void circleInsideTest() {
        Rectangle rect = new Rectangle(50, 50, 10, 20);
        Circle circleInside = RectangleUtils.getCircleInside(rect);

        Assertions.assertEquals(55, circleInside.x, DELTA);
        Assertions.assertEquals(60, circleInside.y, DELTA);
        Assertions.assertEquals(5, circleInside.radius, DELTA);
    }


    @Test
    public void testOverlaps() {
        Rectangle a = new Rectangle(0, 0, 50, 50);
        Rectangle b = new Rectangle(50, 0, 50, 50);
        Assertions.assertFalse(a.overlaps(b));
        Assertions.assertFalse(b.overlaps(a));
        Assertions.assertTrue(RectangleUtils.overlapsStick(a, b));
        Assertions.assertTrue(RectangleUtils.overlapsStick(b, a));

        b = new Rectangle(-50, 0, 50, 50);
        Assertions.assertTrue(RectangleUtils.overlapsStick(a, b));
        Assertions.assertTrue(RectangleUtils.overlapsStick(b, a));

        b = new Rectangle(0, 50, 50, 50);
        Assertions.assertTrue(RectangleUtils.overlapsStick(a, b));
        Assertions.assertTrue(RectangleUtils.overlapsStick(b, a));

        b = new Rectangle(0, -50, 50, 50);
        Assertions.assertTrue(RectangleUtils.overlapsStick(a, b));
        Assertions.assertTrue(RectangleUtils.overlapsStick(b, a));

        b = new Rectangle(51, 0, 50, 50);
        Assertions.assertFalse(RectangleUtils.overlapsStick(a, b));
        Assertions.assertFalse(RectangleUtils.overlapsStick(b, a));

        b = new Rectangle(-51, 0, 50, 50);
        Assertions.assertFalse(RectangleUtils.overlapsStick(a, b));
        Assertions.assertFalse(RectangleUtils.overlapsStick(b, a));

        b = new Rectangle(0, 51, 50, 50);
        Assertions.assertFalse(RectangleUtils.overlapsStick(a, b));
        Assertions.assertFalse(RectangleUtils.overlapsStick(b, a));

        b = new Rectangle(0, -51, 50, 50);
        Assertions.assertFalse(RectangleUtils.overlapsStick(a, b));
        Assertions.assertFalse(RectangleUtils.overlapsStick(b, a));
    }

    @Test
    public void getEdgeWithAngleTest() {
        Rectangle rect = new Rectangle(0, 0, 20, 10);  //center (10,5)
        Segment edge = new Segment();

        RectangleUtils.getEdgeWithAngle(rect, 0, edge);
        assertEquals(new Segment(20, 0, 20, 10), edge);
        //TODO reprendre ici

    }

    @Test
    public void posOnEdgeAngleTest() {
        final float TOLERANCE = 0.1f;
        Rectangle rect = new Rectangle(0, 0, 20, 10);  //center (10,5)
        Vector2 point = new Vector2();

//        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * 0, point);
//        VTestUtils.assertEquals(20, 5, point, TOLERANCE);
//
//        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * 90, point);
//        VTestUtils.assertEquals(10, 10, point, TOLERANCE);
//
//        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * 180, point);
//        VTestUtils.assertEquals(0, 5, point, TOLERANCE);
//
//        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * 270, point);
//        VTestUtils.assertEquals(10, 0, point, TOLERANCE);
//
//        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * 360, point);
//        VTestUtils.assertEquals(20, 5, point, TOLERANCE);
//
//        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * 540, point);
//        VTestUtils.assertEquals(0, 5, point, TOLERANCE);

        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * 45, point);
        VTestUtils.assertEquals(20, 10, point, TOLERANCE);

        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * 135, point);
        VTestUtils.assertEquals(-20, 10, point, TOLERANCE);

        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * 225, point);
        VTestUtils.assertEquals(-20, 10, point, TOLERANCE);

        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * 315, point);
        VTestUtils.assertEquals(-20, 10, point, TOLERANCE);


        //Negatif
//        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * -0, point);
//        VTestUtils.assertEquals(20, 5, point, TOLERANCE);
//
//        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * -90, point);
//        VTestUtils.assertEquals(10, 0, point, TOLERANCE);
//
//        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * -180, point);
//        VTestUtils.assertEquals(0, 5, point, TOLERANCE);
//
//        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * -270, point);
//        VTestUtils.assertEquals(10, 10, point, TOLERANCE);
//
//        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * -360, point);
//        VTestUtils.assertEquals(20, 5, point, TOLERANCE);
    }
}
