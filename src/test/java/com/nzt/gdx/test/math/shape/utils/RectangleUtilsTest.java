package com.nzt.gdx.test.math.shape.utils;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shape.Segment2D;
import com.nzt.gdx.math.shape.utils.RectangleUtils;

import org.junit.Assert;
import org.junit.Test;

public class RectangleUtilsTest {
    @Test
    public void getCenterTest() {
        Rectangle rect = new Rectangle(0, 0, 100, 50);

        Vector2 center = RectangleUtils.getCenter(rect);
        Assert.assertEquals(new Vector2(50, 25), center);
    }

    @Test
    public void getSegmentsTest() {
        Rectangle rect = new Rectangle(0, 0, 100, 50);

        Segment2D horizontalTop = RectangleUtils.getHorizontalTop(rect);
        Assert.assertEquals(horizontalTop, new Segment2D(0, 50, 100, 50));

        Segment2D horizontalBot = RectangleUtils.getHorizontalBot(rect);
        Assert.assertEquals(horizontalBot, new Segment2D(0, 0, 100, 0));

        Segment2D verticalLeft = RectangleUtils.getVerticalLeft(rect);
        Assert.assertEquals(verticalLeft, new Segment2D(0, 0, 0, 50));

        Segment2D verticalRight = RectangleUtils.getVerticalRight(rect);
        Assert.assertEquals(verticalRight, new Segment2D(100, 0, 100, 50));
    }

    @Test
    public void getClosestSegmentIntersection() {
        Rectangle rect = new Rectangle(0, 0, 100, 50);
        Segment2D segment = new Segment2D(-10, 25, 200, 25);
        Vector2 closestSegmentIntersection = new Vector2();
        Segment2D segmentClosest = RectangleUtils.getClosestSegmentIntersection(segment, rect, closestSegmentIntersection);
        Assert.assertEquals(new Vector2(0, 25), closestSegmentIntersection);
    }
}
