package com.nzt.gdx.test.trials.st.shapes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.input.impl.simple.SimpleClickInputHandler;
import com.nzt.gdx.math.shape.Triangle;
import com.nzt.gdx.math.shape.builders.TriangleBuilder;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreenWithHudDebug;
import com.nzt.gdx.test.trials.tester.selector.TestScreen;
import com.nzt.gdx.utils.GdxUtils;

@TestScreen(group = "shapes")
public class STTriangle extends TestScreenWithHudDebug {

    private int mode = 0;
    Vector2 middle = GdxUtils.getScreenCenter(new Vector2());
    Triangle triangle;
    private final Vector2 tmp = new Vector2();
    BitmapFont font;

    //scale
    float scaleAmt = 1;
    boolean scale = true;
    boolean up;

    //rotation
    boolean rotate = true;
    //vertexForBuilder
    int vertexNum = 0;

    int origin = 0;

    public STTriangle(FastTesterMain main) {
        super(main);
        this.font = new BitmapFont();
        HudDebug.addBotLeft("Mode", "normal", Color.RED);
        HudDebug.addBotLeft("-", "-", Color.BLUE);

        HudDebug.addBotLeft("Actions", "R=rotation, S=scale, V=vertex", Color.BLUE);
        changeMode();
        HudDebug.addTopRight("Angle A", triangle.getAngleDeg(0));
        HudDebug.addTopRight("Angle B", triangle.getAngleDeg(1));
        HudDebug.addTopRight("Angle C", triangle.getAngleDeg(2));

        HudDebug.addTopLeft("A", Vector2.Zero);
        HudDebug.addTopLeft("B", Vector2.Zero);
        HudDebug.addTopLeft("C", Vector2.Zero);
        HudDebug.addTopLeft("VertexCreation", vertexNum);
        HudDebug.addTopLeft("Origin", "middle");

        HudDebug.addLeftMiddle("Dir AB", Vector2.X);
        HudDebug.addLeftMiddle("Dir AC", Vector2.X);
        HudDebug.addLeftMiddle("Dir BC", Vector2.X);

        HudDebug.addRightMiddle("ScaleX", "1", Color.BLUE);
        HudDebug.addRightMiddle("ScaleY", "1", Color.BLUE);
        HudDebug.addRightMiddle("Rotation", 0);


        SimpleClickInputHandler inputHandler = new SimpleClickInputHandler() {
            @Override
            public boolean doKeyDown(int keycode) {
                if (keycode == Input.Keys.R)
                    rotate = !rotate;
                if (keycode == Input.Keys.S)
                    scale = !scale;
                if (keycode == Input.Keys.V) {
                    vertexNum++;
                    vertexNum = vertexNum % 3;
                    HudDebug.update("VertexCreation", vertexNum);
                    changeMode();
                }
                if (keycode == Input.Keys.C) {
                    origin++;
                    changeOrigin();
                }
                return false;
            }

            @Override
            public boolean doTouchDown(int screenX, int screenY, int pointer, int button) {
                mode++;
                changeMode();
                return false;
            }

            @Override
            public boolean doTouchUp(int screenX, int screenY, int pointer, int button) {
                return false;
            }

            @Override
            public boolean doScrolled(float amountX, float amountY) {
                scale = false;
                triangle.scale(-amountY / 10);
                return false;
            }
        };
        Gdx.input.setInputProcessor(inputHandler);
    }

    @Override
    public void renderAfterHud(float dt) {
        scaleRotate();
        nzShapeRenderer.begin();
        nzShapeRenderer.set(ShapeType.Filled);
        nzShapeRenderer.triangle(triangle);
        nzShapeRenderer.end();

        spriteBatch.begin();
        triangle.getA(tmp);
        font.draw(spriteBatch, "A", tmp.x, tmp.y);
        triangle.getB(tmp);
        font.draw(spriteBatch, "B", tmp.x, tmp.y);
        triangle.getC(tmp);
        font.draw(spriteBatch, "C", tmp.x, tmp.y);

        spriteBatch.end();
        count++;
        if (count > 8) {
            count = 0;
            updateHud();
        }
    }

    private int count = 0;

    private void updateHud() {
        HudDebug.update("A", triangle.getVertex(tmp, 0));
        HudDebug.update("B", triangle.getVertex(tmp, 1));
        HudDebug.update("C", triangle.getVertex(tmp, 2));

        HudDebug.update("Rotation", triangle.getRotation());
        HudDebug.update("ScaleX", triangle.getScaleX());
        HudDebug.update("ScaleY", triangle.getScaleY());

        HudDebug.update("Angle A", triangle.getAngleDeg(0));
        HudDebug.update("Angle B", triangle.getAngleDeg(1));
        HudDebug.update("Angle C", triangle.getAngleDeg(2));

        HudDebug.update("Dir AB", triangle.getDir(tmp, 0, 1));
        HudDebug.update("Dir AC", triangle.getDir(tmp, 0, 2));
        HudDebug.update("Dir BC", triangle.getDir(tmp, 1, 2));
    }

    private void changeOrigin() {
        switch (origin) {
            case 0:
                triangle.setOrigin(middle);
                HudDebug.update("Origin", "middle");
                break;
            case 1:
                triangle.setOrigin(triangle.getCentroid(new Vector2()));
                HudDebug.update("Origin", "Centroid");
                break;
            case 2:
                triangle.setOrigin(triangle.getCircumcenter(new Vector2()));
                HudDebug.update("Origin", "Circumcenter");
                break;
            default:
                origin = 0;
                changeOrigin();
        }
    }

    private void scaleRotate() {
        if (scale) {
            if (scaleAmt > 5) {
                up = false;
                nzShapeRenderer.randomColor();
            }
            if (scaleAmt < 1) {
                up = true;
                nzShapeRenderer.randomColor();
            }
            scaleAmt = up ? scaleAmt + 0.02f : scaleAmt - 0.02f;
            triangle.setScale(scaleAmt, scaleAmt);
        }
        if (rotate) {
            triangle.rotate(0.2f);
        }
        if (triangle.getRotation() > 360) {
            triangle.setRotation(0);
        }
    }

    private void changeMode() {
        switch (mode) {
            case 0:
                triangle = new Triangle(v(0, 0), v(50, 0), v(0, 50));
                HudDebug.update("Mode", "Rectangle");
                break;
            case 1:
                triangle = TriangleBuilder.fromOneVertex(vertexNum, v(0, 0), 45, 50, 50);
                HudDebug.update("Mode", "Isocele");
                break;
            case 2:
                triangle = TriangleBuilder.equilateral(vertexNum, v(0, 0), 80);
                HudDebug.update("Mode", "Equilateral");
                break;
            case 3:
                triangle = TriangleBuilder.rectangle(vertexNum, v(0, 0), 50, 100);
                HudDebug.update("Mode", "Rectangle2");
                break;
            case 4:
                triangle = TriangleBuilder.isosceles(vertexNum, v(0, 0), 30, 60);
                HudDebug.update("Mode", "isosceles");
                break;
            case 5:
                triangle = TriangleBuilder.isoscelesRectangle(vertexNum, v(0, 0), 60);
                HudDebug.update("Mode", "isoscelesRectangle");
                break;
            default:
                mode = 0;
                changeMode();
                break;
        }
        changeOrigin();

    }

    private Vector2 v(float x, float y) {
        return new Vector2(x, y).add(middle);
    }

    public void doDispose() {
        super.doDispose();
        font.dispose();
    }

}
