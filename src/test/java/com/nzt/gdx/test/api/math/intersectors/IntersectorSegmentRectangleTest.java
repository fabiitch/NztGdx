package com.nzt.gdx.test.api.math.intersectors;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.intersectors.IntersectorSegmentRectangle;
import com.nzt.gdx.math.shapes.Segment2D;
import com.nzt.gdx.math.shapes.utils.RectangleUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntersectorSegmentRectangleTest {

    private Segment2D segment2D = new Segment2D(-10, 0, 20, 0);
    private final Rectangle rect = new Rectangle(0, 0, 10, 10);
    private final Vector2 intersectionPoint = new Vector2(-100, -100);
    private boolean touch = false;

    private void resetSegment(float aX, float aY, float bX, float bY) {
        segment2D = new Segment2D(aX, aY, bX, bY);
        intersectionPoint.set(-100, -100);
        touch = false;
    }

    private void assertTouch(float xIntersect, float yIntersect) {
        assertTrue(touch);
        assertEquals(new Vector2(xIntersect, yIntersect), intersectionPoint);
    }


    @Test
    public void instersectHorizontalBot() {
        resetSegment(5, 5, 5, -5);
        touch = IntersectorSegmentRectangle.instersectHorizontalBot(segment2D, rect, intersectionPoint);
        assertTouch(5, 0);

        resetSegment(5, 5, -1, -1);
        touch = IntersectorSegmentRectangle.instersectHorizontalBot(segment2D, rect, intersectionPoint);
        assertTrue(touch);

        resetSegment(5, 5, 5, 1);
        touch = IntersectorSegmentRectangle.instersectHorizontalBot(segment2D, rect, intersectionPoint);
        assertFalse(touch);
    }

    @Test
    public void instersectHorizontalTop() {
        resetSegment(5, 5, 5, 15);
        touch = IntersectorSegmentRectangle.instersectHorizontalTop(segment2D, rect, intersectionPoint);
        assertTouch(5, 10);

        resetSegment(5, 5, 0, 12);
        touch = IntersectorSegmentRectangle.instersectHorizontalTop(segment2D, rect, intersectionPoint);
        assertTrue(touch);

        resetSegment(5, 5, 0, 9);
        touch = IntersectorSegmentRectangle.instersectHorizontalTop(segment2D, rect, intersectionPoint);
        assertFalse(touch);
    }

    @Test
    public void instersectVercticalRight() {
        resetSegment(5, 5, 15, 5);
        touch = IntersectorSegmentRectangle.instersectVercticalRight(segment2D, rect, intersectionPoint);
        assertTouch(10, 5);

        resetSegment(5, 5, 15, 0.2f);
        touch = IntersectorSegmentRectangle.instersectVercticalRight(segment2D, rect, intersectionPoint);
        assertTrue(touch);

        resetSegment(5, 5, 8, 0.2f);
        touch = IntersectorSegmentRectangle.instersectVercticalRight(segment2D, rect, intersectionPoint);
        assertFalse(touch);
    }

    @Test
    public void instersectVerticalLeft() {
        resetSegment(5, 5, -5, 5);
        touch = IntersectorSegmentRectangle.instersectVerticalLeft(segment2D, rect, intersectionPoint);
        assertTouch(0, 5);

        resetSegment(5, 5, -5, 0.2f);
        touch = IntersectorSegmentRectangle.instersectVerticalLeft(segment2D, rect, intersectionPoint);
        assertTrue(touch);

        resetSegment(5, 5, 0.1f, 0.2f);
        touch = IntersectorSegmentRectangle.instersectVerticalLeft(segment2D, rect, intersectionPoint);
        assertFalse(touch);
    }

    @Test
    public void closestFarthest1() {
        Segment2D rectSegmentIntersector = new Segment2D();
        resetSegment(-10, 0, 20, 0);

        touch = IntersectorSegmentRectangle.closest(segment2D, rect, intersectionPoint, rectSegmentIntersector);
        assertEquals(new Vector2(0, 0), intersectionPoint);
        assertEquals(RectangleUtils.getVerticalLeft(rect, new Segment2D()), rectSegmentIntersector);
        assertTrue(touch);

        touch = IntersectorSegmentRectangle.farthest(segment2D, rect, intersectionPoint, rectSegmentIntersector);
        assertEquals(new Vector2(10, 0), intersectionPoint);
        assertEquals(RectangleUtils.getVerticalRight(rect, new Segment2D()), rectSegmentIntersector);
        assertTrue(touch);
    }

    @Test
    public void closestFarthest2() {
        Segment2D rectSegmentIntersector = new Segment2D();
        resetSegment(-5, 15, 15, -5);

        touch = IntersectorSegmentRectangle.closest(segment2D, rect, intersectionPoint, rectSegmentIntersector);
        assertEquals(new Vector2(0, 10), intersectionPoint);
        assertEquals(RectangleUtils.getVerticalLeft(rect, new Segment2D()), rectSegmentIntersector);
        assertTrue(touch);

        touch = IntersectorSegmentRectangle.farthest(segment2D, rect, intersectionPoint,rectSegmentIntersector);
        assertEquals(new Vector2(10, 0), intersectionPoint);
        assertEquals(RectangleUtils.getHorizontalBot(rect, new Segment2D()), rectSegmentIntersector);
        assertTrue(touch);
    }

    @Test
    //test repris de l'ancienne classes
    public void getClosestSegmentIntersection() {
        Rectangle rect = new Rectangle(0, 0, 100, 50);
        Segment2D segment = new Segment2D(-10, 25, 200, 25);
        Vector2 closestSegmentIntersection = new Vector2();

        boolean touch = IntersectorSegmentRectangle.closest(segment, rect, closestSegmentIntersection);
        assertEquals(new Vector2(0, 25), closestSegmentIntersection);
        assertTrue(touch);
    }
}
