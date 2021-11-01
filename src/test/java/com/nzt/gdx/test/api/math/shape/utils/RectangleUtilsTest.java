package com.nzt.gdx.test.api.math.shape.utils;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shapes.Segment;
import com.nzt.gdx.math.shapes.utils.RectangleUtils;
import com.nzt.gdx.test.api.math.AbstractMathTest;
import com.nzt.gdx.test.api.math.vectors.VTestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RectangleUtilsTest extends AbstractMathTest {

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
    public void getClosestEdgeFromPointTest() {
        Rectangle rect = new Rectangle(0, 0, 100, 50);
        Segment tmp = new Segment();
        Segment closestSegment = new Segment();

        RectangleUtils.closestEdge(rect, new Vector2(50, 150), closestSegment);
        Assertions.assertTrue(RectangleUtils.getHorizontalTop(rect, tmp).equalsPoints(closestSegment));

        RectangleUtils.closestEdge(rect, new Vector2(50, -10), closestSegment);
        Assertions.assertTrue(RectangleUtils.getHorizontalBot(rect, tmp).equalsPoints(closestSegment));

        RectangleUtils.closestEdge(rect, new Vector2(-15, 25), closestSegment);
        Assertions.assertTrue(RectangleUtils.getVerticalLeft(rect, tmp).equalsPoints(closestSegment));

        RectangleUtils.closestEdge(rect, new Vector2(300, 25), closestSegment);
        Assertions.assertTrue(RectangleUtils.getVerticalRight(rect, tmp).equalsPoints(closestSegment));

        //on rect
        RectangleUtils.closestEdge(rect, new Vector2(50, 0), closestSegment);
        Assertions.assertTrue(RectangleUtils.getHorizontalBot(rect, tmp).equalsPoints(closestSegment));
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
        assertEquals(RectangleUtils.getVerticalRight(rect, new Segment()), edge);

        RectangleUtils.getEdgeWithAngle(rect, 15, edge);
        assertEquals(RectangleUtils.getVerticalRight(rect, new Segment()), edge);

        RectangleUtils.getEdgeWithAngle(rect, 44, edge);
        assertEquals(RectangleUtils.getVerticalRight(rect, new Segment()), edge);

        RectangleUtils.getEdgeWithAngle(rect, 45, edge);
        assertEquals(RectangleUtils.getHorizontalTop(rect, new Segment()), edge);

        RectangleUtils.getEdgeWithAngle(rect, 50, edge);
        assertEquals(RectangleUtils.getHorizontalTop(rect, new Segment()), edge);

        RectangleUtils.getEdgeWithAngle(rect, 90, edge);
        assertEquals(RectangleUtils.getHorizontalTop(rect, new Segment()), edge);

        RectangleUtils.getEdgeWithAngle(rect, 134, edge);
        assertEquals(RectangleUtils.getHorizontalTop(rect, new Segment()), edge);

        RectangleUtils.getEdgeWithAngle(rect, 135, edge);
        assertEquals(RectangleUtils.getVerticalLeft(rect, new Segment()), edge);

        RectangleUtils.getEdgeWithAngle(rect, 150, edge);
        assertEquals(RectangleUtils.getVerticalLeft(rect, new Segment()), edge);

        RectangleUtils.getEdgeWithAngle(rect, 224, edge);
        assertEquals(RectangleUtils.getVerticalLeft(rect, new Segment()), edge);

        RectangleUtils.getEdgeWithAngle(rect, 225, edge);
        assertEquals(RectangleUtils.getHorizontalBot(rect, new Segment()), edge);

        RectangleUtils.getEdgeWithAngle(rect, 300, edge);
        assertEquals(RectangleUtils.getHorizontalBot(rect, new Segment()), edge);

        RectangleUtils.getEdgeWithAngle(rect, 314, edge);
        assertEquals(RectangleUtils.getHorizontalBot(rect, new Segment()), edge);

        RectangleUtils.getEdgeWithAngle(rect, 360, edge);
        assertEquals(RectangleUtils.getVerticalRight(rect, new Segment()), edge);

        RectangleUtils.getEdgeWithAngle(rect, 314 + 360, edge);
        assertEquals(RectangleUtils.getHorizontalBot(rect, new Segment()), edge);

        RectangleUtils.getEdgeWithAngle(rect, -360, edge);
        assertEquals(RectangleUtils.getVerticalRight(rect, new Segment()), edge);

        RectangleUtils.getEdgeWithAngle(rect, 135 - 720, edge);
        assertEquals(RectangleUtils.getVerticalLeft(rect, new Segment()), edge);

        RectangleUtils.getEdgeWithAngle(rect, 314 + -720, edge);
        assertEquals(RectangleUtils.getHorizontalBot(rect, new Segment()), edge);
    }

    @Test
    public void growRectTest() {
        Rectangle rect = r(100, 100);

        RectangleUtils.growRect(rect, 50, 50); //contains
        Assertions.assertEquals(r(0, 0, 100, 100), rect);

        RectangleUtils.growRect(rect, -10, 50); //grow -x
        Assertions.assertEquals(r(-10, 0, 110, 100), rect);

        RectangleUtils.growRect(rect, -5, 50);//contains
        Assertions.assertEquals(r(-10, 0, 110, 100), rect);

        RectangleUtils.growRect(rect, 0, -10); //grow -y
        Assertions.assertEquals(r(-10, -10, 110, 110), rect);

        RectangleUtils.growRect(rect, 0, -5); //contains
        Assertions.assertEquals(r(-10, -10, 110, 110), rect);

        RectangleUtils.growRect(rect, 150, -10); //grow +x
        Assertions.assertEquals(r(-10, -10, 160, 110), rect);

        RectangleUtils.growRect(rect, 100, -10);//contains
        Assertions.assertEquals(r(-10, -10, 160, 110), rect);

        RectangleUtils.growRect(rect, 100, 150); //grow +y
        Assertions.assertEquals(r(-10, -10, 160, 160), rect);
    }

    /**
     * 0 = outside
     * 5 = center
     * ________
     * | 4 | 3 |
     * |_1_|_2_|
     */
    @Test
    public void getRegionInsideTest() {
        Rectangle rect = r(200, 100);
        Assertions.assertEquals(0, RectangleUtils.getRegionInside(rect, v(-10, -10)));
        Assertions.assertEquals(1, RectangleUtils.getRegionInside(rect, v(50, 25)));
        Assertions.assertEquals(2, RectangleUtils.getRegionInside(rect, v(150, 25)));
        Assertions.assertEquals(3, RectangleUtils.getRegionInside(rect, v(150, 75)));
        Assertions.assertEquals(4, RectangleUtils.getRegionInside(rect, v(50, 75)));
        Assertions.assertEquals(5, RectangleUtils.getRegionInside(rect, v(100, 50)));
    }

    /**
     * Renvoi la position relative au rect
     * 0 = inside
     * 4 |  3 | 2
     * __|____|__
     * 5 |  0 | 1
     * __|____|___
     * 6 |  7 | 8
     */
    @Test
    public void getRegionOutsideTest() {
        Rectangle rect = r(200, 100);
        float lowX = -50, hightX = 250, inX = 100;
        float lowY = -25, hightY = 125, inY = 50;
        Assertions.assertEquals(0, RectangleUtils.getRegionOutside(rect, v(inX, inY)));
        Assertions.assertEquals(1, RectangleUtils.getRegionOutside(rect, v(hightX, inY)));
        Assertions.assertEquals(2, RectangleUtils.getRegionOutside(rect, v(hightX, hightY)));
        Assertions.assertEquals(3, RectangleUtils.getRegionOutside(rect, v(inX, hightY)));
        Assertions.assertEquals(4, RectangleUtils.getRegionOutside(rect, v(lowX, hightY)));
        Assertions.assertEquals(5, RectangleUtils.getRegionOutside(rect, v(lowX, inY)));
        Assertions.assertEquals(6, RectangleUtils.getRegionOutside(rect, v(lowX, lowY)));
        Assertions.assertEquals(7, RectangleUtils.getRegionOutside(rect, v(inX, lowY)));
        Assertions.assertEquals(8, RectangleUtils.getRegionOutside(rect, v(hightX, lowY)));

        //vertex
        Assertions.assertEquals(0, RectangleUtils.getRegionOutside(rect, v(0, 0)));
        Assertions.assertEquals(0, RectangleUtils.getRegionOutside(rect, v(rect.width, rect.height)));
        Assertions.assertEquals(0, RectangleUtils.getRegionOutside(rect, v(0, rect.height)));
        Assertions.assertEquals(0, RectangleUtils.getRegionOutside(rect, v(rect.width, 0)));
    }

    @Test
    public void getRegionTest() {
        Rectangle rect = r(200, 100);
        float lowX = -50, hightX = 250, inX = 100;
        float lowY = -25, hightY = 125, inY = 50;
        Assertions.assertEquals(1, RectangleUtils.getRegion(rect, v(hightX, inY)));
        Assertions.assertEquals(2, RectangleUtils.getRegion(rect, v(hightX, hightY)));
        Assertions.assertEquals(3, RectangleUtils.getRegion(rect, v(inX, hightY)));
        Assertions.assertEquals(4, RectangleUtils.getRegion(rect, v(lowX, hightY)));
        Assertions.assertEquals(5, RectangleUtils.getRegion(rect, v(lowX, inY)));
        Assertions.assertEquals(6, RectangleUtils.getRegion(rect, v(lowX, lowY)));
        Assertions.assertEquals(7, RectangleUtils.getRegion(rect, v(inX, lowY)));
        Assertions.assertEquals(8, RectangleUtils.getRegion(rect, v(hightX, lowY)));

        Assertions.assertEquals(9, RectangleUtils.getRegion(rect, v(50, 25)));
        Assertions.assertEquals(10, RectangleUtils.getRegion(rect, v(150, 25)));
        Assertions.assertEquals(11, RectangleUtils.getRegion(rect, v(150, 75)));
        Assertions.assertEquals(12, RectangleUtils.getRegion(rect, v(50, 75)));
        Assertions.assertEquals(13, RectangleUtils.getRegion(rect, v(100, 50)));
    }

    //TODO marche pas
//    @Test
//    public void posOnEdgeAngleTest() {
//        final float TOLERANCE = 0.1f;
//        Rectangle rect = new Rectangle(0, 0, 20, 10);  //center (10,5)
//        Vector2 point = new Vector2();
//
////        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * 0, point);
////        VTestUtils.assertEquals(20, 5, point, TOLERANCE);
////
////        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * 90, point);
////        VTestUtils.assertEquals(10, 10, point, TOLERANCE);
////
////        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * 180, point);
////        VTestUtils.assertEquals(0, 5, point, TOLERANCE);
////
////        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * 270, point);
////        VTestUtils.assertEquals(10, 0, point, TOLERANCE);
////
////        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * 360, point);
////        VTestUtils.assertEquals(20, 5, point, TOLERANCE);
////
////        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * 540, point);
////        VTestUtils.assertEquals(0, 5, point, TOLERANCE);
//
//        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * 45, point);
//        VTestUtils.assertEquals(20, 10, point, TOLERANCE);
//
//        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * 135, point);
//        VTestUtils.assertEquals(-20, 10, point, TOLERANCE);
//
//        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * 225, point);
//        VTestUtils.assertEquals(-20, 10, point, TOLERANCE);
//
//        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * 315, point);
//        VTestUtils.assertEquals(-20, 10, point, TOLERANCE);
//
//
//        //Negatif
////        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * -0, point);
////        VTestUtils.assertEquals(20, 5, point, TOLERANCE);
////
////        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * -90, point);
////        VTestUtils.assertEquals(10, 0, point, TOLERANCE);
////
////        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * -180, point);
////        VTestUtils.assertEquals(0, 5, point, TOLERANCE);
////
////        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * -270, point);
////        VTestUtils.assertEquals(10, 10, point, TOLERANCE);
////
////        RectangleUtils.posOnEdgeAngle(rect, MathUtils.degreesToRadians * -360, point);
////        VTestUtils.assertEquals(20, 5, point, TOLERANCE);
//    }


}
