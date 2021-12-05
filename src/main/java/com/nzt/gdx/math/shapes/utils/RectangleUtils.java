package com.nzt.gdx.math.shapes.utils;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.AngleUtils;
import com.nzt.gdx.math.NzMath;
import com.nzt.gdx.math.shapes.Segment;

//TODO groupé les math tmpV1 vector segment ect

/**
 * D-----C
 * -------
 * A-----B
 */
public class RectangleUtils {

    private static final Vector2 tmpV1 = new Vector2();
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
        getC(rect, segment.a);
        getD(rect, segment.b);
        return segment;
    }

    public static Segment getAD(Rectangle rect, Segment segment) {
        getA(rect, segment.a);
        getD(rect, segment.b);
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
        return new Rectangle(centerX - width / 2, centerY - height / 2, width, height);
    }

    public static Rectangle createFromCenter(Vector2 center, float width, float height) {
        return createFromCenter(center.x, center.y, width, height);
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

    public static Segment closestEdge(Rectangle rectangle, Segment segment, Segment result) {
        float dstMin, newDstCompare;

        Segment horizontalBot = RectangleUtils.getHorizontalBot(rectangle, result);
        dstMin = SegmentUtils.dstMin(horizontalBot, segment);
        if (NzMath.isZero(dstMin)) {
            return result;
        }

        Segment horizontalTop = RectangleUtils.getHorizontalTop(rectangle, tmpSegment);
        newDstCompare = SegmentUtils.dstMin(horizontalTop, segment);
        if (newDstCompare < dstMin) {
            if (NzMath.isZero(newDstCompare))
                return result.set(horizontalTop);
            dstMin = newDstCompare;
            result.set(horizontalTop);
        }

        Segment verticalRight = RectangleUtils.getVerticalRight(rectangle, tmpSegment);
        newDstCompare = SegmentUtils.dstMin(verticalRight, segment);
        if (newDstCompare < dstMin) {
            if (NzMath.isZero(newDstCompare))
                return result.set(verticalRight);
            dstMin = newDstCompare;
            result.set(verticalRight);
        }

        Segment verticalLeft = RectangleUtils.getVerticalLeft(rectangle, tmpSegment);
        newDstCompare = SegmentUtils.dstMin(verticalLeft, segment);
        if (newDstCompare < dstMin) {
            result.set(verticalLeft);
        }

        return result;
    }

    public static Segment closestEdge(Rectangle rectangle, Vector2 point, Segment result) {
        float minDst2, newDst2;
        Vector2 nextPointToTest = tmpV1;

        Segment horizontalBot = RectangleUtils.getHorizontalBot(rectangle, tmpSegment);
        SegmentUtils.closestPoint(horizontalBot, point, nextPointToTest);
        result.set(horizontalBot);
        minDst2 = nextPointToTest.dst2(point);
        if (NzMath.isZero(minDst2))
            return result;

        Segment horizontalTop = RectangleUtils.getHorizontalTop(rectangle, tmpSegment);
        SegmentUtils.closestPoint(horizontalTop, point, nextPointToTest);
        newDst2 = nextPointToTest.dst2(point);
        if (NzMath.isZero(minDst2))
            return result.set(horizontalTop);
        if (newDst2 < minDst2) {
            result.set(horizontalTop);
            minDst2 = newDst2;
        }

        Segment verticalLeft = RectangleUtils.getVerticalLeft(rectangle, tmpSegment);
        SegmentUtils.closestPoint(verticalLeft, point, nextPointToTest);
        newDst2 = nextPointToTest.dst2(point);
        if (NzMath.isZero(minDst2))
            return result.set(verticalLeft);
        if (newDst2 < minDst2) {
            result.set(verticalLeft);
            minDst2 = newDst2;
        }

        Segment verticalRight = RectangleUtils.getVerticalRight(rectangle, tmpSegment);
        SegmentUtils.closestPoint(verticalRight, point, nextPointToTest);
        newDst2 = nextPointToTest.dst2(point);
        if (newDst2 < minDst2)
            return result.set(verticalRight);

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

    public static boolean isCenter(Rectangle rect, Vector2 pos) {
        return MathUtils.isEqual(rect.x + rect.width / 2, pos.x)
                && MathUtils.isEqual(rect.y + rect.height / 2, pos.y);
    }

    public static boolean isPosA(Rectangle rect, Vector2 pos) {
        return MathUtils.isEqual(rect.x, pos.x)
                && MathUtils.isEqual(rect.y, pos.y);
    }

    public static boolean isPosB(Rectangle rect, Vector2 pos) {
        return MathUtils.isEqual(rect.x + rect.width, pos.x)
                && MathUtils.isEqual(rect.y, pos.y);
    }

    public static boolean isPosC(Rectangle rect, Vector2 pos) {
        return MathUtils.isEqual(rect.x + rect.width, pos.x)
                && MathUtils.isEqual(rect.y + rect.width, pos.y);
    }

    public static boolean isPosD(Rectangle rect, Vector2 pos) {
        return MathUtils.isEqual(rect.x, pos.x)
                && MathUtils.isEqual(rect.y + rect.width, pos.y);
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

    /**
     * clockwise
     */
    public static float[] getAsVertices(Rectangle rect, float[] vertices) {
        vertices[0] = rect.x;
        vertices[1] = rect.y;

        vertices[2] = rect.x;
        vertices[3] = rect.y + rect.height;

        vertices[4] = rect.x + rect.width;
        vertices[5] = rect.y + rect.height;

        vertices[6] = rect.x + rect.width;
        vertices[7] = rect.y;
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

    public static Rectangle floorCeil(Rectangle rect) {
        return rect.set(MathUtils.floor(rect.x), MathUtils.floor(rect.y),
                MathUtils.ceil(rect.width), MathUtils.ceil(rect.height));
    }

    public static Rectangle mergeFloorCeil(Rectangle root, Rectangle other) {
        float minX = (float) Math.floor(Math.min(root.x, other.x));
        float maxX = (float) Math.ceil(Math.max(root.x + root.width, other.x + other.width));
        root.x = minX;
        root.width =  maxX - minX;

        float minY = (float) Math.floor(Math.min(root.y, other.y));
        float maxY = (float) Math.ceil(Math.max(root.y + root.height, other.y + other.height));
        root.y = minY;
        root.height = maxY - minY;
        return root;
    }

    public static boolean containsStick(Rectangle rectA, Rectangle rectB) {
        float xMinA = rectA.x, xMaxA = xMinA + rectA.width;
        float yMinA = rectA.y, yMaxA = yMinA + rectA.height;

        float xMinB = rectB.x, xMaxB = xMinB + rectB.width;
        float yMinB = rectB.y, yMaxB = yMinB + rectB.height;

        return ((xMinB >= xMinA && xMinB <= xMaxA) && (xMaxB >= xMinA && xMaxB <= xMaxA))
                && ((yMinB >= yMinA && yMinB <= yMaxA) && (yMaxB >= yMinA && yMaxB <= yMaxA));
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

    /**
     * 1-8 = out
     * 9-12 = inside
     * 13 = center
     */
    public static int getRegion(Rectangle rect, Vector2 position) {
        int pos = getRegionOutside(rect, position);
        if (pos == 0)
            pos = getRegionInside(rect, position) + 8;
        return pos;
    }

    /**
     * 0 = outside
     * 5 = center
     * ________
     * | 4 | 3 |
     * |_1_|_2_|
     */
    public static int getRegionInside(Rectangle rect, Vector2 position) {
        float x = position.x, y = position.y;
        float midX = rect.x + rect.width / 2, midY = rect.y + rect.height / 2;
        if (!rect.contains(x, y))
            return 0;
        if (isCenter(rect, tmpV1.set(x, y)))
            return 5;
        if (x > midX) {
            if (y > midY)
                return 3;
            else
                return 2;
        } else if (y > midY)
            return 4;
        else
            return 1;
    }

    /**
     * Renvoi la order relative au rect
     * 0 = inside
     * 4 |  3 | 2
     * __|____|__
     * 5 |  0 | 1
     * __|____|___
     * 6 |  7 | 8
     */
    public static int getRegionOutside(Rectangle rect, Vector2 position) {
        float x = position.x, y = position.y;
        int result = 0;
        float rectX = rect.x, rectY = rect.y;
        if (x < rectX) {
            result = 5;
            if (y < rectY)
                result = 6;
            else if (y > rectY + rect.height)
                result = 4;
        } else if (x > rectX + rect.width) {
            result = 1;
            if (y < rectY)
                result = 8;
            else if (y > rectY + rect.height)
                result = 2;
        } else {
            if (y < rectY)
                result = 7;
            else if (y > rectY + rect.height)
                result = 3;
        }
        return result;
    }


    /**
     * intersection between ray from center and edge
     */
//    public static Vector2 posOnEdgeAngle(Rectangle rect, float angleDeg, Vector2 result) {
//        angleDeg = Math.abs(angleDeg % 45);
//        Segment edgeWithAngle = getEdgeWithAngle(rect, angleDeg, tmpSegment);
//        float hypoLen = TriangleRectUtils.hypoFromAdjacent(edgeWithAngle.dst(tmpV1) / 2, angleDeg);
//
//        result = getCenter(rect, result);
//        result.add(tmpV1.set(hypoLen, 0).setAngleDeg(angleDeg));
//
//        return result;
//    }

    //https://stackoverflow.com/questions/4061576/finding-points-on-a-rectangle-at-a-given-angle
//    public static Vector2 posOnEdgeAngle(Rectangle rect, float angleRad, Vector2 result)
//    {
//        float theta = AngleUtils.normaliseRad02Pi(angleRad);
//        float diag = MathUtils.atan2(rect.height, rect.width);
//        float tangent = (float)Math.tan(angleRad);
//
//        if (theta > -diag && theta <= diag)
//        {
//            result.x = rect.width / 2f;
//            result.y = rect.width / 2f * tangent;
//        }
//        else if(theta > diag && theta <= MathUtils.PI - diag)
//        {
//            result.x = rect.height / 2f / tangent;
//            result.y = rect.height / 2f;
//        }
//        else if(theta > MathUtils.PI - diag && theta <= MathUtils.PI + diag)
//        {
//            result.x = -rect.width / 2f;
//            result.y = -rect.width / 2f * tangent;
//        }
//        else
//        {
//            result.x = -rect.height / 2f / tangent;
//            result.y = -rect.height / 2f;
//        }
//
//        return result;
//    }
}
