package com.nzt.gdx.math.intersectors;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shape.Segment2D;
import com.nzt.gdx.math.shape.utils.Segment2DUtils;
import com.nzt.gdx.math.vectors.VectorUtils;

public class IntersectorSegmentRectangle {

    private static Vector2 tmp1 = new Vector2();
    private static Vector2 tmp2 = new Vector2();
    private static Vector2 tmp3 = new Vector2();
    private static Vector2 tmp4 = new Vector2();

    private static Segment2D tmpSeg = new Segment2D();

    public static boolean intersectSegmentRectangleFarthest(Segment2D segment, Rectangle rectangle, Vector2 intersection) {
        return true;
    }

    public boolean instersectVerticalRight(Segment2D segment, Rectangle rect, Vector2 intersection) {
        float rectangleEndY = rect.y + rect.height;
        tmpSeg.set(rect.x, rect.y, rect.x, rectangleEndY);
        return Segment2DUtils.getSegmentIntersection(segment, tmpSeg, intersection);
    }

    public boolean instersectHorizontalBot(Segment2D segment, Rectangle rect, Vector2 intersection) {
        float rectangleEndX = rect.x + rect.width;
        tmpSeg.set(rect.x, rect.y, rectangleEndX, rect.y);
        return Segment2DUtils.getSegmentIntersection(segment, tmpSeg, intersection);
    }

    public boolean instersectVecticalRight(Segment2D segment, Rectangle rect, Vector2 intersection) {
        float rectangleEndX = rect.x + rect.width;
        float rectangleEndY = rect.y + rect.height;
        tmpSeg.set(rectangleEndX, rect.y, rectangleEndX, rectangleEndY);
        return Segment2DUtils.getSegmentIntersection(segment, tmpSeg, intersection);
    }

    public boolean instersectHorizontalTop(Segment2D segment, Rectangle rect, Vector2 intersection) {
        float rectangleEndX = rect.x + rect.width;
        float rectangleEndY = rect.y + rect.height;
        tmpSeg.set(rect.x, rectangleEndY, rectangleEndX, rectangleEndY);
        return Segment2DUtils.getSegmentIntersection(segment, tmpSeg, intersection);
    }

    public static boolean intersectSegmentRectangleClosest(Segment2D segment, Rectangle rect, Vector2 intersection) {
        int intersectionCount = 0;
        boolean touch1, touch2, touch3, touch4;
        float rectangleEndX = rect.x + rect.width;
        float rectangleEndY = rect.y + rect.height;

        if (Intersector.intersectSegments(segment.a.x, segment.a.y, segment.b.x, segment.b.y, rect.x, rect.y, rect.x, rectangleEndY, tmp1)) {
            intersectionCount++;
            touch1 = true;
        }
        if (Intersector.intersectSegments(segment.a.x, segment.a.y, segment.b.x, segment.b.y, rect.x, rect.y, rectangleEndX, rect.y, tmp2)) {
            intersectionCount++;
            touch2 = true;
        }
        if (intersectionCount > 2) {
            intersection = VectorUtils.getClosest(tmp1, tmp2);
            return true;
        }
        if (Intersector.intersectSegments(segment.a.x, segment.a.y, segment.b.x, segment.b.y, rectangleEndX, rect.y, rectangleEndX, rectangleEndY, tmp3)) {
            intersectionCount++;
        }
        if (intersectionCount > 2) {
            intersection = VectorUtils.getClosest(tmp1, tmp2);
            return true;
        }

        if (Intersector.intersectSegments(segment.a.x, segment.a.y, segment.b.x, segment.b.y, rect.x, rectangleEndY, rectangleEndX, rectangleEndY, tmp4)) {
            intersectionCount++;
        }
        if (intersectionCount > 2) {
            intersection = VectorUtils.getClosest(tmp1, tmp2);
            return true;
        }
        return true;

        return rect.contains(startX, startY);
    }
}
