package com.nzt.gdx.test.api.math;


import org.junit.jupiter.api.Test;

import static com.nzt.gdx.math.NzMath.*;
import static org.junit.jupiter.api.Assertions.*;

public class NzMathTest {

    @Test
    public void floorModTest() {
        assertEquals(1, floorMod(-1, 2));
        assertEquals(0, floorMod(-2, 2));

        assertEquals(1, floorMod(1, 2));
        assertEquals(0, floorMod(2, 2));
    }


    @Test
    public void sameSignTest() {
        assertTrue(sameSign(55, 20));
        assertTrue(sameSign(1.5544554f, 20.545454f));
        assertTrue(sameSign(-25, -25));
        assertTrue(sameSign(-55.323232f, -8888.333f));

        assertFalse(sameSign(-50, 50));
        assertFalse(sameSign(50, -20));
        assertFalse(sameSign(50.12122f, -56.21112f));
        assertFalse(sameSign(-500.211212f, 25.988998f));

        //test 0
        assertTrue(sameSignWithZero(55, 0));
        assertTrue(sameSignWithZero(1.5544554f, 0));
        assertTrue(sameSignWithZero(-25, -0));
        assertTrue(sameSignWithZero(-55.323232f, 0));

        assertTrue(sameSignWithZero(-55.323232f, 0.1f, 0.5f));
    }
}
