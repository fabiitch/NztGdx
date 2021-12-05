package com.nzt.gdx.test.s_try.list.math.shapes;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Polyline;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.test.utils.archi.mains.mains.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.ScreenTry;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;
import com.nzt.gdx.utils.GdxUtils;

@TestScreen(group = "math.shapes")
public class STryPolyline extends ScreenTry {
    Vector2 middle = GdxUtils.getScreenCenter(new Vector2());
    Polyline polyline1 = new Polyline(new float[]{middle.x, middle.y, middle.x + 50, middle.y + 50});

    public STryPolyline(FastTesterMain main) {
        super(main, true);
        polyline1.setOrigin(middle.x, middle.y);

        HudDebug.addTopLeft("rotation", 0);
        HudDebug.addTopLeft("scale", scale);
    }

    @Override
    public String getTestExplication() {
        return null;
    }

    float scale = 1;
    boolean up;

    @Override
    public void renderTestScreen(float dt) {
        shapeRenderer.begin();
        shapeRenderer.set(ShapeType.Filled);
        shapeRenderer.polyline(polyline1);
        shapeRenderer.end();
        polyline1.rotate(0.2f);

        if (scale > 10) {
            up = false;
            shapeRenderer.randomColor();
        }
        if (scale < 1) {
            up = true;
            shapeRenderer.randomColor();
        }

        scale = up ? scale + 0.01f : scale - 0.01f;
        polyline1.setScale(scale, scale);

        HudDebug.update("rotation", polyline1.getRotation());
        HudDebug.update("scale", polyline1.getScaleX());
    }

    @Override
    public void disposeTestScreen() {

    }

}
