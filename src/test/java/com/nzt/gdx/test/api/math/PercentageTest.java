package com.nzt.gdx.test.api.math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.nzt.gdx.math.Percentage;

public class PercentageTest {

	private static float DELTA_0 = 0f;
	private static float DELTA_01 = 0.1f;

	@Test
	public void getPercentTest() {
		assertEquals(Percentage.getPercent(50, 100), 50, DELTA_0);
		assertEquals(Percentage.getPercent(20, 400), 5.0f, DELTA_0);
		assertEquals(Percentage.getPercent(20, 180), 11.111111f, DELTA_0);
	}

	@Test
	public void getValueTest() {
		assertEquals(Percentage.getValue(50, 100), 50, DELTA_0);
		assertEquals(Percentage.getValue(15, 300), 45, DELTA_0);
		assertEquals(Percentage.getValue(685.52f, 2.39f), 16.38f, DELTA_01);
	}

	@Test
	public void addXPercentOf() {
		assertEquals(Percentage.addXPercentTo(50, 100), 150, DELTA_0);
		assertEquals(Percentage.addXPercentTo(105, 500), 1025, DELTA_0);
		assertEquals(Percentage.addXPercentTo(20, 44.66f), 53.59f, DELTA_01);
	}

	@Test
	public void removeXPercentOf() {
		assertEquals(Percentage.removeXPercentTo(50, 100), 50, DELTA_0);
		assertEquals(Percentage.removeXPercentTo(14.3f, 555), 475.63f, DELTA_01);
		assertEquals(Percentage.removeXPercentTo(1055.3f, 255f), -2436.01f, DELTA_01);
	}
}
