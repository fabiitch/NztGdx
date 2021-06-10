package com.nzt.gdx.test.trials.st.utils.pools;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;
import com.nzt.gdx.debug.PoolsDebug;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreenWithHudDebug;
import com.nzt.gdx.test.trials.tester.selector.TestScreen;

@TestScreen(group = "utils")
public class STPools extends TestScreenWithHudDebug {
    public STPools(FastTesterMain main) {
        super(main);
        glProfiler.removeHudDebug();
        try {
            Pool<ClassPoolNormal> classPoolNormalPool = Pools.get(ClassPoolNormal.class);
            ClassPoolNormal normal1 = classPoolNormalPool.obtain();
            classPoolNormalPool.clear();
            HudDebug.addItem("ClassPoolNormal", "Ok", HudDebugPosition.BOT_LEFT, Color.BLUE);
        } catch (Exception e) {
            HudDebug.addItem("ClassPoolNormal", "Fail", HudDebugPosition.BOT_RIGHT, Color.RED);
        }
        try {
            Pool<InnerClass> innerClassPool = Pools.get(InnerClass.class);
            InnerClass inner1 = innerClassPool.obtain();
            HudDebug.addItem("InnerClass", "Ok", HudDebugPosition.BOT_LEFT, Color.BLUE);
        } catch (Exception e) {
            HudDebug.addItem("InnerClass", "Fail", HudDebugPosition.BOT_RIGHT, Color.RED);
        }
        try {
            Pool<InnerPublicClass> innerPublicClassPool = Pools.get(InnerPublicClass.class);
            InnerPublicClass innerPublic = innerPublicClassPool.obtain();
            HudDebug.addItem("InnerPublicClass", "Ok", HudDebugPosition.BOT_RIGHT, Color.BLUE);
        } catch (Exception e) {
            HudDebug.addItem("InnerPublicClass", "Fail", HudDebugPosition.BOT_RIGHT, Color.RED);
        }
        try {
            Pool<InnerPrivateClass> innerPrivateClassPool = Pools.get(InnerPrivateClass.class);
            InnerPrivateClass innerPrivate1 = innerPrivateClassPool.obtain();
            HudDebug.addItem("InnerPrivateClass", "Ok", HudDebugPosition.BOT_LEFT, Color.BLUE);
        } catch (Exception e) {
            HudDebug.addItem("InnerPrivateClass", "Fail", HudDebugPosition.BOT_RIGHT, Color.RED);
        }

        try {
            Pool<InnerPrivateStaticClass> innerPrivateStaticClassPool = Pools.get(InnerPrivateStaticClass.class);
            InnerPrivateStaticClass innerPrivateStaticClass1 = innerPrivateStaticClassPool.obtain();
            HudDebug.addItem("InnerPrivateStaticClass", "Ok", HudDebugPosition.BOT_LEFT, Color.BLUE);
        } catch (Exception e) {
            HudDebug.addItem("InnerPrivateStaticClass", "Fail", HudDebugPosition.BOT_RIGHT, Color.RED);
        }
        try {
            Pool<InnerPublicStaticClass> innerPublicStaticClassPool = Pools.get(InnerPublicStaticClass.class);
            InnerPublicStaticClass innerPublicStaticClass = innerPublicStaticClassPool.obtain();
            HudDebug.addItem("InnerPublicStaticClass", "Ok", HudDebugPosition.BOT_LEFT, Color.BLUE);
        } catch (Exception e) {
            HudDebug.addItem("InnerPublicStaticClass", "Fail", HudDebugPosition.BOT_RIGHT, Color.RED);
        }

        try {
            Pool<InnerStaticClass> innerStaticClassPool = Pools.get(InnerStaticClass.class);
            InnerStaticClass innerStaticClass = innerStaticClassPool.obtain();
            HudDebug.addItem("InnerStaticClass", "Ok", HudDebugPosition.BOT_LEFT, Color.BLUE);
        } catch (Exception e) {
            HudDebug.addItem("InnerStaticClass", "Fail", HudDebugPosition.BOT_RIGHT, Color.RED);
        }

        HudDebug.addRightMiddle("Free", "Not do", Color.BLUE);

    }

    @Override
    public void renderAfterHud(float dt) {
        PoolsDebug.displayHudDebug(HudDebugPosition.TOP_LEFT, Color.RED);
    }

    class InnerClass {
    }

    public class InnerPublicClass {
    }

    private class InnerPrivateClass {
    }

    private static class InnerPrivateStaticClass {
    }

    public static class InnerPublicStaticClass {
    }

    public static class InnerStaticClass {
    }
}
