package com.nzt.gdx.math.intersectors;

import com.badlogic.gdx.ai.utils.Ray;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.math.shapes.utils.RectangleUtils;
import com.nzt.gdx.math.vectors.V2;


public class IntersectorRectangle {

    private static final float[] tmpVerticesArray = new float[8];
    private static final float[] tmp2VerticesArray = new float[8];

    public static boolean polygon(Rectangle rectangle, Polygon polygon) {
        return Intersector.overlapConvexPolygons(RectangleUtils.getAsVertices(rectangle, tmpVerticesArray), polygon.getTransformedVertices(), null);
    }

    public static boolean polygon(Rectangle rectangle, Polygon polygon, Intersector.MinimumTranslationVector translationVector) {
        return Intersector.overlapConvexPolygons(RectangleUtils.getAsVertices(rectangle, tmpVerticesArray), polygon.getTransformedVertices(), translationVector);
    }

    //TODO faire la methode maison je crois
    public static boolean rectangles(Rectangle rectangle1, Rectangle rectangle2, Intersector.MinimumTranslationVector translationVector) {
        translationVector.normal.setZero();
        if (RectangleUtils.overlapsStick(rectangle1, rectangle2)) {
            Intersector.overlapConvexPolygons(RectangleUtils.getAsVertices(rectangle1, tmpVerticesArray), RectangleUtils.getAsVertices(rectangle2, tmp2VerticesArray), translationVector);
            return true;
        }

        return false;
    }

    //TODO group tmp
    private static final Vector2 tmp1 = new Vector2();
    private static final Vector2 tmp2 = new Vector2();
    private static final Vector2 tmp3 = new Vector2();

    public static Vector2 contactPoint(Rectangle rect1, Rectangle rect2) {
        RectangleUtils.getCenter(rect1, tmp1);
        RectangleUtils.getCenter(rect2, tmp2);

        V2.directionTo(tmp1, tmp2, tmp3);


        return null;
    }
}
