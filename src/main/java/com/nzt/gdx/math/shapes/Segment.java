package com.nzt.gdx.math.shapes;

import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shapes.utils.CircleUtils;
import com.nzt.gdx.math.shapes.utils.SegmentUtils;
import com.nzt.gdx.math.vectors.V2;

import java.util.Objects;

public class Segment implements Shape2D {

    private final static Vector2 tmpv1 = new Vector2(); //TODO groups pools
    private final static Vector2 tmpv2 = new Vector2(); //TODO groups pools
    public Vector2 a;
    public Vector2 b;
    public float rotation;

    public Segment() {
        this.a = new Vector2();
        this.b = new Vector2();
    }

    public Segment(Vector2 a, Vector2 b) {
        this.a = a;
        this.b = b;
    }

    public Segment(float aX, float aY, float bX, float bY) {
        this.a = new Vector2(aX, aY);
        this.b = new Vector2(bX, bY);
    }

    public void setRotation(float degrees) {
        this.rotation = degrees;
        getMiddle(tmpv1);
        a.set(CircleUtils.posWithAngleDeg(tmpv1, getDst() / 2, degrees, tmpv2));
        b.set(CircleUtils.posWithAngleDeg(tmpv1, getDst() / 2, degrees+180, tmpv2));
    }

    public void rotate(float degrees) {
        rotation += degrees;
        setRotation(rotation);
    }

    public Vector2 nearestPoint(Vector2 point, Vector2 result) {
        return SegmentUtils.nearestPoint(this, point, result);
    }

    public Vector2 getDir(Vector2 dir) {
        float dx = b.x - a.x;
        float dy = b.y - a.y;
        return dir.set(dx, dy).nor();
    }

    public Vector2 getMiddle(Vector2 result) {
        return result.set((a.x + b.x) / 2, (a.y + b.y) / 2);
    }

    public float getDst() {
        return a.dst(b);
    }

    /**
     * Normal orienté du coté du point
     */
    public Vector2 getNormal(Vector2 point, Vector2 normal) {
        Vector2 middle = getMiddle(tmpv1);
        getNormal(normal);
        V2.directionTo(middle, point, tmpv2);

        if (tmpv2.hasOppositeDirection(normal))
            normal.rotateDeg(180);
        return normal;
    }

    public Vector2 getNormal(Vector2 normal) {
        Vector2 dir = getDir(normal);
        float newX = -dir.y;
        float newY = dir.x;
        return normal.set(newX, newY);
    }

    public void set(float aX, float aY, float bX, float bY) {
        setA(aX, aY);
        setB(bX, bY);
    }

    public void set(Vector2 a, Vector2 b) {
        this.a.set(a);
        this.b.set(b);
    }

    public void set(Segment segment2D) {
        this.a = segment2D.a;
        this.b = segment2D.b;
    }

    public void setA(Vector2 a) {
        this.a.set(a);
    }

    public void setA(float aX, float aY) {
        this.a.set(aX, aY);
    }

    public void setB(Vector2 b) {
        this.b.set(b);
    }

    public void setB(float bX, float bY) {
        this.b.set(bX, bY);
    }

    @Override
    public String toString() {
        return "Segment2D{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Segment segment2D = (Segment) o;
        return Objects.equals(a, segment2D.a) &&
                Objects.equals(b, segment2D.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public boolean contains(Vector2 point) {
        return false;
    }

    @Override
    public boolean contains(float x, float y) {
        return false;
    }
}
