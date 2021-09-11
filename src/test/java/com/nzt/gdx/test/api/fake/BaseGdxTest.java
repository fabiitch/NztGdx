package com.nzt.gdx.test.api.fake;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.math.MathUtils;

/**
 * Use it for junit with GDX
 */
public abstract class BaseGdxTest {

    public final static float MAX_DT = 1 / 10f;
    public final static float MIN_DT = 1 / 80f;

    public BaseGdxTest() {
        Gdx.app = new HeadlessApplication(new ApplicationAdapter() {
        });
    }

    public BaseGdxTest(int logLevel) {
        Gdx.app = new HeadlessApplication(new ApplicationAdapter() {
            @Override
            public void render() {
                renderTest(Gdx.graphics.getDeltaTime());
            }
        });
        Gdx.app.setLogLevel(logLevel);
    }

    public abstract void renderTest(float dt);

    public void renderRdmDT() {
        renderTest(getRandomDT(MIN_DT, MAX_DT));
    }

    public float getRandomDT(float min, float max) {
        return MathUtils.random(min, max);
    }
}
