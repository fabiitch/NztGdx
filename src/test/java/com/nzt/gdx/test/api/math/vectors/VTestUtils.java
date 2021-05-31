package com.nzt.gdx.test.api.math.vectors;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import org.junit.Assert;

/**
 * utils for test Vectors and print value in junit (better than
 *
 */
public class VTestUtils {

	public static void assertEquals(Vector2 v1, Vector2 v2) {
		assertEquals(v1, v2, MathUtils.FLOAT_ROUNDING_ERROR);
	}

	public static void assertEquals(Vector2 v1, Vector2 v2, float tolerance) {
		float x1 = v1.x;
		float y1 = v1.y;
		float x2 = v2.x;
		float y2 = v2.y;

		Assert.assertEquals(x1, x2, tolerance);
		Assert.assertEquals(y1, y2, tolerance);
	}

	public static void assertEquals(Vector3 v1, Vector3 v2) {
		assertEquals(v1, v2, MathUtils.FLOAT_ROUNDING_ERROR);
	}

	public static void assertEquals(Vector3 v1, Vector3 v2, float tolerance) {
		float x1 = v1.x;
		float y1 = v1.y;
		float z1 = v1.z;

		float x2 = v2.x;
		float y2 = v2.y;
		float z2 = v2.z;

		Assert.assertEquals(x1, x2, tolerance);
		Assert.assertEquals(y1, y2, tolerance);
		Assert.assertEquals(z1, z2, tolerance);
	}
}
