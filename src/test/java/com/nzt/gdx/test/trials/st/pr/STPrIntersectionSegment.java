package com.nzt.gdx.test.trials.st.pr;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nzt.gdx.math.shapes.Segment;
import com.nzt.gdx.test.trials.tester.archi.mains.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

@TestScreenList(group = "pullrequest")
public class STPrIntersectionSegment extends TestScreen {

    Segment segA, segB;

    public STPrIntersectionSegment(FastTesterMain main) {
        super(main);
        segA = new Segment(0,0,100,100);
        segB = new Segment(10.0f,5.0f,31.213203f,26.213203f);


    }

    @Override
    public String getTestExplication() {
        return "Bug segment intersection ?";
    }

    @Override
    public void renderTestScreen(float dt) {
        shapeRenderer.begin();
        shapeRenderer.set(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.segment(segA);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.segment(segA);
        shapeRenderer.end();
    }

    @Override
    public void disposeTestScreen() {

    }
}
