package com.nzt.gdx.math.shape;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public class Triangle extends Polygon {

	/**
	 * Static temporary Vector2. Use with care! Use only when sure other code will
	 * not also use this.
	 */
	public static final Vector2 tmpV1 = new Vector2();
	public static final Vector2 tmpV2 = new Vector2();

	public Triangle(float[] vertices) {
		super(vertices);
	}

	public Triangle(float aX, float aY, float bX, float bY, float cX, float cY) {
		this.setVertices(new float[] { aX, aY, bX, bY, cX, cY });
	}

	public Triangle(Vector2 a, Vector2 b, Vector2 c) {
		this(a.x, a.y, b.x, b.y, c.x, c.y);
	}

	public Vector2 getA(Vector2 pos) {
		return getVertex(pos, 0);
	}

	public Vector2 getB(Vector2 pos) {
		return getVertex(pos, 1);
	}

	public Vector2 getC(Vector2 pos) {
		return getVertex(pos, 2);
	}

	public Vector2 getVertex(Vector2 pos, int vertex) {
		if (vertex < 0 || vertex > 2)
			throw new IllegalArgumentException("getVertex can return vertex range (0,2)");

		float[] transformedVertices = this.getTransformedVertices();
		return pos.set(transformedVertices[2 * vertex], transformedVertices[2 * vertex + 1]);
	}

	public Vector2 getDir(Vector2 dir, int vertex1, int vertex2) {
		getVertex(tmpV1, vertex1);
		getVertex(tmpV2, vertex2);
		return dir.set(tmpV2).sub(tmpV1).nor();
	}

	public float getAngle(int vertex) {
		getVertex(tmpV1, getVertex(vertex + 1));
		float x1 = tmpV2.x;
		float x2 = tmpV2.y;
		getVertex(tmpV2, getVertex(vertex + 2));
		return tmpV2.dot(x1, x2);

	}

	public void setOrigin(Vector2 pos) {
		this.setOrigin(pos.x, pos.y);
	}

	public void setOriginOnVertex(int vertexNum) {
		getVertex(tmpV2, vertexNum);
		this.setOrigin(tmpV2.x, tmpV2.y);
	}

	private int getVertex(int vertexAsk) {
		return vertexAsk % 3;
	}
}
