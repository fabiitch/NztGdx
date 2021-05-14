package com.nzt.gdx.test.api.math.bits;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.nzt.gdx.math.bits.BitsUtils;

public class BitsUtilsTest {

	@Test
	public void testBitTest() {

		int bit1 = 0b1100101;

		int bitNum = 0;

		assertTrue(BitsUtils.testBit(bit1, bitNum++));
		assertFalse(BitsUtils.testBit(bit1, bitNum++));

		assertTrue(BitsUtils.testBit(bit1, bitNum++));

		assertFalse(BitsUtils.testBit(bit1, bitNum++));
		assertFalse(BitsUtils.testBit(bit1, bitNum++));

		assertTrue(BitsUtils.testBit(bit1, bitNum++));
		assertTrue(BitsUtils.testBit(bit1, bitNum++));

		assertFalse(BitsUtils.testBit(bit1, bitNum++));
	}

	@Test
	public void testBitsTest() {
		int bit1 = 0b1100101;

		assertTrue(BitsUtils.testBits(bit1, 0, 2, 5, 6));
		assertFalse(BitsUtils.testBits(bit1, 1, 3, 4));
	}

	@Test
	public void oneTrueTest() {
		assertTrue(BitsUtils.oneTrue(0b110101));
		assertTrue(BitsUtils.oneTrue(0b001000));
		assertTrue(BitsUtils.oneTrue(0b1000000));
		assertFalse(BitsUtils.oneTrue(0b000000));
	}

	@Test
	public void oneFalse() {
		assertTrue(BitsUtils.oneFalse(0b110101));
		assertTrue(BitsUtils.oneFalse(0b000001));
		assertTrue(BitsUtils.oneFalse(0b010001));
		assertFalse(BitsUtils.oneFalse(0b11111));
		assertFalse(BitsUtils.oneFalse(0b1));
		assertFalse(BitsUtils.oneFalse(0b11));
	}
}
