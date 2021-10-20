package com.nzt.gdx.math.shapes.utils;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.AngleUtils;
import com.nzt.gdx.math.shapes.Segment;
import com.nzt.gdx.math.vectors.V2;
import org.graalvm.compiler.loop.MathUtil;

//TODO groupé les math tmpV1 vector segment ect

/**
 * D-----C
 * -------
 * A-----B
 */
public class RectangleUtils {

    private static final Vector2 tmpV1 = new Vector2();
    private static final Vector2 tmpV2 = new Vector2();
    private static final Segment tmpSegment = new Segment();

    /**
     * D3-----C2
     * |------|
     * |------|
     * A0-----B1
     */
    private RectangleUtils() {
    }

    public static Vector2 getVertex(Rectangle rect, int vertexNum, Vector2 result) {
        vertexNum %= 4;
        if (vertexNum == 0) {
            return getA(rect, result);
        }
        if (vertexNum == 1) {
            return getB(rect, result);
        }
        if (vertexNum == 2) {
            return getC(rect, result);
        }
        return getD(rect, result);
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

    public static Segment getAB(Rectangle rect, Segment segment) {
        getA(rect, segment.a);
        getB(rect, segment.b);
        return segment;
    }

    public static Segment getBC(Rectangle rect, Segment segment) {
        getB(rect, segment.a);
        getC(rect, segment.b);
        return segment;
    }

    public static Segment getCD(Rectangle rect, Segment segment) {
        getC(rect, segment.b);
        getD(rect, segment.a);
        return segment;
    }

    public static Segment getAD(Rectangle rect, Segment segment) {
        getA(rect, segment.b);
        getD(rect, segment.a);
        return segment;
    }

    public static Vector2 getCenterAtZero(Rectangle rect, Vector2 center) {
        return center.set(rect.width / 2, rect.height / 2);
    }

    public static Vector2 getCenter(Rectangle rect, Vector2 center) {
        return center.set(rect.x + rect.width / 2, rect.y + rect.height / 2);
    }

    public static void setPosWithCenter(Rectangle rect, Vector2 newCenter) {
        setPosWithCenter(rect, newCenter.x, newCenter.y);
    }

    public static void setPosWithCenter(Rectangle rect, float newCenterX, float newCenterY) {
        rect.x = newCenterX - rect.width / 2;
        rect.y = newCenterY - rect.height / 2;
    }

    public static Rectangle createFromCenter(float centerX, float centerY, float width, float height) {
        Rectangle rect = new Rectangle(centerX - width / 2, centerY - height / 2, width, height);
        return rect;
    }

    public static Rectangle createFromCenter(Vector2 center, float width, float height) {
        return createFromCenter(center.x, center.y, width, height);
    }

    /**
     * intersection between ray from center and edge
     * TODO remove new (attention les tmp sont utilisé dans les sous methodes)
     */
    public static Vector2 posOnEdgeAngle(Rectangle rect, float angleRadian, Vector2 result) {
        Vector2 tmpCenter = getCenter(rect, new Vector2());
        Vector2 centerRect = V2.tmp(tmpCenter);
        Vector2 posDir = tmpCenter.add(tmpV2.set(getMaxWidthHeight(rect), 0).setAngleRad(angleRadian));

        Segment edgeRect = closestSegment(rect, posDir, new Segment());

        Segment rayFromCenter = new Segment(centerRect, posDir);

        boolean intersection = SegmentUtils.getSegmentIntersection(rayFromCenter, edgeRect, result);
        if (!intersection)
            result.setZero();
        return result;
    }

    /**
     * return the closest point on edge
     */
    public static Vector2 closestPoint(Rectangle rectangle, Vector2 point, Vector2 result) {
        Vector2 closestPoint = result;
        Vector2 closestPointTmp = tmpV1;

        Segment horizontalBot = RectangleUtils.getHorizontalBot(rectangle, tmpSegment);
        SegmentUtils.closestPoint(horizontalBot, point, result);

        Segment horizontalTop = RectangleUtils.getHorizontalTop(rectangle, tmpSegment);
        SegmentUtils.closestPoint(horizontalTop, point, closestPointTmp);
        if (closestPointTmp.dst2(point) < closestPoint.dst2(point)) {
            closestPoint.set(closestPointTmp);
        }

        Segment verticalLeft = RectangleUtils.getVerticalLeft(rectangle, tmpSegment);
        SegmentUtils.closestPoint(verticalLeft, point, closestPointTmp);
        if (closestPointTmp.dst2(point) < closestPoint.dst2(point)) {
            closestPoint.set(closestPointTmp);
        }

        Segment verticalRight = RectangleUtils.getVerticalRight(rectangle, tmpSegment);
        SegmentUtils.closestPoint(verticalRight, point, closestPointTmp);
        if (closestPointTmp.dst2(point) < closestPoint.dst2(point)) {
            closestPoint.set(closestPointTmp);
        }
        return closestPoint;
    }

    public static Segment closestSegment(Rectangle rectangle, Vector2 point, Segment result) {
        Vector2 closestPointTmp = tmpV1;
        Vector2 nextPoint = tmpV2;
        Segment horizontalBot = RectangleUtils.getHorizontalBot(rectangle, tmpSegment);
        SegmentUtils.closestPoint(horizontalBot, point, closestPointTmp);
        result.set(horizontalBot);

        Segment horizontalTop = RectangleUtils.getHorizontalTop(rectangle, tmpSegment);
        SegmentUtils.closestPoint(horizontalTop, point, nextPoint);
        if (nextPoint.dst2(point) < closestPointTmp.dst2(point)) {
            closestPointTmp.set(nextPoint);
            result.set(horizontalTop);
        }

        Segment verticalLeft = RectangleUtils.getVerticalLeft(rectangle, tmpSegment);
        SegmentUtils.closestPoint(verticalLeft, point, nextPoint);
        if (nextPoint.dst2(point) < closestPointTmp.dst2(point)) {
            closestPointTmp.set(nextPoint);
            result.set(verticalLeft);
        }

        Segment verticalRight = RectangleUtils.getVerticalRight(rectangle, tmpSegment);
        SegmentUtils.closestPoint(verticalRight, point, nextPoint);
        if (nextPoint.dst2(point) < closestPointTmp.dst2(point)) {
            closestPointTmp.set(nextPoint);
            result.set(verticalRight);
        }
        return result;
    }

    public static int getNumClosestVertex(Rectangle rect, float x, float y, Vector2 vertexPos) {
        int vertextClosest = getNumClosestVertex(rect, x, y);
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

    public static int getNumClosestVertex(Rectangle rect, float x, float y) {
        int nb = 0;
        float dstA = getA(rect, tmpV1).dst2(x, y);
        float closest = dstA;

        float dstB = getB(rect, tmpV1).dst2(x, y);
        if (dstB < closest) {
            closest = dstB;
            nb = 1;
        }

        float dstC = getC(rect, tmpV1).dst2(x, y);
        if (dstC < closest) {
            closest = dstC;
            nb = 2;
        }
        float dstD = getD(rect, tmpV1).dst2(x, y);
        if (dstD < closest) {
            nb = 3;
        }
        return nb;
    }

    public static int isVertex(Rectangle rect, Vector2 point) {
        if (isPosA(rect, point))
            return 0;
        if (isPosB(rect, point))
            return 1;
        if (isPosC(rect, point))
            return 2;
        if (isPosD(rect, point))
            return 3;
        return -1;
    }

    public static boolean isPosA(Rectangle rect, Vector2 pos) {
        return MathUtils.isEqual(rect.x, pos.x) && MathUtils.isEqual(rect.y, pos.y);
    }

    public static boolean isPosB(Rectangle rect, Vector2 pos) {
        return MathUtils.isEqual(rect.x + rect.width, pos.x) && MathUtils.isEqual(rect.y, pos.y);
    }

    public static boolean isPosC(Rectangle rect, Vector2 pos) {
        return MathUtils.isEqual(rect.x + rect.width, pos.x) && MathUtils.isEqual(rect.y + rect.width, pos.y);
    }

    public static boolean isPosD(Rectangle rect, Vector2 pos) {
        return MathUtils.isEqual(rect.x, pos.x) && MathUtils.isEqual(rect.y + rect.width, pos.y);
    }

    public static Segment getHorizontalBot(Rectangle rect, Segment segment) {
        segment.set(rect.x, rect.y, rect.x + rect.width, rect.y);
        return segment;
    }

    public static Segment getHorizontalTop(Rectangle rect, Segment segment) {
        float aX = rect.x;
        float aY = rect.y + rect.height;
        float bX = rect.x + rect.width;
        float bY = rect.y + rect.height;
        segment.set(aX, aY, bX, bY);
        return segment;
    }

    public static Segment getVerticalLeft(Rectangle rect, Segment segment) {
        segment.set(rect.x, rect.y, rect.x, rect.y + rect.height);
        return segment;
    }

    public static float getDiagDst(Rectangle rectangle) {
        return (float) Math.sqrt(rectangle.width * rectangle.width + rectangle.height * rectangle.height);
    }

    public static float dstVertexCenter(Rectangle rectangle) {
        return getDiagDst(rectangle) / 2;
    }

    public static Segment getVerticalRight(Rectangle rect, Segment segment) {
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

    public static float radiusCircleInside(Rectangle rectangle) {
        if (rectangle.width < rectangle.height)
            return rectangle.width / 2;
        else
            return rectangle.height / 2;
    }

    public static Circle getCircleInside(Rectangle rectangle) {
        return new Circle(getCenter(rectangle, tmpV1), radiusCircleInside(rectangle));
    }


    public static boolean overlapsStick(Rectangle rectA, Rectangle rectB) {
        return rectA.x <= rectB.x + rectB.width
                && rectA.x + rectA.width >= rectB.x
                && rectA.y <= rectB.y + rectB.height
                && rectA.y + rectA.height >= rectB.y;
    }

    public static float[] toVertices(Rectangle rect, boolean setCenterRect) {
        return toVertices(rect.width, rect.height, setCenterRect);
    }

    public static float[] toVertices(float width, float height, boolean setCenterRect) {
        float vertices[];
        if (setCenterRect) {
            vertices = new float[]{-width / 2, -height / 2, width / 2, -height / 2, width / 2, height / 2, -width / 2, height / 2};
        } else {
            vertices = new float[]{0, 0, width, 0, width, height, 0, height};
        }
        return vertices;
    }

    public static float getMaxWidthHeight(Rectangle rect) {
        return Math.max(rect.width, rect.height);
    }

    public static Segment getEdgeWithAngle(Rectangle rect, float angleDeg, Segment result) {
        float angle = AngleUtils.normaliseDeg(angleDeg);

        System.out.println(angle);
        if (angle >= 315 || angle < 45) {
            return getVerticalRight(rect, result);
        } else if (angle >= 45 && angle < 135) {
            return getHorizontalTop(rect, result);
        } else if (angle >= 135 && angle < 225) {
            return getVerticalLeft(rect, result);
        } else {
            return getHorizontalBot(rect, result);
        }
    }

}
