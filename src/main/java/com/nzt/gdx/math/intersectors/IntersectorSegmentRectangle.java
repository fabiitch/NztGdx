package com.nzt.gdx.math.intersectors;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.math.shape.Segment2D;
import com.nzt.gdx.math.shape.utils.Segment2DUtils;
import com.nzt.gdx.math.vectors.VectorUtils;

public class IntersectorSegmentRectangle {

    //TODO a voir les static pour mettre sur des pools
    private static Vector2 tmp1 = new Vector2();
    private static Vector2 tmp2 = new Vector2();
    private static Vector2 tmp3 = new Vector2();
    private static Vector2 tmp4 = new Vector2();

    private static Array<Vector2> arrayTmp = new Array<>(4);

    private static Segment2D tmpSeg = new Segment2D();

    public static boolean intersectSegmentRectangleFarthest(Segment2D segment, Rectangle rectangle, Vector2 intersection) {
        return intersectSegmentRectangle(segment, rectangle, intersection, false);
    }

    public static boolean intersectSegmentRectangleClosest(Segment2D segment, Rectangle rectangle, Vector2 intersection) {
        return intersectSegmentRectangle(segment, rectangle, intersection, true);
    }

    private static boolean intersectSegmentRectangle(Segment2D segment, Rectangle rect, Vector2 intersection, boolean closest) {
        int intersectionCount = 0;
        if (instersectVerticalLeft(segment, rect, tmp1)) {
            intersectionCount++;
            arrayTmp.add(tmp1);
        }
        if (instersectHorizontalBot(segment, rect, tmp2)) {
            intersectionCount++;
            arrayTmp.add(tmp2);
        }

        if (intersectionCount >= 2) {
            intersection.set(closest ? VectorUtils.getClosest(segment.a, arrayTmp) : VectorUtils.getFarthest(segment.a, arrayTmp));
            return true;
        }

        if (instersectVercticalRight(segment, rect, tmp3)) {
            intersectionCount++;
            arrayTmp.add(tmp3);
        }

        if (intersectionCount >= 2) {
            intersection.set(closest ? VectorUtils.getClosest(segment.a, arrayTmp) : VectorUtils.getFarthest(segment.a, arrayTmp));
            return true;
        }
        if (instersectHorizontalTop(segment, rect, tmp4)) {
            intersectionCount++;
            arrayTmp.add(tmp4);
        }
        if (intersectionCount > 0)
            intersection.set(closest ? VectorUtils.getClosest(segment.a, arrayTmp) : VectorUtils.getFarthest(segment.a, arrayTmp));

        return intersectionCount > 0;

    }

    public static boolean instersectVerticalLeft(Segment2D segment, Rectangle rect, Vector2 intersection) {
        float rectangleEndY = rect.y + rect.height;
        tmpSeg.set(rect.x, rect.y, rect.x, rectangleEndY);
        return Segment2DUtils.getSegmentIntersection(segment, tmpSeg, intersection);
    }

    public static boolean instersectHorizontalBot(Segment2D segment, Rectangle rect, Vector2 intersection) {
        float rectangleEndX = rect.x + rect.width;
        tmpSeg.set(rect.x, rect.y, rectangleEndX, rect.y);
        return Segment2DUtils.getSegmentIntersection(segment, tmpSeg, intersection);
    }

    public static boolean instersectVercticalRight(Segment2D segment, Rectangle rect, Vector2 intersection) {
        float rectangleEndX = rect.x + rect.width;
        float rectangleEndY = rect.y + rect.height;
        tmpSeg.set(rectangleEndX, rect.y, rectangleEndX, rectangleEndY);
        return Segment2DUtils.getSegmentIntersection(segment, tmpSeg, intersection);
    }

    public static boolean instersectHorizontalTop(Segment2D segment, Rectangle rect, Vector2 intersection) {
        float rectangleEndX = rect.x + rect.width;
        float rectangleEndY = rect.y + rect.height;
        tmpSeg.set(rect.x, rectangleEndY, rectangleEndX, rectangleEndY);
        return Segment2DUtils.getSegmentIntersection(segment, tmpSeg, intersection);
    }
}
