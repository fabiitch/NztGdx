package com.nzt.gdx.math.bits;

//TODO voir si utilisé , sinon remove, use Bitset(jdk) or Bits(gdx)
public class BitsGenerator {

    private BitsGenerator() {

    }

    public static int toZero(int number, int bitTo0) {
        int remove = 1 << bitTo0;
        if ((number & remove) > 0 && number >= remove)
            number -= 1 << bitTo0;
        return number;
    }

    public static int toZero(int number, int... bitsTo0) {
        for (int bitN : bitsTo0) {
            int remove = 1 << bitN;
            if ((number & remove) > 0 && number >= remove)
                number -= 1 << bitN;
        }
        return number;
    }

    public static short toZero(short number, short bitTo0) {
        int remove = 1 << bitTo0;
        if ((number & remove) > 1 && number >= remove)
            number -= 1 << bitTo0;
        return number;
    }

    public static short toZero(short number, short... bitsTo0) {
        for (short bitN : bitsTo0) {
            int remove = 1 << bitN;
            if (number >= remove)
                number -= 1 << bitN;
        }
        return number;
    }

    public static int toOne(int number, int bitTo1) {
        return number | 1 << bitTo1;
    }

    public static int toOne(int number, int... bitsTo1) {
        for (int bitN : bitsTo1) {
            number |= 1 << bitN;
        }
        return number;
    }

    public static short toOne(short number, short bitTo1) {
        return (short) (number | 1 << bitTo1);
    }

    public static short toOne(short number, short... bitsTo1) {
        for (short bitN : bitsTo1) {
            number |= 1 << bitN;
        }
        return number;
    }

    public static int getBits(int... bitsToOne) {
        if (bitsToOne == null || bitsToOne.length == 0)
            return 0;
        int numberBinary = 0;
        for (int bitN : bitsToOne) {
            numberBinary |= 1 << bitN;
        }
        return numberBinary;
    }

    public static short getBits(short... bits) {
        if (bits == null || bits.length == 0)
            return 0;
        short numberBinary = 0;
        for (int bitN : bits) {
            numberBinary |= 1 << bitN;
        }
        return numberBinary;
    }

    public static int shortFromString(String binary) {
        return Integer.parseInt(binary, 2);
    }

    public static int fromString(String binary) {
        return Integer.parseInt(binary, 2);
    }
}
