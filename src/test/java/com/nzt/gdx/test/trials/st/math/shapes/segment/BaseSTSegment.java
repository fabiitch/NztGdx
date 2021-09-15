package com.nzt.gdx.test.trials.st.math.shapes.segment;

import com.nzt.gdx.math.shapes.Segment;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;
import com.nzt.gdx.utils.GdxUtils;

@TestScreenList(group = "math.shapes.segment")
abstract class BaseSTSegment extends TestScreen {

    protected Segment segment;

    public BaseSTSegment(FastTesterMain main) {
        super(main);
        segment = new Segment(GdxUtils.getScreenCenterX() - 150, GdxUtils.getScreenCenterY()
                , GdxUtils.getScreenCenterX() + 150, GdxUtils.getScreenCenterY());
    }


    @Override
    public void disposeTestScreen() {

    }
}
