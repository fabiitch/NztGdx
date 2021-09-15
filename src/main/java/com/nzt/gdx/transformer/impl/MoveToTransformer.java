package com.nzt.gdx.transformer.impl;

import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.transformer.BaseTransformer;

public class MoveToTransformer extends BaseTransformer<Vector2> {

    private float startX, startY;
    private float endX, endY;

    @Override
    protected void begin() {
        startX = value.x;
        startY = value.y;
        endX = target.x;
        endY = target.y;
    }

    @Override
    protected void act(float percent) {
        float x, y;
        if (percent == 0) {
            x = startX;
            y = startY;
        } else if (percent == 1) {
            x = endX;
            y = endY;
        } else {
            x = startX + (endX - startX) * percent;
            y = startY + (endY - startY) * percent;
        }
        value.x = x;
        value.y = y;
    }

    @Override
    public void restart() {
        begin();
    }

}
