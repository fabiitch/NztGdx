package com.nzt.gdx.test.st.list;

import com.badlogic.gdx.math.Rectangle;
import com.nzt.gdx.test.st.tester.UnitTestScreen;
import com.nzt.gdx.test.st.tester.conditions.TestCondition;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;
import org.junit.jupiter.api.Test;

@TestScreen
public class RectangleMoveTest extends UnitTestScreen {

    Rectangle rect = new Rectangle(0, 0, 100, 100);

    @Override
    public String getTestExplication() {
        return "Just test if unitTestScreenWork";
    }

    @Test
    public void startTest() {
        System.out.println("toot");
        RectangleMoveTest tt = new RectangleMoveTest();
        tt.renderLoop60FPS();
    }

    public RectangleMoveTest() {
        super();
        testConditions.add(new TestCondition() {
            @Override
            public String name() {
                return "Rectangle move to right";
            }

            @Override
            public boolean testOk() {
                return rect.getX() > 100;
            }

            @Override
            public boolean testKo() {
                return rect.getX() < -100;
            }
        });
    }

    @Override
    public void renderUnitTest(float dt) {
        float x = rect.getX();
        rect.setPosition(x + 2, 0);
        shapeRenderer.begin();
        shapeRenderer.rect(rect);
        shapeRenderer.end();
    }

    @Override
    public void disposeTestScreen() {

    }

}
