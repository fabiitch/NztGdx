package com.nzt.gdx.test.math.intersectors;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.intersectors.IntersectorSegmentRectangle;
import com.nzt.gdx.math.shape.nz.NzRectangle;
import com.nzt.gdx.math.shape.Segment2D;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntersectorSegmentRectangleTest {

    private Segment2D segment2D = new Segment2D(-10, 0, 20, 0);
    private Rectangle rect = new NzRectangle(0, 0, 10, 10);
    private Vector2 intersectionPoint = new Vector2(-100, -100);
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
        assertTouch(5,0);

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
        assertTouch(0,5);

        resetSegment(5, 5, -5, 0.2f);
        touch = IntersectorSegmentRectangle.instersectVerticalLeft(segment2D, rect, intersectionPoint);
        assertTrue(touch);

        resetSegment(5, 5, 0.1f, 0.2f);
        touch = IntersectorSegmentRectangle.instersectVerticalLeft(segment2D, rect, intersectionPoint);
        assertFalse(touch);
    }

    @Test
    public void closestFarthest1() {
        resetSegment(-10, 0, 20, 0);
        touch = IntersectorSegmentRectangle.intersectSegmentRectangleClosest(segment2D, rect, intersectionPoint);
        assertEquals(new Vector2(0, 0), intersectionPoint);
        assertTrue(touch);

        touch = IntersectorSegmentRectangle.intersectSegmentRectangleFarthest(segment2D, rect, intersectionPoint);
        assertEquals(new Vector2(10, 0), intersectionPoint);
        assertTrue(touch);
    }

    @Test
    public void closestFarthest2() {
        resetSegment(-5, 15, 15, -5);
        touch = IntersectorSegmentRectangle.intersectSegmentRectangleClosest(segment2D, rect, intersectionPoint);
        assertEquals(new Vector2(0, 10), intersectionPoint);
        assertTrue(touch);

        touch = IntersectorSegmentRectangle.intersectSegmentRectangleFarthest(segment2D, rect, intersectionPoint);
        assertEquals(new Vector2(10, 0), intersectionPoint);
        assertTrue(touch);
    }
}
