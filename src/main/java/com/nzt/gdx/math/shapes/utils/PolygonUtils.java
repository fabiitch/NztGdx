package com.nzt.gdx.math.shapes.utils;

import com.badlogic.gdx.math.GeometryUtils;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.CalculUtils;
import com.nzt.gdx.math.shapes.Segment;
import com.nzt.gdx.math.vectors.V2;

public class PolygonUtils {

    public static Polygon tmpPolygon = new Polygon(); //TODO mathSett
    public static Vector2 tmpV1 = new Vector2(); //TODO mathSett
    public static Vector2 tmpV2 = new Vector2();
    public static Vector2 tmpV3 = new Vector2();

    private PolygonUtils() {

    }

    public static float getMaxDstVertexFromZero(Polygon polygon, Vector2 vertex) {
        float[] vertices = polygon.getTransformedVertices();
        Vector2 tmp = PolygonUtils.tmpV1;
        float dstMax = 0;

        int i = 0;
        while (i < vertices.length) {
            tmp.set(vertices[i], vertices[i + 1]);
            float dst = tmp.dst(0, 0);
            if (dst > dstMax) {
                dstMax = dst;
                if (vertex != null)
                    vertex.set(tmp);
            }
            i += 2;
        }
        return dstMax;
    }

    public static float getMaxDstVertexFromZero(Polygon polygon) {
        return getMaxDstVertexFromZero(polygon, null);
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

    public static int getVertexBefore(Polygon polygon, int vertex) {
        return CalculUtils.floorMod(vertex - 1, polygon.getVertices().length / 2);
    }

    public static int getVertexAfter(Polygon polygon, int vertex) {
        return (vertex + 1) % (polygon.getVertices().length / 2);
    }

    public static float getVertexAngleDeg(Polygon polygon, int vertex) {
        int vertexA = getVertexBefore(polygon, vertex);
        int vertexB = getVertexAfter(polygon, vertex);

        getVertex(polygon, vertex, tmpV1);
        tmpV1.sub(getVertexValue(polygon, vertexA, true), getVertexValue(polygon, vertexA, false));

        getVertex(polygon, vertex, tmpV2);
        tmpV2.sub(getVertexValue(polygon, vertexB, true), getVertexValue(polygon, vertexB, false));

        float angle = tmpV1.angleDeg(tmpV2);
        if (angle > 180)
            angle = 360 - angle;
        return angle;
    }

    public static boolean isConvex(Polygon polygon) {
        float[] vertices = polygon.getTransformedVertices();

        if (vertices.length / 2 < 4)
            return true;

        boolean sign = false;
        int n = vertices.length / 2;

        for (int i = 0; i < n; i++) {
            double dx1 = getVertexValue(polygon, (i + 2) % n, true) - getVertexValue(polygon, (i + 1) % n, true);
            double dy1 = getVertexValue(polygon, (i + 2) % n, false) - getVertexValue(polygon, (i + 1) % n, false);
            double dx2 = getVertexValue(polygon, (i), true) - getVertexValue(polygon, (i + 1) % n, true);
            double dy2 = getVertexValue(polygon, (i) % n, false) - getVertexValue(polygon, (i + 1) % n, false);
            double zcrossproduct = dx1 * dy2 - dy1 * dx2;
            if (i == 0)
                sign = zcrossproduct > 0;
            else if (sign != (zcrossproduct > 0))
                return false;
        }

        return true;
    }

    public static Segment getNearestSegment(Polygon polygon, Vector2 point, Segment result) {
        float dstMin = Float.MAX_VALUE;

        float[] vertices = polygon.getTransformedVertices();
        int i = 0;

        int vertexA =0, vertexB=0;
        while (i <= vertices.length / 2) {
            result.a.set(vertices[i], vertices[i + 1]);
            result.b.set(vertices[i+2], vertices[i + 3]);
            tmpV1.set(vertices[i], vertices[i + 1]);
            tmpV2.set(vertices[i + 2], vertices[i + 3]);
            result.nearestPoint(point,tmpV1);

            float dstPoint = point.dst2(tmpV1);
            if (dstPoint < dstMin) {
                vertexA = i/2;
                vertexB = vertexA++;
                dstMin = dstPoint;
            }
            i += 2;
        }
        //last and first point
        result.a.set(vertices[0], vertices[1]);
        result.b.set(vertices[vertices.length - 2], vertices[vertices.length - 1]);
        result.nearestPoint(point, tmpV1);
        float dstPoint = point.dst2(tmpV1);
        if (dstPoint < dstMin) {
            vertexA = 0;
            vertexB = vertices.length / 2 -1;
        }
        PolygonUtils.getVertex(polygon, vertexA, result.a);
        PolygonUtils.getVertex(polygon, vertexB, result.b);
        return result;
    }

}
