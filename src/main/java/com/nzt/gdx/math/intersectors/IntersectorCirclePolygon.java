package com.nzt.gdx.math.intersectors;

import com.badlogic.gdx.math.*;

public class IntersectorCirclePolygon {


    private static Vector2 tmp = new Vector2(); //TODO group tous les tmp
    private static Vector2 tmp2 = new Vector2(); //TODO group tous les tmp

    public static Intersector.MinimumTranslationVector translationVector = new Intersector.MinimumTranslationVector();

    public static boolean circlePolygon(Circle circle, Polygon polygon, Intersector.MinimumTranslationVector translationVector) {

        float[] vertices = polygon.getTransformedVertices();
        int i = 0;
//        tmp3.set(circle.x, circle.y);
//        float powRadius = (float) Math.pow(circle.radius, 2);
        while (i < vertices.length / 2) {
            tmp.set(vertices[i], vertices[i + 1]);
            tmp2.set(vertices[i + 2], vertices[i + 3]);
            boolean b = Intersector.intersectSegmentCircle(tmp, tmp2, circle, translationVector);
            if (b)
                return true;
            i += 2;
        }
        //last and first point
        tmp.set(vertices[0], vertices[1]);
        tmp2.set(vertices[vertices.length - 2], vertices[vertices.length - 1]);
        return Intersector.intersectSegmentCircle(tmp, tmp2, circle, translationVector);
    }

    public static boolean circlePolygon(Circle circle, Polygon polygon) {
        return circlePolygon(circle, polygon, null);
    }
}
