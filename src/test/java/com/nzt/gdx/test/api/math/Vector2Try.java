package com.nzt.gdx.test.api.math;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * pour test vite fait  les methode de Vector2
 */
@Disabled
public class Vector2Try {
    private static final float DELTA_01 = 0.1f;

    private Vector2 v1;
    private Vector2 v2;

    /**
     * {@link com.nzt.gdx.test.trials.st.math.vectors.STV2Opposite}
     */
    @Test
    public void oppositeDirectionTest() {
        assertTrue(v(1, 0).hasOppositeDirection(v(-1, 0)));
        assertFalse(v(1, 0).hasOppositeDirection(v(0, 1)));
        assertTrue(v(1, 0).hasOppositeDirection(v(-1, 1)));
    }

    @Test
    public void epsilonEquals() {
        v1 = v(10, 0);
        v2 = v(10, 1);
        assertTrue(v1.epsilonEquals(v2, 2));
        assertFalse(v1.epsilonEquals(v2, 0.5f));

        v1 = v(10, 0);
        v2 = v(10, 3);
        assertFalse(v1.epsilonEquals(v2, 2));
    }

    @Test
    @Disabled
    public void epsilonEqualsOnNor() {
        v1 = v(10, 0).nor();
        v2 = v(10, 1).nor();
        assertTrue(v1.epsilonEquals(v2, 0.1f));

        v1 = v(10, 0).nor();
        v2 = v(-10, 0).nor();
        System.out.println(Math.abs(v2.x - v1.x));
        System.out.println(Math.abs(v2.y - v1.y));
        assertTrue(v1.epsilonEquals(v2, 2));
    }

    @Test
    @Disabled
    public void angleRecap() {
        printAngle(v(0, 0));
        printAngle(v(0, 1));
        printAngle(v(0, 2));

        printAngle(v(1, 1));
        printAngle(v(0.5f, 0.5f));
        printAngle(v(-1, -1));
        printAngle(v(-0.5f, -0.5f));

        printAngle(v(1, 0).setAngleDeg(350));
    }

    private void printAngle(Vector2 v) {
        System.out.println(v.toString() + " | " + v.angleDeg());
    }

    @Test
    public void interpolate() {
        v1 = v(10, 0);
        v2 = v(10, 10);

        v1 = v1.interpolate(v2, 0.5f, Interpolation.bounceIn);
        System.out.println(v1);
    }

    @Test
    @Disabled
    public void rotationTest() {
        Vector2 v1 = v(1.0f, 0.0f);
        Vector2 v2 = v(0.99276555f, 0.120069146f);
        System.out.println(v1.angleDeg());
        System.out.println(v2.angleDeg());
    }

    @Test
    public void angleBetweenTest() {
        Vector2 v1 = v(0, 1);
        Vector2 v2 = v(1, 0);
        assertEquals(90, v1.angleDeg(v2), DELTA_01);

        v1 = v(1, 0);
        v2 = v(0, 1);
        assertEquals(360 - 90, v1.angleDeg(v2), DELTA_01);
    }


    @Test
    public void testMultipleNor() {
        Vector2 v1 = v(0, 1);
        float min = Integer.MIN_VALUE;
        float max = Integer.MAX_VALUE;
        for (int i = 0; i < 100000; i++) {
            v1.set(MathUtils.random.nextFloat() * (max - min) + min, MathUtils.random.nextFloat() * (max - min) + min);
            v1.nor();
            assertEquals(1, v1.len2(), MathUtils.FLOAT_ROUNDING_ERROR);
        }
    }

    @Test
    public void testMultipleNor2() {
        Vector2 v1 = v(0, 1);
        Vector2 v2 = v(0, 1);
        float min = Integer.MIN_VALUE;
        float max = Integer.MAX_VALUE;

        for (int j = 0; j < 100; j++) {
            v1.set(MathUtils.random.nextFloat() * (max - min) + min, MathUtils.random.nextFloat() * (max - min) + min);
            v2.set(v1);
            long l1 = System.nanoTime();
            for (int i = 0; i < 10000000; i++) {
                v1.nor();
            }
            long t1 = System.nanoTime() - l1;
            long l2 = System.nanoTime();
            for (int i = 0; i < 10000000; i++) {
                norMe(v2);
            }
            long t2 = System.nanoTime() - l2;
            assertTrue(t2 < t1);
            System.out.println("t1= " + t1 + "   t2=" + t2);
            assertTrue(v1.epsilonEquals(v2));
        }
    }

    private void norMe(Vector2 v) {
        float len2 = v.len2();
        if (Math.abs(len2 - 1) > MathUtils.FLOAT_ROUNDING_ERROR) {
            float len = v.len();
            if (len != 0) {
                v.x /= len;
                v.y /= len;
            }
        }
    }

    private Vector2 v(float a, float b) {
        return new Vector2(a, b);
    }
}
