package com.nzt.gdx.test.api.fake;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import org.junit.jupiter.api.Assertions;

/**
 * Use it for junit with GDX
 * Add PredicateSuccess/PredicateKO or TestConditions for check if test is OK/KO
 * use renderLoop for run your test
 */
public abstract class BaseGdxTest {

    public final static float MAX_DT = 1 / 10f;
    public final static float MIN_DT = 1 / 80f;

    public float secondElapsed = 0f;
    public final Array<PredicateSuccess> successesConditions = new Array<>();
    private final Array<PredicateSuccess> tmpSuccess = new Array<>();

    public final Array<PredicateKO> koConditions = new Array<>();

    public final Array<TestConditions> testConditions = new Array<>();
    private final Array<TestConditions> tmpConditions = new Array<>();

    public float maxTimeTestDuration = 20f;


    public BaseGdxTest() {
        Gdx.app = new HeadlessApplication(new ApplicationAdapter() {
        });
        koConditions.add(new PredicateKO() {
            @Override
            public String name() {
                return "Duration Test";
            }

            @Override
            public boolean testKO() {
                return secondElapsed > maxTimeTestDuration;
            }
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

    public void doRender(float dt) {
        secondElapsed += dt / 1000;
        renderTest(dt);
        for (PredicateSuccess success : successesConditions) {
            if (success.testOk()) {
                Gdx.app.log("Condition Ok ", success.name());
            } else {
                tmpSuccess.add(success);
            }
        }
        successesConditions.clear();
        successesConditions.addAll(tmpSuccess);
        tmpSuccess.clear();


        for (TestConditions testCondition : testConditions) {
            Boolean testOk = testCondition.ok();
            if (testOk == null) {
                tmpConditions.add(testCondition);
            } else if (testOk) {
                Gdx.app.log("Condition Ok ", testCondition.name());
            } else {
                Assertions.fail("Condition Ko :" + testCondition.name());
            }
        }

        for (PredicateKO ko : koConditions) {
            if (ko.testKO())
                Assertions.fail("Condition Ko :" + ko.name());
        }

    }

    public abstract void renderTest(float dt);

    public void renderLoop(float dt) {
        while (successesConditions.size > 0 || testConditions.size > 0) doRender(dt);
    }

    public void renderLoop60FPS() {
        renderLoop(1 / 60f);
    }

    public void renderLoop120FPS() {
        renderLoop(1 / 120f);
    }

    public void renderLoopRdm(float min, float max) {
        renderLoop(MathUtils.random(min, max));
    }

    public void renderLoopRdm() {
        renderLoopRdm(MIN_DT, MAX_DT);
    }

}
