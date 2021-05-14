package com.nzt.gdx.math.bits;

//TODO voir si utilisé , sinon remove, use Bitset(jdk) or Bits(gdx)
public class BitsGenerator {

	private BitsGenerator() {

	}

	public static int toZero(int number, int... bitTo1) {
		for (int bitN : bitTo1) {
			int remove = 1 << bitN;
			if (number >= remove)
				number -= 1 << bitN;
		}
		return number;
	}

	public static short toZero(short number, short... bitTo1) {
		for (int bitN : bitTo1) {
			int remove = 1 << bitN;
			if (number >= remove)
				number -= 1 << bitN;
		}
		return number;
	}

	public static int toOne(int number, int... bitTo1) {
		for (int bitN : bitTo1) {
			number |= 1 << bitN;
		}
		return number;
	}

	public static short toOne(short number, short... bitTo1) {
		for (int bitN : bitTo1) {
			number |= 1 << bitN;
		}
		return number;
	}

	public static int getBits(int... bitTo1) {
		if (bitTo1 == null || bitTo1.length == 0)
			return 0;
		int numberBinary = 0;
		for (int bitN : bitTo1) {
			numberBinary |= 1 << bitN;
		}
		return numberBinary;
	}

	public static short getBits(short... bitTo1) {
		if (bitTo1 == null || bitTo1.length == 0)
			return 0;
		short numberBinary = 0;
		for (int bitN : bitTo1) {
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
