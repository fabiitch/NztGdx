package com.nzt.gdx.test.trials.st.shapes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.math.AngleUtils;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

@TestScreenList(group = "shapes")
public class STVector2 extends TestScreen {

    Vector2 oldDir;
    Vector2 newDir;
    Vector2 result;
    Vector2 middle = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);

    public STVector2(FastTesterMain main) {
        super(main, true);
    }

    @Override
    public void doShow() {
        oldDir = new Vector2(1, 0);
        newDir = new Vector2(1, -0.1f).nor();
        float diffAngle = AngleUtils.distanceSigned(newDir, oldDir);
        result = new Vector2(oldDir).rotateDeg(diffAngle);
    }

    @Override
    public String getExplication() {
        return "Test Vector2";
    }

    @Override
    public void renderTestScreen(float dt) {
        nzShapeRenderer.begin();
        oldDir.rotateDeg(1);
        newDir.rotateDeg(-1);
        draw(oldDir, Color.GREEN);
        draw(newDir, Color.RED);
//        draw(result, Color.YELLOW);
        nzShapeRenderer.end();
    }

    @Override
    public void disposeTestScreen() {

    }


    private Vector2 getV(Vector2 v) {
        return v.cpy().nor().scl(150).add(middle);
    }

    private void draw(Vector2 v, Color color) {
        nzShapeRenderer.setColor(color);
        nzShapeRenderer.line(middle, getV(v));
    }
}
