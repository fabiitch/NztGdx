package com.nzt.gdx.test.s_try.list.scene2D.huddebug;

import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.test.utils.archi.mains.dev.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.ScreenTry;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;

@TestScreen(group = "scene2D.hud debug.displayValue")
public class STryHudDebugDisplayFloats extends ScreenTry {
    public STryHudDebugDisplayFloats(FastTesterMain main) {
        super(main);

        Array<Object> array = new Array<>();
        array.add(55.21154545454f);
        array.add(55.5665f);
        array.add(Float.MIN_VALUE);
        array.add(Float.NaN);

        array.add(55.211545454548888d);
        array.add(55.2222d);
        array.add(Double.MIN_VALUE);

        array.add(54545454);
        array.add(Integer.MAX_VALUE);
        array.add(Integer.MIN_VALUE);

        array.add(Long.MAX_VALUE);
        array.add(Long.MIN_VALUE);

        for (int i = 0; i < array.size; i++) {
            HudDebug.addBotLeft("Left " + i, array.get(i));
            HudDebug.addBotRight("Right " + i, array.get(i));
        }
    }

    @Override
    public String getTestExplication() {
        return "test float displays";
    }

    @Override
    public void renderTestScreen(float dt) {

    }

    @Override
    public void disposeTestScreen() {

    }
}
