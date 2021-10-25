package com.nzt.gdx.test.api.math.shape.utils;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shapes.utils.CircleUtils;
import com.nzt.gdx.test.api.math.AbstractMathTest;
import com.nzt.gdx.test.api.math.vectors.VTestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.nzt.gdx.test.api.math.AbstractMathTest.c;
import static com.nzt.gdx.test.api.math.AbstractMathTest.v;

public class CircleUtilsTest extends AbstractMathTest {
    private final static Vector2 tmp = new Vector2();
    private final static float TOLERANCE = 0.001f;

    @Test
    public void getCenterTest() {
        Circle circle = c(50, 50, 50);
        Vector2 center = CircleUtils.getCenter(circle, tmp);
        VTestUtils.assertEquals(center, v(50, 50));
    }

    @Test
    public void posWithAngleDegTest() {

        Circle circle = c(0, 0, 50);
        Vector2 pos;

        pos = CircleUtils.posWithAngleDeg(circle, 0, tmp);
        VTestUtils.assertEquals(v(50, 0), pos, TOLERANCE);

        pos = CircleUtils.posWithAngleDeg(circle, 90, tmp);
        VTestUtils.assertEquals(v(0, 50), pos, TOLERANCE);

        pos = CircleUtils.posWithAngleDeg(circle, 180, tmp);
        VTestUtils.assertEquals(v(-50, 0), pos, TOLERANCE);


        pos = CircleUtils.posWithAngleDeg(circle, 270, tmp);
        VTestUtils.assertEquals(v(0, -50), pos, TOLERANCE);

        pos = CircleUtils.posWithAngleDeg(circle, 360, tmp);
        VTestUtils.assertEquals(v(50, 0), pos, TOLERANCE);
    }

    @Test
    public void getTangentTest() {
        Circle circle = c(0, 0, 50);
        Vector2 tangent;

        tangent = CircleUtils.getTangentDeg(circle, 0, tmp);
        VTestUtils.assertEquals(v(0, 1), tangent, TOLERANCE);

        tangent = CircleUtils.getTangentDeg(circle, 90, tmp);
        VTestUtils.assertEquals(v(-1, 0), tangent, TOLERANCE);

        tangent = CircleUtils.getTangentDeg(circle, 180, tmp);
        VTestUtils.assertEquals(v(0, -1), tangent, TOLERANCE);

        tangent = CircleUtils.getTangentDeg(circle, 270, tmp);
        VTestUtils.assertEquals(v(1, 0), tangent, TOLERANCE);
    }


    @Test
    public void dirFromCenter() {
        Circle circle = c(0, 0, 50);
        Vector2 normal;
        normal = CircleUtils.dirFromCenter(circle, v(50, 0), v());
        VTestUtils.assertEquals(v(1, 0), normal);

        normal = CircleUtils.dirFromCenter(circle, 0, v());
        VTestUtils.assertEquals(v(1, 0), normal);

        normal = CircleUtils.dirFromCenter(circle, v(0, 5), v());
        VTestUtils.assertEquals(v(0, 1), normal);

        normal = CircleUtils.dirFromCenter(circle, 90, v());
        VTestUtils.assertEquals(v(0, 1), normal);
    }

    @Test
    public void dirToCenter() {
        Circle circle = c(0, 0, 50);
        Vector2 normal;
        normal = CircleUtils.dirToCenter(circle, v(50, 0), v());
        VTestUtils.assertEquals(v(-1, 0), normal);

        normal = CircleUtils.dirToCenter(circle, 0, v());
        VTestUtils.assertEquals(v(-1, 0), normal);

        normal = CircleUtils.dirToCenter(circle, v(0, 5), v());
        VTestUtils.assertEquals(v(0, -1), normal);

        normal = CircleUtils.dirToCenter(circle, 90, v());
        VTestUtils.assertEquals(v(0, -1), normal);
    }

    @Test
    public void getRectBoundsTest() {
        Circle circle = c(0, 0, 100);
        Rectangle rectBounds = CircleUtils.getRectBounds(circle, new Rectangle());
        Assertions.assertEquals(new Rectangle(-100, -100, 200, 200), rectBounds);

        circle = c(200, 200, 200);
        rectBounds = CircleUtils.getRectBounds(circle, new Rectangle());
        Assertions.assertEquals(new Rectangle(0, 0, 400, 400), rectBounds);
    }


}
