package com.nzt.gdx.test.s_try.list.math.shapes.segment;

import com.nzt.gdx.math.shapes.Segment;
import com.nzt.gdx.test.utils.archi.mains.mains.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.ScreenTry;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;
import com.nzt.gdx.utils.GdxUtils;

@TestScreen(group = "math.shapes.segment")
abstract class BaseSTrySegment extends ScreenTry {

    protected Segment segment;

    public BaseSTrySegment(FastTesterMain main) {
        super(main);
        segment = new Segment(GdxUtils.getScreenCenterX() - 150, GdxUtils.getScreenCenterY()
                , GdxUtils.getScreenCenterX() + 150, GdxUtils.getScreenCenterY());
    }


    @Override
    public void disposeTestScreen() {

    }
}
