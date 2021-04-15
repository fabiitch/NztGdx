package com.nzt.gdx.test.api.math.shape.utils;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shape.Segment2D;
import com.nzt.gdx.math.shape.utils.RectangleUtils;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RectangleUtilsTest {

    @Test
    public void getSegmentsTest() {
        Rectangle rect = new Rectangle(0, 0, 100, 50);
        Segment2D segment = new Segment2D();
        Segment2D horizontalTop = RectangleUtils.getHorizontalTop(rect, segment);
        Assert.assertEquals(horizontalTop, new Segment2D(0, 50, 100, 50));

        Segment2D horizontalBot = RectangleUtils.getHorizontalBot(rect, segment);
        Assert.assertEquals(horizontalBot, new Segment2D(0, 0, 100, 0));

        Segment2D verticalLeft = RectangleUtils.getVerticalLeft(rect, segment);
        Assert.assertEquals(verticalLeft, new Segment2D(0, 0, 0, 50));

        Segment2D verticalRight = RectangleUtils.getVerticalRight(rect, segment);
        Assert.assertEquals(verticalRight, new Segment2D(100, 0, 100, 50));
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

}
