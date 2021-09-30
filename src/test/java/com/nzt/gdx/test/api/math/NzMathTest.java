package com.nzt.gdx.test.api.math;

import com.nzt.gdx.math.NzMath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NzMathTest {

    @Test
    public void floorModTest() {
        Assertions.assertEquals(1, NzMath.floorMod(-1, 2));
        Assertions.assertEquals(0, NzMath.floorMod(-2, 2));

        Assertions.assertEquals(1, NzMath.floorMod(1, 2));
        Assertions.assertEquals(0, NzMath.floorMod(2, 2));
    }


    @Test
    public void sameSign() {
        Assertions.assertTrue(NzMath.sameSign(55, 20));
        Assertions.assertTrue(NzMath.sameSign(1.5544554f, 20.545454f));
        Assertions.assertTrue(NzMath.sameSign(-25, -25));
        Assertions.assertTrue(NzMath.sameSign(-55.323232f, -8888.333f));

        Assertions.assertFalse(NzMath.sameSign(-50, 50));
        Assertions.assertFalse(NzMath.sameSign(50, -20));
        Assertions.assertFalse(NzMath.sameSign(50.12122f, -56.21112f));
        Assertions.assertFalse(NzMath.sameSign(-500.211212f, 25.988998f));

        //test 0
        Assertions.assertTrue(NzMath.sameSignWithZero(55, 0));
        Assertions.assertTrue(NzMath.sameSignWithZero(1.5544554f, 0));
        Assertions.assertTrue(NzMath.sameSignWithZero(-25, -0));
        Assertions.assertTrue(NzMath.sameSignWithZero(-55.323232f, 0));

        Assertions.assertTrue(NzMath.sameSignWithZero(-55.323232f, 0.1f, 0.5f));
    }
}
