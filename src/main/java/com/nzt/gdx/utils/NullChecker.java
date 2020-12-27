package com.nzt.gdx.utils;

/**
 * Utility class for Gdx WIP //TODO a supp je crois
 * @author fabiitch
 *
 */
public class NullChecker {

	public static boolean isNull(Object... objects) {
		final int n = objects.length;
		for (int i = 0; i < n; i++) {
			if (objects[i] != null) {
				return false;
			}
		}
		return true;
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
