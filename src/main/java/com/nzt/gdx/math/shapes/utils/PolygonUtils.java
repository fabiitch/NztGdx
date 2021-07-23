package com.nzt.gdx.math.shapes.utils;

import com.badlogic.gdx.math.GeometryUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public class PolygonUtils {

    public static Polygon tmpPolygon = new Polygon(); //TODO mathSett
    public static Vector2 tmpVector = new Vector2(); //TODO mathSett

    private PolygonUtils() {

    }

    public static float getMaxDstVertexFromZero(Polygon polygon) {
        float[] vertices = polygon.getTransformedVertices();
        Vector2 tmp = PolygonUtils.tmpVector;
        int i = 0;
        float dstMin = Float.MAX_VALUE;
        while (i <= vertices.length / 2) {
            tmp.set(vertices[i], vertices[i + 1]);
            float dst = tmp.dst(0, 0);
            dstMin = Math.min(dstMin, dst);
            i+=2;
        }
        return dstMin;
    }

    public static Polygon getTmpPolygon(float[] vertices) {
        tmpPolygon.setVertices(vertices);
        return tmpPolygon;
    }

    public static Vector2 getCenter(Polygon polygon, Vector2 toSet) {
        return GeometryUtils.polygonCentroid(polygon.getTransformedVertices(), 0, polygon.getVertices().length, toSet);
    }

    public static float getVertexValue(Polygon polygon, int vertexNum, boolean xValue) {
        float[] vertices = polygon.getTransformedVertices();
        if (xValue)
            return vertices[2 * vertexNum];
        return vertices[2 * vertexNum + 1];
    }

    public static Vector2 getVertex(Polygon polygon, int vertexNum, Vector2 pos) {
        float[] vertices = polygon.getTransformedVertices();
        if (vertexNum < 0 || vertexNum > vertices.length / 2)
            throw new IllegalArgumentException("getVertex can return vertex range (0,2)");
        return pos.set(getVertexValue(polygon, vertexNum, true), getVertexValue(polygon, vertexNum, false));
    }
}
