package com.nzt.gdx.test.api.math.vectors;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import org.junit.jupiter.api.Assertions;

/**
 * utils for test Vectors and print value in junit
 */
public class VTestUtils {
    private static final float TOLERANCE = MathUtils.FLOAT_ROUNDING_ERROR;

    public static void assertEquals(Vector2 v1, Vector2 v2) {
        assertEquals(v1, v2, TOLERANCE);
    }

    public static void assertEquals(Vector2 v1, Vector2 v2, float tolerance) {
        float x1 = v1.x;
        float y1 = v1.y;
        float x2 = v2.x;
        float y2 = v2.y;

        Assertions.assertEquals(x1, x2, tolerance, "x not equals");
        Assertions.assertEquals(y1, y2, tolerance, "y not equals");
    }

    public static void assertEquals(Vector2 v1, Vector2 v2, String msgError) {
        assertEquals(v1, v2, TOLERANCE, msgError);
    }

    public static void assertEquals(Vector2 v1, Vector2 v2, float tolerance, String msgError) {
        float x1 = v1.x;
        float y1 = v1.y;
        float x2 = v2.x;
        float y2 = v2.y;

        Assertions.assertEquals(x1, x2, tolerance, msgError);
        Assertions.assertEquals(y1, y2, tolerance, msgError);
    }

    public static void assertEquals(Vector3 v1, Vector3 v2, String msgError) {
        assertEquals(v1, v2, TOLERANCE, msgError);
    }

    public static void assertEquals(Vector3 v1, Vector3 v2, float tolerance, String msgError) {
        float x1 = v1.x;
        float y1 = v1.y;
        float z1 = v1.z;

        float x2 = v2.x;
        float y2 = v2.y;
        float z2 = v2.z;
        Assertions.assertEquals(x1, x2, tolerance, msgError);
        Assertions.assertEquals(y1, y2, tolerance, msgError);
        Assertions.assertEquals(z1, z2, tolerance, msgError);
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

        Assertions.assertEquals(x1, x2, tolerance, "x not equals");
        Assertions.assertEquals(y1, y2, tolerance, "y not equals");
        Assertions.assertEquals(z1, z2, tolerance, "z not equals");
    }

    //========================================================
    public static void assertNotEquals(Vector2 v1, Vector2 v2, float tolerance) {
        float x1 = v1.x;
        float y1 = v1.y;
        float x2 = v2.x;
        float y2 = v2.y;

        Assertions.assertNotEquals(x1, x2, tolerance, "x equals");
        Assertions.assertNotEquals(y1, y2, tolerance, "y equals");
    }

    public static void assertNotEquals(Vector2 v1, Vector2 v2, String msgError) {
        assertNotEquals(v1, v2, TOLERANCE, msgError);
    }

    public static void assertNotEquals(Vector2 v1, Vector2 v2, float tolerance, String msgError) {
        float x1 = v1.x;
        float y1 = v1.y;
        float x2 = v2.x;
        float y2 = v2.y;

        Assertions.assertNotEquals(x1, x2, tolerance, msgError);
        Assertions.assertNotEquals(y1, y2, tolerance, msgError);
    }

    public static void assertNotEquals(Vector3 v1, Vector3 v2, String msgError) {
        assertNotEquals(v1, v2, TOLERANCE, msgError);
    }

    public static void assertNotEquals(Vector2 v1, Vector2 v2) {
        assertNotEquals(v1, v2, TOLERANCE);
    }

    public static void assertNotEquals(Vector3 v1, Vector3 v2, float tolerance, String msgError) {
        float x1 = v1.x;
        float y1 = v1.y;
        float z1 = v1.z;

        float x2 = v2.x;
        float y2 = v2.y;
        float z2 = v2.z;
        Assertions.assertNotEquals(x1, x2, tolerance, msgError);
        Assertions.assertNotEquals(y1, y2, tolerance, msgError);
        Assertions.assertNotEquals(z1, z2, tolerance, msgError);
    }

    public static void assertNotEquals(Vector3 v1, Vector3 v2) {
        assertEquals(v1, v2, MathUtils.FLOAT_ROUNDING_ERROR);
    }

    public static void assertNotEquals(Vector3 v1, Vector3 v2, float tolerance) {
        float x1 = v1.x;
        float y1 = v1.y;
        float z1 = v1.z;

        float x2 = v2.x;
        float y2 = v2.y;
        float z2 = v2.z;

        Assertions.assertNotEquals(x1, x2, tolerance, "x equals");
        Assertions.assertNotEquals(y1, y2, tolerance, "y equals");
        Assertions.assertNotEquals(z1, z2, tolerance, "z equals");
    }
}
