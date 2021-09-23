package com.nzt.gdx.math.intersectors;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.nzt.gdx.math.shapes.utils.RectangleUtils;

public class IntersectorRectangle {

    private static final float[] tmpVerticesArray = new float[8];
    private static final float[] tmp2VerticesArray = new float[8];

    public static boolean polygon(Rectangle rectangle, Polygon polygon) {
        return Intersector.overlapConvexPolygons(RectangleUtils.getAsVertices(rectangle, tmpVerticesArray), polygon.getTransformedVertices(), null);
    }

    public static boolean polygon(Rectangle rectangle, Polygon polygon, Intersector.MinimumTranslationVector translationVector) {
        return Intersector.overlapConvexPolygons(RectangleUtils.getAsVertices(rectangle, tmpVerticesArray), polygon.getTransformedVertices(), translationVector);
    }

    public static boolean rectangles(Rectangle rectangle1, Rectangle rectangle2, Intersector.MinimumTranslationVector translationVector) {
        translationVector.normal.setZero();
        if (RectangleUtils.overlaps(rectangle1,rectangle2)) {
            Intersector.overlapConvexPolygons(RectangleUtils.getAsVertices(rectangle1, tmpVerticesArray), RectangleUtils.getAsVertices(rectangle2, tmp2VerticesArray), translationVector);
            return true;
        }

        return false;
    }
}
