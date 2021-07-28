package com.nzt.gdx.test.api.math.shape.utils;

import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shapes.Segment;
import com.nzt.gdx.math.shapes.utils.SegmentUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SegmentUtilsTest {
    //http://www.ambrsoft.com/MathCalc/Line/TwoLinesIntersection/TwoLinesIntersection.htm
    @Test
    public void getSegmentIntersectionTest1() {
        Segment s1 = s(0, 0, 100, 0);
        Segment s2 = s(50, 50, 50, -50);
        Vector2 segmentIntersection = SegmentUtils.getSegmentIntersection(s1, s2);
        assertEquals(new Vector2(50, 0), segmentIntersection);
    }

    @Test
    public void getSegmentIntersectionTest2() {
        Segment s1 = s(20, -20, 150, 200);
        Segment s2 = s(10, 150, 250, 10);
        Vector2 segmentIntersection = SegmentUtils.getSegmentIntersection(s1, s2);
        assertEquals(new Vector2(92.14f, 102.08f), segmentIntersection);
    }

    @Test
    public void getAngleReflexionTest1() {
        Segment s1 = s(50, 0, 50, 50);
        Vector2 direction = v(1, 0);
        float angleReflexion = SegmentUtils.getAngleReflexion(s1, direction);
        Assertions.assertEquals(360, angleReflexion, 0.1f);
    }

    @Test
    public void getAngleReflexionTest2() {
        Segment s1 = s(0, 0, 50, 0);
        Vector2 direction = v(1, 1).nor();
        float angleReflexion = SegmentUtils.getAngleReflexion(s1, direction);
        Assertions.assertEquals(135f, angleReflexion, 0.1f);
    }

    private Segment s(float aX, float aY, float bX, float bY) {
        return new Segment(aX, aY, bX, bY);
    }

    private Vector2 v(float a, float b) {
        return new Vector2(a, b);
    }

    private void assertEquals(Vector2 v1, Vector2 v2) {
        assertTrue(v1.sub(v2).len() < 0.1f);
    }

}
