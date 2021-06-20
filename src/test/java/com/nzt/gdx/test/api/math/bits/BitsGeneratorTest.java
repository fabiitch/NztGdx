package com.nzt.gdx.test.api.math.bits;

import com.nzt.gdx.math.bits.BitsGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitsGeneratorTest {

    @Test
    public void generateTest() {
        testBinary("1", BitsGenerator.getBits(0));
        testBinary("11", BitsGenerator.getBits(0, 1));
        testBinary("10001100010", BitsGenerator.getBits(1, 5, 6, 10));
    }



    @Test
    public void toZero() {
        testBinary("1100000", BitsGenerator.toZero(0b1100000, 0));
        testBinary("1100000", BitsGenerator.toZero(0b1100001, 0));
        testBinary("10000", BitsGenerator.toZero(0b11111, 0, 1, 2, 3));
        testBinary("0b10100", BitsGenerator.toZero(0b11111, 3, 1, 0));
        testBinary("10000", BitsGenerator.toZero(0b10000, 2));
        testBinary("101", BitsGenerator.toZero(0b111, 1));
        testBinary("11", BitsGenerator.toZero(0b111, 2));
        testBinary("11", BitsGenerator.toZero(0b11, 5));
    }

    @Test
    public void toOne() {
        testBinary("0b1101001", BitsGenerator.toOne(0b1100001, 3));
        testBinary("1100001", BitsGenerator.toOne(0b1100001, 0));
        testBinary("1101011", BitsGenerator.toOne(0b1100001, 1, 3));
        testBinary("1110001", BitsGenerator.toOne(0b1100001, 4, 6));
        testBinary("1100001", BitsGenerator.toOne(0b1100001, 0));
        testBinary("1111111111", BitsGenerator.toOne(0b1111111111, 0, 1, 2, 3, 4, 5, 6, 7, 8));
        testBinary("10000000100", BitsGenerator.toOne(0b100, 10));
    }

    @Test
    public void fromString() {
        assertEquals(0b11001, BitsGenerator.fromString("11001"));
        assertEquals(0b110011111, BitsGenerator.fromString("110011111"));
        assertEquals(-0b110011111, BitsGenerator.fromString("-110011111"));
    }

    private void testBinary(String expected, int binary) {
        if (expected.startsWith("0b"))
            expected = expected.substring(2);

        if (!expected.equals(Integer.toBinaryString(binary))) {
            String str = "expected =" + expected + " ||   result=" + Integer.toBinaryString(binary);
            throw new AssertionError(str);
        }
    }
}
