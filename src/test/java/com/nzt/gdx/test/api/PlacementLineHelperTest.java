package com.nzt.gdx.test.api;

import com.nzt.gdx.PlacementsLine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PlacementLineHelperTest {

    @Test
    public void middlePos() {
        float[] posMiddleAll = PlacementsLine.posMiddle(4, 9, 1);
        assertEquals(posMiddleAll.length, 4);

        assertEquals(posMiddleAll[0], 1.5, 0);
        assertEquals(posMiddleAll[1], 3.5, 0);
        assertEquals(posMiddleAll[2], 5.5, 0);
        assertEquals(posMiddleAll[3], 7.5, 0);

        //avec start a -10
        posMiddleAll = PlacementsLine.posMiddle(4, 9, -10, 1);
        assertEquals(posMiddleAll.length, 4);

        assertEquals(posMiddleAll[0], -8.5, 0);
        assertEquals(posMiddleAll[1], -6.5, 0);
        assertEquals(posMiddleAll[2], -4.5, 0);
        assertEquals(posMiddleAll[3], -2.5, 0);
    }
}
