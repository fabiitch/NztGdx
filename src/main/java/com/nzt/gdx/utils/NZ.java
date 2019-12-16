package com.nzt.gdx.utils;

/**
 * Utiliy class for Gdx WIP
 * @author fabiitch
 *
 */
public class NZ {

	public static boolean isNull(Object object) {
		return object == null;
	}

	public static boolean isNull(Object... objects) {
		final int n = objects.length;
		for (int i = 0; i < n; i++) {
			if (objects[i] != null) {
				return false;
			}
		}
		return true;
	}

	public static boolean isNotNull(Object object) {
		return object != null;
	}

	public static boolean isNotNull(Object... objects) {
		final int n = objects.length;
		for (int i = 0; i < n; i++) {
			if (objects[i] == null) {
				return false;
			}
		}
		return true;
	}
}
