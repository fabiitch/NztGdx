package com.nzt.gdx.test.api.math.shape;

import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shapes.Segment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SegmentTest {

    private final static Vector2 tmp = new Vector2();

    @Test
    public void testSegment1() {
        Segment segment = new Segment(0, 0, 50, 0);

        Vector2 dir = segment.getDir(tmp);
        assertEquals(new Vector2(1, 0), dir);

        Vector2 middle = segment.getMiddle(tmp);
        assertEquals(new Vector2(25, 0), middle);

        float dst = segment.dst();
        assertEquals(50f, dst, 0.1f);

        Vector2 normale = segment.getNormal(tmp);
        assertEquals(new Vector2(0, 1).epsilonEquals(normale), true);
    }

    @Test
    public void containsTest() {
        Segment segment = new Segment(0, 0, 50, 0);

        Assertions.assertTrue(segment.contains(25, 0));
        Assertions.assertTrue(segment.contains(new Vector2(25, 0)));
    }

    @Test
    public void dstToPointTest() {
        Segment segment = new Segment(0, 0, 50, 0);

        float dtsTo = segment.dst(new Vector2(25, 25));
        Assertions.assertEquals(25, dtsTo);
    }

    @Test
    public void equalsPointTest() {
        Segment segA = new Segment(0, 0, 50, 0);
        Segment segB = new Segment(50, 0, 0, 0);

        assertTrue(segA.equalsPoints(segB));

        segA = new Segment(0, 0, 50, 0);
        segB = new Segment(0, 0, 50, 0);
        assertTrue(segA.equalsPoints(segB));

        assertTrue(segA.equalsPoints(segA));
    }
}
