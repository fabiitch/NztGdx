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

		assertTrue(BitsUtils.isOne(bit1, bitNum++));
		assertFalse(BitsUtils.isOne(bit1, bitNum++));

		assertTrue(BitsUtils.isOne(bit1, bitNum++));

		assertFalse(BitsUtils.isOne(bit1, bitNum++));
		assertFalse(BitsUtils.isOne(bit1, bitNum++));

		assertTrue(BitsUtils.isOne(bit1, bitNum++));
		assertTrue(BitsUtils.isOne(bit1, bitNum++));

		assertFalse(BitsUtils.isOne(bit1, bitNum++));
	}

	@Test
	public void testBitsTest() {
		int bit1 = 0b1100101;
		assertTrue(BitsUtils.isOne(bit1, 5));
		assertTrue(BitsUtils.isOne(bit1, 0, 2, 5, 6));
		assertFalse(BitsUtils.isOne(bit1, 1, 3, 4));
		assertFalse(BitsUtils.isOne(bit1, 3));

		short bit2 = 0b110000110;
		assertTrue(BitsUtils.isOne(bit2, 1,2,7,8));
		assertTrue(BitsUtils.isOne(bit2, 1));
		assertFalse(BitsUtils.isOne(bit2, 1,2,3,8));
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
		assertTrue(BitsUtils.oneFalse(0b100001));
		assertTrue(BitsUtils.oneFalse(0b010001));
		assertTrue(BitsUtils.oneFalse(0b011100));
		assertFalse(BitsUtils.oneFalse(0b11111));
		assertFalse(BitsUtils.oneFalse(0b1));
		assertFalse(BitsUtils.oneFalse(0b11));

		assertFalse(BitsUtils.oneFalse(0b11,5));
		assertFalse(BitsUtils.oneFalse(0b1111,6));
	}
}
