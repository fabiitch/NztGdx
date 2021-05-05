package com.nzt.gdx.math.shape;

import java.util.Arrays;

import com.badlogic.gdx.math.GeometryUtils;
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
        super(new float[]{aX, aY, bX, bY, cX, cY});
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

        return pos.set(getVertexValue(vertex, true), getVertexValue(vertex, false));
    }

    public Vector2 getDir(Vector2 dir, int vertex1, int vertex2) {
        getVertex(dir, getVertex(vertex2));
        getVertex(tmpV1, getVertex(vertex1));
        dir.sub(tmpV1);
        return dir.nor();
    }

    public float getAngleDeg(int vertex) {
        getVertex(tmpV1, getVertex(vertex));
        tmpV1.sub(getVertexValue(vertex + 1, true), getVertexValue(vertex + 1, false));

        getVertex(tmpV2, getVertex(vertex));
        tmpV2.sub(getVertexValue(vertex + 2, true), getVertexValue(vertex + 2, false));

        float angle = tmpV1.angleDeg(tmpV2);
        if (angle > 180)
            angle = 360 - angle;
        return angle;
    }

    public void setOrigin(Vector2 pos) {
        this.setOrigin(pos.x, pos.y);
    }

    public void setOriginOnVertex(int vertexNum) {
        getVertex(tmpV2, vertexNum);
        this.setOrigin(tmpV2.x, tmpV2.y);
    }

    public Vector2 getCentroid(Vector2 result) {
        float[] vertices = getTransformedVertices();
        return GeometryUtils.triangleCentroid(vertices[0], vertices[1],
                vertices[2], vertices[3],
                vertices[4], vertices[5], result);
    }

    public Vector2 getCircumcenter(Vector2 result) {
        float[] vertices = getTransformedVertices();
        return GeometryUtils.triangleCircumcenter(vertices[0], vertices[1],
                vertices[2], vertices[3],
                vertices[4], vertices[5], result);
    }

    /**
     * return real vertex in triangle
     */
    private int getVertex(int vertexAsk) {
        return vertexAsk % 3;
    }

    private float getVertexValue(int vertex, boolean x) {
        vertex %= 3;
        float[] transformedVertices = this.getTransformedVertices();
        if (x)
            return transformedVertices[2 * vertex];
        return transformedVertices[2 * vertex + 1];
    }

    @Override
    public String toString() {
        return "Triangle " + Arrays.toString(getTransformedVertices());
    }

    public String toString(boolean vector2) {
        String a = getVertex(tmpV1, 0).toString();
        String b = getVertex(tmpV1, 1).toString();
        String c = getVertex(tmpV1, 2).toString();
        return "Triangle[a=" + a + " b=" + b + " c=" + c + "]";
    }

}
