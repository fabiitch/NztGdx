package com.nzt.gdx.test.st.tester;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.nzt.gdx.debug.gl.NzGLProfiler;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.scene2D.nz.NzStage;
import com.nzt.gdx.test.st.tester.conditions.PredicateKO;
import com.nzt.gdx.test.st.tester.conditions.PredicateSuccess;
import com.nzt.gdx.test.st.tester.conditions.TestCondition;
import com.nzt.gdx.test.utils.archi.mains.mains.FastTesterMain;
import com.nzt.gdx.test.utils.archi.mains.mains.HeadlessTesterMain;
import com.nzt.gdx.test.utils.archi.screens.ScreenTry;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Use it for junit with GDX
 * Usable with test screen too
 * Add PredicateSuccess/PredicateKO or TestConditions for check if test is OK/KO
 * use renderLoop for run your test
 */

public abstract class UnitTestScreen extends ScreenTry {

    public final static float MAX_DT = 1 / 10f;
    public final static float MIN_DT = 1 / 80f;

    public float timeElapsed = 0f;
    public final ArrayList<PredicateSuccess> successesConditions = new ArrayList<>();
    public final ArrayList<PredicateKO> koConditions = new ArrayList<>();
    public final ArrayList<TestCondition> testConditions = new ArrayList<>();

    public float maxTimeTestDuration = 10f;

    static HeadlessTesterMain main;

    @BeforeAll
    public static void init() throws Exception {
        main = new HeadlessTesterMain(null);
        main.createRenderObjects();
        HeadlessApplication app = new HeadlessApplication(main);
        Gdx.app = app;
    }

    @Override
    protected void renderObjects() {
        //do nothing
        this.nzStage = Mockito.mock(NzStage.class);
        this.hudDebug = Mockito.mock(HudDebug.class);
        this.modelBatch = Mockito.mock(ModelBatch.class);
        this.glProfiler = Mockito.mock(NzGLProfiler.class);
    }

    public UnitTestScreen(FastTesterMain main) {
        super(main);
        koConditions.add(new PredicateKO() {
            @Override
            public String name() {
                return "Duration Test : timeMax=" + maxTimeTestDuration;
            }

            @Override
            public boolean testKO() {
                return timeElapsed > maxTimeTestDuration;
            }
        });
    }

    public UnitTestScreen() {
        this(main);
    }

    public abstract void renderUnitTest(float dt);

    @Override
    public void renderTestScreen(float dt) {
        timeElapsed += dt;
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
            if (testCondition.testOk()) {
                Gdx.app.log("Condition OK", testCondition.name());
                iteratorTestCondition.remove();
            }
            if (testCondition.testKo()) Assertions.fail("Condition KO :" + testCondition.name());
        }

        for (PredicateKO ko : koConditions) {
            if (ko.testKO())
                Assertions.fail("Condition KO :" + ko.name());
        }
        renderUnitTest(dt);
    }

    @AfterEach
    public void cleanNztGdxTest() {
        timeElapsed = 0;
        successesConditions.clear();
        koConditions.clear();
        testConditions.clear();
    }


    public void renderLoop(float dt) {
        try {
            while (successesConditions.size() > 0 || testConditions.size() > 0) renderTestScreen(dt);
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

    public static boolean isJUnitTest() {
        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            if (element.getClassName().startsWith("org.junit.")) {
                return true;
            }
        }
        return false;
    }

}
