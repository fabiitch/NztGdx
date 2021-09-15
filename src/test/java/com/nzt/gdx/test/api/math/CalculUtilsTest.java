package com.nzt.gdx.test.api.math;

import com.nzt.gdx.math.CalculUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculUtilsTest {

    @Test
    public void floorModTest() {
        Assertions.assertEquals(1, CalculUtils.floorMod(-1, 2));
        Assertions.assertEquals(0, CalculUtils.floorMod(-2, 2));

        Assertions.assertEquals(1, CalculUtils.floorMod(1, 2));
        Assertions.assertEquals(0, CalculUtils.floorMod(2, 2));
    }
}
