package com.nzt.gdx.test.api.math.shape;

import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shapes.Segment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SegmentTest {

    private final static Vector2 tmp = new Vector2();
    @Test
    public void testSegment1() {
        Segment segment2D = new Segment(0, 0, 50, 0);

        Vector2 dir = segment2D.getDir(tmp);
        assertEquals(new Vector2(1, 0), dir);

        Vector2 middle = segment2D.getMiddle(tmp);
        assertEquals(new Vector2(25, 0), middle);

        float dst = segment2D.getDst();
        assertEquals(50f, dst, 0.1f);

        Vector2 normale = segment2D.getNormal(tmp);
        assertEquals(new Vector2(0, 1).epsilonEquals(normale), true);
    }
}
