package com.nzt.gdx.math.shapes;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shapes.utils.SegmentUtils;

import java.util.Objects;

//TODO remove pour voir avec Polyline
public class Segment implements Shape2D{//TODO remove vector //TODO viré par polyline
    public Vector2 a;
    public Vector2 b;

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

    public Vector2 nearestPoint(Vector2 point, Vector2 result) {
        return SegmentUtils.nearestPoint(this, point, result);
    }

    public boolean intersectRectangle(Rectangle rect, Vector2 intersectionPoint) {//TODO ??
        return Intersector.intersectSegmentRectangle(this.a, this.b, rect);
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

    public Vector2 getNormale(Vector2 normal) {
        Vector2 dir = getDir(normal);
        float newX = -dir.y;
        float newY = dir.x;
        return normal.set(newX,newY);
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
