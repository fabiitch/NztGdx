package com.nzt.gdx.test.api.math;

import com.badlogic.gdx.math.MathUtils;
import com.nzt.gdx.math.AngleUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.nzt.gdx.math.AngleUtils.normaliseDeg;
import static com.nzt.gdx.test.api.math.AbstractMathTest.v;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AngleUtilsTest {
    private static final float DELTA_0 = 0f;
    private static final float DELTA_01 = 0.1f;

    @Test
    public void testCoherence() {
        float dst1Signed = AngleUtils.distanceSigned(v(1, 0), v(0, 1));
        float dst1Abs = AngleUtils.distanceAbs(v(1, 0), v(0, 1));
        Assertions.assertEquals(Math.abs(dst1Signed), dst1Abs, DELTA_0);

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

    @Test
    public void normaliseAngleDegTest() {
        assertEquals(0, normaliseDeg(0), DELTA_01);
        assertEquals(50, normaliseDeg(50), DELTA_01);
        assertEquals(0, normaliseDeg(360), DELTA_01);
        assertEquals(5, normaliseDeg(365), DELTA_01);
        assertEquals(0, normaliseDeg(720), DELTA_01);

        assertEquals(355, normaliseDeg(-5), DELTA_01);
        assertEquals(180, normaliseDeg(-180), DELTA_01);
        assertEquals(0, normaliseDeg(-720), DELTA_01);
    }


    @Test
    public void normaliseAngleRad02PiTest() {
        assertEquals(0, AngleUtils.normaliseRad02Pi(0), DELTA_01);
        assertEquals(MathUtils.PI, AngleUtils.normaliseRad02Pi(MathUtils.PI), DELTA_01);
        assertEquals(MathUtils.PI, AngleUtils.normaliseRad02Pi(-MathUtils.PI), DELTA_01);
        assertEquals(0, AngleUtils.normaliseRad02Pi(-MathUtils.PI2), DELTA_01);

        assertEquals(MathUtils.PI, AngleUtils.normaliseRad02Pi(MathUtils.PI * 3), DELTA_01);
        assertEquals(0, AngleUtils.normaliseRad02Pi(MathUtils.PI * 4), DELTA_01);
    }

    @Test
    public void normaliseAngleRad2PiTest() {
        assertEquals(0, AngleUtils.normaliseRadPiNPi(0), DELTA_01);
        assertEquals(MathUtils.PI, AngleUtils.normaliseRadPiNPi(MathUtils.PI), DELTA_01);
        assertEquals(-MathUtils.PI, AngleUtils.normaliseRadPiNPi(-MathUtils.PI), DELTA_01);
        assertEquals(0, AngleUtils.normaliseRadPiNPi(-MathUtils.PI2), DELTA_01);

        assertEquals(MathUtils.PI, AngleUtils.normaliseRadPiNPi(MathUtils.PI * 3), DELTA_01);
        assertEquals(0, AngleUtils.normaliseRadPiNPi(MathUtils.PI * 4), DELTA_01);
    }

}
