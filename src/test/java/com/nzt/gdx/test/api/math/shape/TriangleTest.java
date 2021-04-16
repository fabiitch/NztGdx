package com.nzt.gdx.test.api.math.shape;

import com.badlogic.gdx.math.MathUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shape.Triangle;

public class TriangleTest {
    private static float DELTA_01 = 0.1f;

    private Vector2 v0;
    private Vector2 v1;
    private Vector2 v2;
    private Triangle triangle;
    private Vector2 posTest;

    @Before
    public void init() {
        v0 = new Vector2(1, 1);
        v1 = new Vector2(0, 5);
        v2 = new Vector2(5, 0);
        triangle = new Triangle(v0, v1, v2);

        posTest = v(-100, -100);
    }

    private void moveAndRotate() {
        float min = -50000;
        float max = +50000;
        triangle.translate(MathUtils.random.nextFloat() * (max - min) + min, MathUtils.random.nextFloat() * (max - min) + min);
        triangle.rotate(0.1f);

        triangle.getA(v0);
        triangle.getB(v1);
        triangle.getC(v2);
    }

    @Test
    public void getDirTest() {
        for (int i = 0; i < 100; i++) {
            triangle.getDir(posTest, 0, 1);
            Assert.assertEquals(v(0, 1), posTest);

            triangle.getDir(posTest, 0, 2);
            Assert.assertEquals(v(1, 0), posTest);

            triangle.getDir(posTest, 1, 2);
            Assert.assertTrue(v(1, -1).nor().epsilonEquals(posTest, DELTA_01));
            moveAndRotate();
        }
    }

    @Test
    public void getAngleTest() {
        for (int i = 0; i < 100; i++) {
            float angleA = triangle.getAngleDeg(0);
            Assert.assertEquals(90, angleA, DELTA_01);

            float angleB = triangle.getAngleDeg(1);
            Assert.assertEquals(45, angleB, DELTA_01);

            float angleC = triangle.getAngleDeg(2);
            Assert.assertEquals(45, angleC, DELTA_01);
            moveAndRotate();
        }
    }

    @Test
    public void getVertex() {
        for (int i = 0; i < 100; i++) {
            triangle.getA(posTest);
            Assert.assertEquals(posTest, v0);

            triangle.getB(posTest);
            Assert.assertEquals(posTest, v1);

            triangle.getC(posTest);
            Assert.assertEquals(posTest, v2);
            moveAndRotate();
        }
    }

    @Test
    public void changeOriginToVertexTest() {
        float originX;
        float originY;
        for (int i = 0; i < 100; i++) {
            triangle.setOriginOnVertex(0);
            originX = triangle.getOriginX();
            originY = triangle.getOriginY();
            posTest.set(originX, originY);
            Assert.assertEquals(posTest, v0);

            triangle.setOriginOnVertex(1);
            originX = triangle.getOriginX();
            originY = triangle.getOriginY();
            posTest.set(originX, originY);
            Assert.assertEquals(posTest, v1);

            triangle.setOriginOnVertex(2);
            originX = triangle.getOriginX();
            originY = triangle.getOriginY();
            posTest.set(originX, originY);
            Assert.assertEquals(posTest, v2);
        }
        moveAndRotate();
    }

    // com.nzt.gdx.math.shape.Triangle.getVertex(int)
    // private method cant test witouht PowerMock
    @Test
    public void getVertexAskTest() {
        Assert.assertEquals(0, 0 % 3);
        Assert.assertEquals(1, 1 % 3);
        Assert.assertEquals(2, 2 % 3);
        Assert.assertEquals(0, 3 % 3);
        Assert.assertEquals(1, 4 % 3);
        Assert.assertEquals(2, 5 % 3);
        Assert.assertEquals(0, 6 % 3);
        Assert.assertEquals(1, 7 % 3);
        Assert.assertEquals(2, 8 % 3);
        Assert.assertEquals(0, 9 % 3);
        Assert.assertEquals(1, 10 % 3);
    }

    private Vector2 v(float a, float b) {
        return new Vector2(a, b);
    }
}
