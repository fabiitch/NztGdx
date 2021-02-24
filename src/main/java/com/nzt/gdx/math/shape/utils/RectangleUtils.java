package com.nzt.gdx.math.shape.utils;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shape.Segment2D;

public class RectangleUtils {

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

    public static boolean isVertex(Rectangle rect, Vector2 point) {
        if (point.x == rect.x && point.y == rect.y)
            return true;
        if (point.x == rect.x + rect.width && point.y == rect.y)
            return true;
        if (point.x == rect.x && point.y == rect.y + rect.height)
            return true;
        if (point.x == rect.x + rect.width && point.y == rect.y + rect.height)
            return true;
        return false;
    }

    public static Segment2D getHorizontalTop(Rectangle rect, Segment2D segment) {
        float aX = rect.x;
        float aY = rect.y + rect.height;
        float bX = rect.x + rect.width;
        float bY = rect.y + rect.height;
        segment.set(aX, aY, bX, bY);
        return segment;
    }

    public static Segment2D getHorizontalBot(Rectangle rect, Segment2D segment) {
        segment.set(rect.x, rect.y, rect.x + rect.width, rect.y);
        return segment;
    }

    public static Segment2D getVerticalLeft(Rectangle rect, Segment2D segment) {
        segment.set(rect.x, rect.y, rect.x, rect.y + rect.height);
        return segment;
    }

    public static Segment2D getVerticalRight(Rectangle rect, Segment2D segment) {
        segment.set(rect.x + rect.width, rect.y, rect.x + rect.width, rect.y + rect.height);
        return segment;
    }
}
