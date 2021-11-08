package com.nzt.gdx.test.api.tester;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Use it for junit with GDX
 * Add PredicateSuccess/PredicateKO or TestConditions for check if test is OK/KO
 * use renderLoop for run your test
 */
public abstract class BaseGdxTest {

    public final static float MAX_DT = 1 / 10f;
    public final static float MIN_DT = 1 / 80f;

    public float timeElapsed = 0f;
    public final ArrayList<PredicateSuccess> successesConditions = new ArrayList<>();

    public final ArrayList<PredicateKO> koConditions = new ArrayList<>();

    public final ArrayList<TestCondition> testConditions = new ArrayList<>();

    public float maxTimeTestDuration = 10f;


    public BaseGdxTest() {
        Gdx.app = new HeadlessApplication(new ApplicationAdapter() {
        });
        // Mock any calls to OpenGL
        Gdx.gl20 = Mockito.mock(GL20.class);
        Gdx.gl = Gdx.gl20;

        Gdx.app.log("TestClass", this.getClass().getSimpleName());
        koConditions.add(new PredicateKO() {
            @Override
            public String name() {
                return "Duration Test";
            }

            @Override
            public boolean testKO() {
                return timeElapsed * 1000 > maxTimeTestDuration;
            }
        });
    }

    public BaseGdxTest(int logLevel) {
        this();
        Gdx.app.setLogLevel(logLevel);
    }

    public void doRender(float dt) {
        timeElapsed += dt;
        renderTest(dt);
        Iterator<PredicateSuccess> iteratorSuccess = successesConditions.iterator();
        while (iteratorSuccess.hasNext()) {
            PredicateSuccess condition = iteratorSuccess.next();
            if (condition.testOk()) {
                Gdx.app.log("Condition OK", condition.name());
                iteratorSuccess.remove();
            }
        }
        Iterator<TestCondition> iteratorTestCondition = testConditions.iterator();
        while (iteratorTestCondition.hasNext()) {
            TestCondition testCondition = iteratorTestCondition.next();
            Boolean testOk = testCondition.ok();
            if (testOk) {
                Gdx.app.log("Condition OK", testCondition.name());
                iteratorTestCondition.remove();
            } else {
                Assertions.fail("Condition KO :" + testCondition.name());
            }
        }

        for (PredicateKO ko : koConditions) {
            if (ko.testKO())
                Assertions.fail("Condition KO :" + ko.name());
        }
    }

    @AfterEach
    public void cleanNztGdxTest() {
        timeElapsed = 0;
        successesConditions.clear();
        koConditions.clear();
        testConditions.clear();
    }

    public abstract void renderTest(float dt);

    public void renderLoop(float dt) {
        try {
            while (successesConditions.size() > 0 || testConditions.size() > 0) doRender(dt);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public Vector2 v(float x, float y) {
        return new Vector2(x, y);
    }

    public Vector3 v(float x, float y, float z) {
        return new Vector3(x, y, z);
    }
}
