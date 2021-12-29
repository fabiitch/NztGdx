package com.nzt.gdx.test.s_try.list.math.shapes.polygons;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.nzt.gdx.test.utils.archi.mains.dev.FastTesterMain;

public class STryPolygonRectBounds extends STryPolygon {

    Rectangle rectBounds;

    public STryPolygonRectBounds(FastTesterMain main) {
        super(main);
    }

    @Override
    public String getTestExplication() {
        return "Polygon get bounds test";
    }

    @Override
    public void renderTestScreen(float dt) {
        rectBounds = polygon.getBoundingRectangle();
        super.renderTestScreen(dt);
        shapeRenderer.begin();
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.rect(rectBounds);
        shapeRenderer.end();
    }
}
