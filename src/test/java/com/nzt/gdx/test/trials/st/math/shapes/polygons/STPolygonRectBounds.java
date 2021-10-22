package com.nzt.gdx.test.trials.st.math.shapes.polygons;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.nzt.gdx.test.trials.tester.archi.mains.FastTesterMain;

public class STPolygonRectBounds extends STPolygon {

    Rectangle rectBounds;

    public STPolygonRectBounds(FastTesterMain main) {
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
