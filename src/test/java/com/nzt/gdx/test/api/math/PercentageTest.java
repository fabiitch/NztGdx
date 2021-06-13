package com.nzt.gdx.test.api.math;

import com.nzt.gdx.math.Percentage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PercentageTest {

    private static final float DELTA_0 = 0f;
    private static final float DELTA_01 = 0.1f;

    @Test
    public void getPercentTest() {
        assertEquals(50, Percentage.getPercent(50, 100), DELTA_0);
        assertEquals(5.0f, Percentage.getPercent(20, 400), DELTA_0);
        assertEquals(11.111111f, Percentage.getPercent(20, 180), DELTA_0);


        assertEquals(50, Percentage.getPercent(50, 100), DELTA_0);
        assertEquals(5.0f, Percentage.getPercent(20, 400), DELTA_0);
        assertEquals(11.111111f, Percentage.getPercent(20, 180), DELTA_0);
    }

    @Test
    public void getValueTest() {
        assertEquals(50, Percentage.getValue(50, 100), DELTA_0);
        assertEquals(45, Percentage.getValue(15, 300), DELTA_0);
        assertEquals(16.38f, Percentage.getValue(685.52f, 2.39f), DELTA_01);
    }

    @Test
    public void addXPercentOf() {
        assertEquals(150, Percentage.addXPercentTo(50, 100), DELTA_0);
        assertEquals(1025, Percentage.addXPercentTo(105, 500), DELTA_0);
        assertEquals(53.59f, Percentage.addXPercentTo(20, 44.66f), DELTA_01);
    }

    @Test
    public void removeXPercentOf() {
        assertEquals(50, Percentage.removeXPercentTo(50, 100), DELTA_0);
        assertEquals(475.63f, Percentage.removeXPercentTo(14.3f, 555), DELTA_01);
        assertEquals(-2436.01f, Percentage.removeXPercentTo(1055.3f, 255f), DELTA_01);
    }
}
