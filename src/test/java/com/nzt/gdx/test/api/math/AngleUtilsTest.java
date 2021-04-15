package com.nzt.gdx.test.api.math;

import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.AngleUtils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AngleUtilsTest {
    private static float DELTA_0 = 0f;
    private static float DELTA_01 = 0.1f;

    @Test
    public void testCoherence() {
        float dst1Signed = AngleUtils.distanceSigned(v(1, 0), v(0, 1));
        float dst1Abs = AngleUtils.distanceAbs(v(1, 0), v(0, 1));
        assertEquals(Math.abs(dst1Signed), dst1Abs, DELTA_0);

        float dst2Signed = AngleUtils.distanceSigned(v(1, 0), v(-1, 0));
        float dst2Abs = AngleUtils.distanceAbs(v(1, 0), v(-1, 0));
        assertEquals(Math.abs(dst2Signed), dst2Abs, DELTA_0);

        float dst3Signed = AngleUtils.distanceSigned(v(1, 0), v(1, -0.1f));
        float dst3Abs = AngleUtils.distanceAbs(v(1, 0), v(1, -0.1f));
        assertEquals(Math.abs(dst3Signed), dst3Abs, DELTA_0);
    }

    @Test
    public void distanceSignedTest() {
        float dst1 = AngleUtils.distanceSigned(50, 100);
        assertEquals(dst1, -50, DELTA_0);
        float dst2 = AngleUtils.distanceSigned(100, 50);
        assertEquals(dst2, 50, DELTA_0);
    }

    @Test
    public void distanceAbsTest() {
        float dst1 = AngleUtils.distanceAbs(v(1, 0), v(0, 1));
        assertEquals(90, dst1, DELTA_0);

        float dst2 = AngleUtils.distanceAbs(v(1, 0), v(-1, 0));
        assertEquals(180, dst2, DELTA_0);
    }

    private Vector2 v(float a, float b) {
        return new Vector2(a, b);
    }
}
