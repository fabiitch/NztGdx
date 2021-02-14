package com.nzt.gdx.math.nzshape2d;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.graphics.renderers.NzShapeRenderer;

public class NzRectangle extends Rectangle implements NzShape2D {
    public NzRectangle() {
        super();
    }

    public NzRectangle(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    public NzRectangle(Rectangle rect) {
        super(rect);
    }

    @Override
    public void updatePosition(Vector2 position) {
        this.updatePosition(position.x, position.y);
    }

    @Override
    public void updatePosition(float x, float y) {
        this.setPosition(x - this.width / 2, y - this.height / 2);
    }

    @Override
    public void render(NzShapeRenderer nzShapeRenderer) {
        nzShapeRenderer.rect(this);
    }

    @Override
    public float getXMax() {
        return this.x + this.getWidth();
    }

    @Override
    public float getXMaxShape() {
        return this.getWidth();
    }

    @Override
    public float getXMin() {
        return this.x;
    }

    @Override
    public float getXMinShape() {
        return this.x;
    }

    @Override
    public float getYMax() {
        return this.y + this.getHeight();
    }

    @Override
    public float getYMaxShape() {
        return this.getHeight();
    }

    @Override
    public float getYMin() {
        return this.y;
    }

    @Override
    public float getYMinShape() {
        return 0;
    }
}
