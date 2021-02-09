package com.nzt.gdx.math.shape.utils;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shape.Segment2D;
import com.nzt.gdx.math.vectors.VectorUtils;

public class RectangleUtils {

    public static Vector2 getCenter(Rectangle rect) {
        return new Vector2(rect.x + rect.width / 2, rect.y + rect.height / 2);
    }

    public static Rectangle allToPPM(Rectangle rect, float PPM) {
        sizeToPPM(rect, PPM);
        posToPPM(rect, PPM);
        return rect;
    }

    public static Rectangle sizeToPPM(Rectangle rect, float PPM) {
        rect.setWidth(rect.width / PPM);
        rect.setHeight(rect.height / PPM);
        return rect;
    }

    public static Rectangle posToPPM(Rectangle rect, float PPM) {
        rect.setX(rect.x / PPM);
        rect.setY(rect.y / PPM);
        return rect;
    }

    public static Segment2D getHorizontalTop(Rectangle rect) {
        float aX = rect.x;
        float aY = rect.y + rect.height;
        float bX = rect.x + rect.width;
        float bY = rect.y + rect.height;
        return new Segment2D(aX, aY, bX, bY);
    }

    public static Segment2D getHorizontalBot(Rectangle rect) {
        return new Segment2D(rect.x, rect.y, rect.x + rect.width, rect.y);
    }

    public static Segment2D getVerticalLeft(Rectangle rect) {
        return new Segment2D(rect.x, rect.y, rect.x, rect.y + rect.height);
    }

    public static Segment2D getVerticalRight(Rectangle rect) {
        return new Segment2D(rect.x + rect.width, rect.y, rect.x + rect.width, rect.y + rect.height);
    }


    public static Segment2D getClosestSegmentIntersection(Segment2D segment, Rectangle rect, Vector2 closestIntersection) {
        return getClosestSegmentIntersection(segment.a, segment.b, rect, closestIntersection, true);
    }

    /**
     * @return the closest segment to A point intersect rectangle of segment AB
     */
    public static Segment2D getClosestSegmentIntersection(Segment2D segment, Rectangle rect, Vector2 closestIntersection, boolean checkIntersection) {
        return getClosestSegmentIntersection(segment.a, segment.b, rect, closestIntersection, checkIntersection);
    }

    public static Segment2D getClosestSegmentIntersection(Vector2 p1Start, Vector2 p1End, Rectangle rect, Vector2 closestIntersection) {
        return getClosestSegmentIntersection(p1Start, p1End, rect, closestIntersection, true);
    }

    /**
     * //TODO a revoir je crois
     * @return the closest to A point intersect rectangle of segment AB
     * Vector2 closestIntersection contains intersection point
     */
    public static Segment2D getClosestSegmentIntersection(Vector2 p1Start, Vector2 p1End, Rectangle rect, Vector2
            closestIntersection, boolean checkIntersection) {
        if (checkIntersection) {
            if (!Intersector.intersectSegmentRectangle(p1Start, p1End, rect)) {
                return null;
            }
        }
        Segment2D segment1 = new Segment2D(p1Start, p1End);
        Segment2D horizontalTop = RectangleUtils.getHorizontalTop(rect);
        Vector2 interHorizontalTop = Segment2DUtils.getSegmentIntersection(segment1, horizontalTop);

        Segment2D horizontalBot = RectangleUtils.getHorizontalBot(rect);
        Vector2 interHorizontalBot = Segment2DUtils.getSegmentIntersection(segment1, horizontalBot);

        Segment2D verticalRight = RectangleUtils.getVerticalRight(rect);
        Vector2 interVerticalRight = Segment2DUtils.getSegmentIntersection(segment1, verticalRight);

        Segment2D verticalLeft = RectangleUtils.getVerticalLeft(rect);
        Vector2 interVerticalLeft = Segment2DUtils.getSegmentIntersection(segment1, verticalLeft);

        if (closestIntersection != null) {
            //TODO  closest devrait pas etre nul avec le check en haut
            Vector2 closest = VectorUtils.getClosest(p1Start, interHorizontalTop, interHorizontalBot, interVerticalRight, interVerticalLeft);
            if (closest != null)
                closestIntersection.set(closest);
        } else {
            return null;
        }
        if (closestIntersection.equals(interHorizontalTop)) {
            return horizontalTop;
        } else if (closestIntersection.equals(interHorizontalBot)) {
            return horizontalBot;
        } else if (closestIntersection.equals(interVerticalRight)) {
            return verticalRight;
        } else if (closestIntersection.equals(interVerticalLeft)) {
            return verticalLeft;
        }
        return null;
    }


}
