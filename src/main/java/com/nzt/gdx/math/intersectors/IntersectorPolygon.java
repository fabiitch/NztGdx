package com.nzt.gdx.math.intersectors;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.nzt.gdx.math.shapes.Segment;
import com.nzt.gdx.math.shapes.utils.RectangleUtils;

public class IntersectorPolygon {
    public static Intersector.MinimumTranslationVector tmpTranslationVector = new Intersector.MinimumTranslationVector();
    private static float[] tmpRectVertices = new float[8];

    public static boolean circle(Circle circle, Polygon polygon) {
        return IntersectorCircle.polygon(circle, polygon);
    }

    public static boolean polygons(Polygon polygonA, Polygon polygonB, Intersector.MinimumTranslationVector translationVector) {
        return Intersector.overlapConvexPolygons(polygonA, polygonB, translationVector);
    }

    public static boolean rectangle(Polygon polygon, Rectangle rectangle) {
        return Intersector.overlapConvexPolygons(polygon.getTransformedVertices(), RectangleUtils.getAsVertices(rectangle, tmpRectVertices), null);
    }

    public static boolean rectangle(Polygon polygon, Rectangle rectangle, Intersector.MinimumTranslationVector translationVector) {
        return Intersector.overlapConvexPolygons(polygon.getTransformedVertices(), RectangleUtils.getAsVertices(rectangle, tmpRectVertices), translationVector);
    }
}
