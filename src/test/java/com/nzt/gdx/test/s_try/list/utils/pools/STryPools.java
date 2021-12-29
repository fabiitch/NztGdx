package com.nzt.gdx.test.s_try.list.utils.pools;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;
import com.nzt.gdx.debug.PoolsDebug;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.test.utils.archi.mains.dev.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.ScreenTry;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;

@TestScreen(group = "utils")
public class STryPools extends ScreenTry {
    public STryPools(FastTesterMain main) {
        super(main);
        glProfiler.removeHudDebug();
        try {
            Pool<ClassPoolNormal> classPoolNormalPool = Pools.get(ClassPoolNormal.class);
            ClassPoolNormal normal1 = classPoolNormalPool.obtain();
            classPoolNormalPool.clear();
            HudDebug.add("ClassPoolNormal", "Ok", HudDebugPosition.BOT_LEFT, Color.BLUE);
        } catch (Exception e) {
            HudDebug.add("ClassPoolNormal", "Fail", HudDebugPosition.BOT_RIGHT, Color.RED);
        }
        try {
            Pool<InnerClass> innerClassPool = Pools.get(InnerClass.class);
            InnerClass inner1 = innerClassPool.obtain();
            HudDebug.add("InnerClass", "Ok", HudDebugPosition.BOT_LEFT, Color.BLUE);
        } catch (Exception e) {
            HudDebug.add("InnerClass", "Fail", HudDebugPosition.BOT_RIGHT, Color.RED);
        }
        try {
            Pool<InnerPublicClass> innerPublicClassPool = Pools.get(InnerPublicClass.class);
            InnerPublicClass innerPublic = innerPublicClassPool.obtain();
            HudDebug.add("InnerPublicClass", "Ok", HudDebugPosition.BOT_RIGHT, Color.BLUE);
        } catch (Exception e) {
            HudDebug.add("InnerPublicClass", "Fail", HudDebugPosition.BOT_RIGHT, Color.RED);
        }
        try {
            Pool<InnerPrivateClass> innerPrivateClassPool = Pools.get(InnerPrivateClass.class);
            InnerPrivateClass innerPrivate1 = innerPrivateClassPool.obtain();
            HudDebug.add("InnerPrivateClass", "Ok", HudDebugPosition.BOT_LEFT, Color.BLUE);
        } catch (Exception e) {
            HudDebug.add("InnerPrivateClass", "Fail", HudDebugPosition.BOT_RIGHT, Color.RED);
        }

        try {
            Pool<InnerPrivateStaticClass> innerPrivateStaticClassPool = Pools.get(InnerPrivateStaticClass.class);
            InnerPrivateStaticClass innerPrivateStaticClass1 = innerPrivateStaticClassPool.obtain();
            HudDebug.add("InnerPrivateStaticClass", "Ok", HudDebugPosition.BOT_LEFT, Color.BLUE);
        } catch (Exception e) {
            HudDebug.add("InnerPrivateStaticClass", "Fail", HudDebugPosition.BOT_RIGHT, Color.RED);
        }
        try {
            Pool<InnerPublicStaticClass> innerPublicStaticClassPool = Pools.get(InnerPublicStaticClass.class);
            InnerPublicStaticClass innerPublicStaticClass = innerPublicStaticClassPool.obtain();
            HudDebug.add("InnerPublicStaticClass", "Ok", HudDebugPosition.BOT_LEFT, Color.BLUE);
        } catch (Exception e) {
            HudDebug.add("InnerPublicStaticClass", "Fail", HudDebugPosition.BOT_RIGHT, Color.RED);
        }

        try {
            Pool<InnerStaticClass> innerStaticClassPool = Pools.get(InnerStaticClass.class);
            InnerStaticClass innerStaticClass = innerStaticClassPool.obtain();
            HudDebug.add("InnerStaticClass", "Ok", HudDebugPosition.BOT_LEFT, Color.BLUE);
        } catch (Exception e) {
            HudDebug.add("InnerStaticClass", "Fail", HudDebugPosition.BOT_RIGHT, Color.RED);
        }

        HudDebug.addMiddleRight("Free", "Not do", Color.BLUE);

    }

    @Override
    public String getTestExplication() {
        return "Test class who can be pooled";
    }

    @Override
    public void renderTestScreen(float dt) {
        PoolsDebug.displayHudDebug(HudDebugPosition.TOP_LEFT, Color.RED);
    }

    @Override
    public void disposeTestScreen() {

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
