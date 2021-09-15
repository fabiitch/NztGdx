package com.nzt.gdx.test.trials.st.math.vectors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.input.impl.simple.SimpleClickInputHandler;
import com.nzt.gdx.math.AngleUtils;
import com.nzt.gdx.math.vectors.V2;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;
import com.nzt.gdx.utils.GdxUtils;

@TestScreenList(group = "math.vector2")
public class STV2Opposite extends TestScreen {
    Vector2 middle;
    Vector2 v1 = new Vector2(1, 0);
    Vector2 v2 = new Vector2(1, 1);
    Vector2 clickPos = new Vector2();

    public STV2Opposite(FastTesterMain main) {
        super(main);
        infoMsg("right clickfor change V1");
        infoMsg("left click for change V2");
        middle = GdxUtils.getScreenCenter(new Vector2());
        SimpleClickInputHandler simpleClickInputHandler = new SimpleClickInputHandler() {
            @Override
            public boolean click(int screenX, int screenY, int pointer, int button) {
                if (button == LEFT_CLICK) {
                    this.getClickPos(screenX, screenY, clickPos);
                    V2.directionTo(middle, clickPos, v2);
                } else if (button == RIGHT_CLICK) {
                    this.getClickPos(screenX, screenY, clickPos);
                    V2.directionTo(middle, clickPos, v1);
                }
                boolean v1Test = v1.hasOppositeDirection(v2);
                boolean v2Test = v2.hasOppositeDirection(v1);
                if (v1Test)
                    debugMsg("v1.hasOppositeDirection(v2)", v1Test, Color.BLUE);
                else
                    debugMsg("v1.hasOppositeDirection(v2)", v1Test, Color.RED);
                if (v2Test)
                    debugMsg("v2.hasOppositeDirection(v1)", v2Test, Color.BLUE);
                else
                    debugMsg("v2.hasOppositeDirection(v1)", v2Test, Color.RED);

                debugMsg("v1", v1.toString() + "  | angle :" + v1.angleDeg());
                debugMsg("v2", v2.toString() + "  | angle :" + v2.angleDeg());

                debugMsg("diffAngle :", AngleUtils.distanceAbs(v1.angleDeg(), v2.angleDeg()), Color.RED);

                return false;
            }
        };
        Gdx.input.setInputProcessor(simpleClickInputHandler);
    }


    @Override
    public String getTestExplication() {
        return "Test method opposite direction";
    }

    @Override
    public void renderTestScreen(float dt) {
        shapeRenderer.begin();
        shapeRenderer.set(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.line(middle, middle.cpy().add(v1.setLength(200)));
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.line(middle, middle.cpy().add(v2.setLength(200)));
        shapeRenderer.end();
    }

    @Override
    public void disposeTestScreen() {

    }
}
