package com.nzt.gdx.math.nzshape2d;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.graphics.renderers.NzShapeRenderer;

public class NzCircle extends Circle implements NzShape2D {

    public NzCircle() {
    }

    public NzCircle(float x, float y, float radius) {
        super(x, y, radius);
    }

    public NzCircle(Vector2 position, float radius) {
        super(position, radius);
    }

    public NzCircle(Circle circle) {
        super(circle);
    }

    public NzCircle(Vector2 center, Vector2 edge) {
        super(center, edge);
    }

    @Override
    public Vector2 getPosition(Vector2 v) {
        return v.set(x, y);
    }

    @Override
    public void updatePosition(Vector2 position) {
        this.setPosition(position);
    }

    @Override
    public void updatePosition(float x, float y) {
        this.setPosition(x, y);
    }

    @Override
    public void render(NzShapeRenderer nzShapeRenderer) {
        nzShapeRenderer.circle(this);
    }

    @Override
    public float getXMax() {
        return this.x + this.radius;
    }

    @Override
    public float getXMaxShape() {
        return this.radius;
    }

    @Override
    public float getXMin() {
        return this.x - this.radius;
    }

    @Override
    public float getXMinShape() {
        return -this.radius;
    }

    @Override
    public float getYMax() {
        return this.y + this.radius;
    }

    @Override
    public float getYMaxShape() {
        return this.radius;
    }

    @Override
    public float getYMin() {
        return this.y - this.radius;
    }

    @Override
    public float getYMinShape() {
        return this.radius;
    }
}
