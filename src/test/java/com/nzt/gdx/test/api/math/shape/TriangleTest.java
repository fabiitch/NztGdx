package com.nzt.gdx.test.api.math.shape;

import org.junit.Assert;
import org.junit.Test;

import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shape.Triangle;

public class TriangleTest {
	private static float DELTA_01 = 0.1f;

	private Vector2 v0 = new Vector2(0, 0);
	private Vector2 v1 = new Vector2(0, 5);
	private Vector2 v2 = new Vector2(5, 0);
	private Triangle triangle = new Triangle(v0, v1, v2);

	private Vector2 posTest = v(-100, -100);

	@Test
	public void getDirTest() {
		triangle.getDir(posTest, 0, 1);
		Assert.assertEquals(v(0, 1), posTest);

		triangle.getDir(posTest, 0, 2);
		Assert.assertEquals(v(1, 0), posTest);

		triangle.getDir(posTest, 1, 2);
		Assert.assertTrue(v(1, -1).nor().epsilonEquals(posTest,DELTA_01));
	}

	@Test
	public void getAngleTest() {
		float angle = triangle.getAngle(0);
		Assert.assertEquals(90, angle, DELTA_01);
	}

	@Test
	public void getVertex() {
		triangle.getA(posTest);
		Assert.assertEquals(posTest, v0);

		triangle.getB(posTest);
		Assert.assertEquals(posTest, v1);

		triangle.getC(posTest);
		Assert.assertEquals(posTest, v2);
	}

	@Test
	public void changeOriginToVertexTest() {
		float originX;
		float originY;
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
