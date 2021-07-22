package com.nzt.gdx.math.shapes.utils;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shapes.Segment2D;

//TODO groupé les math tmpV vector segment ect
public class RectangleUtils {

    private static final Vector2 tmpV = new Vector2();
    private static final Segment2D tmpSegment = new Segment2D();

    /**
     * D-----C
     * -------
     * A-----B
     */
    private RectangleUtils() {
    }

    public static Vector2 getA(Rectangle rect, Vector2 pos) {
        return pos.set(rect.x, rect.y);
    }

    public static Vector2 getB(Rectangle rect, Vector2 pos) {
        return pos.set(rect.x + rect.width, rect.y);
    }

    public static Vector2 getC(Rectangle rect, Vector2 pos) {
        return pos.set(rect.x + rect.width, rect.y + rect.height);
    }

    public static Vector2 getD(Rectangle rect, Vector2 pos) {
        return pos.set(rect.x, rect.y + rect.height);
    }

    public static int getClosestVertex(Rectangle rect, float x, float y, Vector2 vertexPos) {
        int vertextClosest = getClosestVertex(rect, x, y);
        if (vertextClosest == 1) {
            getA(rect, vertexPos);
        } else if (vertextClosest == 2) {
            getB(rect, vertexPos);
        } else if (vertextClosest == 3) {
            getC(rect, vertexPos);
        } else if (vertextClosest == 4) {
            getD(rect, vertexPos);
        }
        return vertextClosest;
    }

    /**
     * return the closest point on edge
     */
    public static Vector2 getNearestPoint(Rectangle rectangle, Vector2 point, Vector2 result) {
        Vector2 nearestPoint = result;
        Vector2 nearestPointTmp = tmpV;

        Segment2D horizontalBot = RectangleUtils.getHorizontalBot(rectangle, tmpSegment);
        Segment2DUtils.nearestPoint(horizontalBot, point, result);

        Segment2D horizontalTop = RectangleUtils.getHorizontalTop(rectangle, tmpSegment);
        Segment2DUtils.nearestPoint(horizontalTop, point, nearestPointTmp);
        if (nearestPointTmp.dst2(point) < nearestPoint.dst2(point)) {
            nearestPoint.set(nearestPointTmp);
        }

        Segment2D verticalLeft = RectangleUtils.getVerticalLeft(rectangle, tmpSegment);
        Segment2DUtils.nearestPoint(verticalLeft, point, nearestPointTmp);
        if (nearestPointTmp.dst2(point) < nearestPoint.dst2(point)) {
            nearestPoint.set(nearestPointTmp);
        }

        Segment2D verticalRight = RectangleUtils.getVerticalRight(rectangle, tmpSegment);
        Segment2DUtils.nearestPoint(verticalRight, point, nearestPointTmp);
        if (nearestPointTmp.dst2(point) < nearestPoint.dst2(point)) {
            nearestPoint.set(nearestPointTmp);
        }
        return nearestPoint;
    }

    public static int getClosestVertex(Rectangle rect, float x, float y) {
        int nb = 1;
        float dstA = getA(rect, tmpV).dst2(x, y);
        float closest = dstA;

        float dstB = getB(rect, tmpV).dst2(x, y);
        if (dstB < closest) {
            closest = dstB;
            nb = 2;
        }

        float dstC = getC(rect, tmpV).dst2(x, y);
        if (dstC < closest) {
            closest = dstC;
            nb = 3;
        }
        float dstD = getD(rect, tmpV).dst2(x, y);
        if (dstD < closest) {
            nb = 4;
        }
        return nb;
    }

    public static Vector2 getCenter(Rectangle rect, Vector2 center) {
        return center.set(rect.x + rect.width / 2, rect.y + rect.height / 2);
    }

    public static void setPosWithCenter(Rectangle rect, Vector2 pos) {
        setPosWithCenter(rect, pos.x, pos.y);
    }

    public static void setPosWithCenter(Rectangle rect, float x, float y) {
        rect.x = x - rect.width / 2;
        rect.y = y - rect.height / 2;
    }

    public static Rectangle createFromCenter(float x, float y, float width, float height) {
        Rectangle rect = new Rectangle(x - width / 2, y - height / 2, width, height);
        return rect;
    }

    public static Rectangle createFromCenter(Vector2 pos, float width, float height) {
        return createFromCenter(pos.x, pos.y, width, height);
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

    public static boolean isVertex(Rectangle rect, Vector2 point) {
        if (point.x == rect.x && point.y == rect.y)
            return true;
        if (point.x == rect.x + rect.width && point.y == rect.y)
            return true;
        if (point.x == rect.x && point.y == rect.y + rect.height)
            return true;
        return point.x == rect.x + rect.width && point.y == rect.y + rect.height;
    }


    public static Segment2D getHorizontalBot(Rectangle rect, Segment2D segment) {
        segment.set(rect.x, rect.y, rect.x + rect.width, rect.y);
        return segment;
    }

    public static Segment2D getHorizontalTop(Rectangle rect, Segment2D segment) {
        float aX = rect.x;
        float aY = rect.y + rect.height;
        float bX = rect.x + rect.width;
        float bY = rect.y + rect.height;
        segment.set(aX, aY, bX, bY);
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

    public static float[] getAsVertices(Rectangle rect) {
        return getAsVertices(rect, new float[8]);
    }

    public static float[] getAsVertices(Rectangle rect, float[] vertices) {
        vertices[0] = rect.x;
        vertices[1] = rect.y;
        vertices[2] = rect.x + rect.width;
        vertices[3] = rect.y;
        vertices[4] = rect.x + rect.width;
        vertices[5] = rect.y + rect.height;
        vertices[6] = rect.x;
        vertices[7] = rect.y + rect.height;
        return vertices;
    }

}
