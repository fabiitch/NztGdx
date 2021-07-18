package com.nzt.gdx.test.api.math.shape.utils;

import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shapes.Segment2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Segment2DTest {

    @Test
    public void testSegment1() {
        Segment2D segment2D = new Segment2D(0, 0, 50, 0);

        Vector2 dir = segment2D.getDir();
        assertEquals(new Vector2(1, 0), dir);

        Vector2 middle = segment2D.getMiddle();
        assertEquals(new Vector2(25, 0), middle);

        float dst = segment2D.getDst();
        assertEquals(50f, dst,0.1f);

        Vector2 normale = segment2D.getNormale();
        assertEquals(new Vector2(0, 1).epsilonEquals(normale), true);
    }
}
