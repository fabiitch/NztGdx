package com.nzt.gdx.test.s_try.list.math.shapes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.input.impl.simple.SimpleClickInputHandler;
import com.nzt.gdx.math.shapes.Segment;
import com.nzt.gdx.test.utils.archi.mains.dev.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.ScreenTry;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;
import com.nzt.gdx.utils.GdxUtils;

@TestScreen(group = "math.shapes")
public class STrySegment extends ScreenTry {
    private final Segment segment;

    private boolean rotate = true;

    public STrySegment(FastTesterMain main) {
        super(main);
        infoMsg("Right click to change A");
        infoMsg("Left click to change B");
        infoMsg("Wheel click for rotation");
        segment = new Segment(GdxUtils.getScreenCenterX() - 100, GdxUtils.getScreenCenterY()
                , GdxUtils.getScreenCenterX() + 100, GdxUtils.getScreenCenterY());
        SimpleClickInputHandler simpleClickInputHandler = new SimpleClickInputHandler() {
            @Override
            public boolean click(int screenX, int screenY, int pointer, int button) {
                if (button == LEFT_CLICK) {
                    this.getClickPos(screenX, screenY, segment.a);
                } else if (button == RIGHT_CLICK) {
                    this.getClickPos(screenX, screenY, segment.b);
                } else if (button == WHEEL_CLICK) {
                    rotate = !rotate;
                }
                return false;
            }
        };
        Gdx.input.setInputProcessor(simpleClickInputHandler);
    }

    @Override
    public String getTestExplication() {
        return "Simple segment";
    }

    @Override
    public void renderTestScreen(float dt) {
        if (rotate)
            segment.rotate(2);
        shapeRenderer.begin();
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.segment(segment);
        shapeRenderer.end();
    }

    @Override
    public void disposeTestScreen() {

    }
}
