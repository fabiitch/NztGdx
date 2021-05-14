package com.nzt.gdx.math.bits;

public class BitsUtils {

	private BitsUtils() {
	}

	public static boolean testBit(int binary, int n) {
		return (binary >>> n & 1) != 0;
	}

	public static boolean testBits(int binary, int... array) {
		for (int i = 0, n = array.length; i < n; i++) {
			if ((binary >>> array[i] & 1) == 0)
				return false;
		}
		return true;
	}

	public static boolean oneTrue(int binary) {
		return binary != 0;
	}

	public static boolean oneFalse(int binary) {
		int compare = binary & 1;
		return compare != binary;
	}

	public static boolean oneFalse(int binary, int minSize) {
		int compare = binary & 1;
		return compare != binary;
	}

	public static boolean testBit(short binary, int n) {
		return (binary >>> n & 1) != 0;
	}

	public static boolean testBits(short binary, int... array) {
		for (int i = 0, n = array.length; i < n; i++) {
			if ((binary >>> array[i] & 1) == 0)
				return false;
		}
		return true;
	}

	public static boolean testBit(long binary, short n) {
		return (binary >>> n & 1) != 0;
	}

	public static boolean testBits(long binary, int... array) {
		for (int i = 0, n = array.length; i < n; i++) {
			if ((binary >>> array[i] & 1) == 0)
				return false;
		}
		return true;
	}
}
