package com.nzt.gdx.math;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;

/*
 * pour test vite fait  les methode de Vector2
 */
public class Vector2Try {

    private Vector2 v1;
    private Vector2 v2;

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
    public void angleRecap() {
        printAngle(v(0, 0));
        printAngle(v(0, 1));
        printAngle(v(0, 2));

        printAngle(v(1, 1));
        printAngle(v(0.5f, 0.5f));
        printAngle(v(-1, -1));
        printAngle(v(-0.5f, -0.5f));

        printAngle(v(1, 0).setAngle(350));
    }

    private void printAngle(Vector2 v) {
        System.out.println(v.toString() + " | " + v.angle());
    }

    @Test
    public void interpolate() {
        v1 = v(10, 0);
        v2 = v(10, 10);

        v1 = v1.interpolate(v2, 0.5f, Interpolation.bounceIn);
        System.out.println(v1);
    }

    @Test
    public void rotationTest() {
        v1 = v(1, 0);
        System.out.println("before : " + v1);
        v1 = v1.rotateDeg(90).nor();
        System.out.println("after : " + v1.nor());
    }

    private Vector2 v(float a, float b) {
        return new Vector2(a, b);
    }
}
