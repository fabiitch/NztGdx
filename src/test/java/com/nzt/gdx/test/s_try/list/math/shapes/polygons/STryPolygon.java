package com.nzt.gdx.test.s_try.list.math.shapes.polygons;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.shapes.utils.PolygonUtils;
import com.nzt.gdx.test.utils.archi.mains.mains.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.ScreenTry;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;
import com.nzt.gdx.utils.GdxUtils;

@TestScreen(group = "math.shapes.polygon")
public class STryPolygon extends ScreenTry {
    private final BitmapFont font;


    protected final Polygon polygon;
    protected final Vector2 centerPolygon = new Vector2();
    protected final Vector2 tmp = new Vector2();

    public STryPolygon(FastTesterMain main) {
        super(main);
        this.font = new BitmapFont();
        float[] vertices = new float[]{0, 0, 0, 150, 100, 250, 250, 350, 75, -100};
        this.polygon = new Polygon(vertices);
        Vector2 orig = GdxUtils.getScreenCenter(new Vector2()).sub(150, 100);
        polygon.setPosition(orig.x, orig.y);

    }

    float scaleAmt = 1;
    boolean scale = true;
    boolean up;
    boolean rotate = true;

    @Override
    public String getTestExplication() {
        return "Polygon Test";
    }

    @Override
    public void renderTestScreen(float dt) {
        scaleRotate();
        PolygonUtils.getCenter(polygon, centerPolygon);
        shapeRenderer.begin();
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.set(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.polygon(polygon);

        shapeRenderer.setColor(Color.RED);
        shapeRenderer.set(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.circle(centerPolygon, 2);
        shapeRenderer.end();

        spriteBatch.begin();
        float[] vertices = polygon.getTransformedVertices();
        for (int i = 0; i < vertices.length / 2; i++) {
            PolygonUtils.getVertex(polygon, i, tmp);
            font.draw(spriteBatch, "" + i, tmp.x, tmp.y);
        }
        spriteBatch.end();
    }

    private void scaleRotate() {
        if (scale) {
            if (scaleAmt > 2.5f) {
                up = false;
            }
            if (scaleAmt < 0.2f) {
                up = true;
            }
            scaleAmt = up ? scaleAmt + 0.02f : scaleAmt - 0.02f;
            polygon.setScale(scaleAmt, scaleAmt);
        }
        if (rotate) {
            polygon.rotate(0.2f);
        }
        if (polygon.getRotation() > 360) {
            polygon.setRotation(0);
        }
    }

    @Override
    public void disposeTestScreen() {

    }
}
