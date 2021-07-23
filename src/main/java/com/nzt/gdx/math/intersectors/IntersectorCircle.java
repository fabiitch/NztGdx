package com.nzt.gdx.math.intersectors;

import com.badlogic.gdx.math.*;
import com.nzt.gdx.math.shapes.utils.PolygonUtils;
import com.nzt.gdx.math.shapes.utils.RectangleUtils;
import com.nzt.gdx.math.vectors.V2;

public class IntersectorCircle {

    private static Vector2 tmp = new Vector2(); //TODO group tous les tmp
    private static Vector2 tmp2 = new Vector2();
    private static Vector2 tmp3 = new Vector2();
    private static Vector2 tmp4 = new Vector2();
    private static Vector2 tmp5 = new Vector2();

    private static float[] tmpRectVertices = new float[8];


    public static boolean circlePolygon(Circle circle, Polygon polygon) {
        float[] vertices = polygon.getTransformedVertices();
        int i = 0;
        while (i <= vertices.length / 2) {
            tmp.set(vertices[i], vertices[i + 1]);
            tmp2.set(vertices[i + 2], vertices[i + 3]);
            boolean b = Intersector.intersectSegmentCircle(tmp, tmp2, circle, null);
            if (b)
                return true;
            i += 2;
        }
        //last and first point
        tmp.set(vertices[0], vertices[1]);
        tmp2.set(vertices[vertices.length - 2], vertices[vertices.length - 1]);
        return Intersector.intersectSegmentCircle(tmp, tmp2, circle, null);
    }

    /**
     * @return intersect
     * goOut set  to put circle out of  rectangle
     */
    public static boolean replaceCircleRectangle(Circle circle, Rectangle rectangle, Vector2 goOut) {
        RectangleUtils.getAsVertices(rectangle, tmpRectVertices);
        Polygon tmpPolygon = PolygonUtils.getTmpPolygon(tmpRectVertices);
        return replaceCirclePolygon(circle, tmpPolygon, goOut);
    }

    /**
     * @return intersect
     * goOut set  to put circle out of polygons
     */
    public static boolean replaceCirclePolygon(Circle circle, Polygon polygon, Vector2 goOut) {
        tmp3.set(circle.x, circle.y);
        float dstMin = Float.MAX_VALUE;

        float[] vertices = polygon.getTransformedVertices();
        int i = 0;
        while (i <= vertices.length / 2) {
            tmp.set(vertices[i], vertices[i + 1]);
            tmp2.set(vertices[i + 2], vertices[i + 3]);
            Intersector.nearestSegmentPoint(tmp, tmp2, tmp3, tmp4);
            float dstCenter = tmp4.dst(tmp3);
            if (dstCenter < dstMin) {
                tmp5.set(tmp4);
                dstMin = dstCenter;
            }
            i += 2;
        }
        //last and first point
        tmp.set(vertices[0], vertices[1]);
        tmp2.set(vertices[vertices.length - 2], vertices[vertices.length - 1]);
        Intersector.nearestSegmentPoint(tmp, tmp2, tmp3, tmp4);
        float dstCenter = tmp4.dst(tmp3);
        if (dstCenter < dstMin) {
            tmp5.set(tmp4);
            dstMin = dstCenter;
        }

        if (dstMin > circle.radius)
            return false;

        tmp2.setZero();
        if (polygon.contains(circle.x, circle.y)) {
            V2.directionTo(tmp3, tmp5, tmp);
            tmp2.add(tmp.setLength(circle.radius + dstMin));
        } else {
            V2.directionTo(tmp5, tmp3, tmp);
            tmp2.add(tmp.setLength(circle.radius - dstMin));
        }
        goOut.set(tmp2);
        return true;
    }

}
