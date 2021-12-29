package com.nzt.gdx.test.s_try.list.scene2D.huddebug;

import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.math.vectors.V2;
import com.nzt.gdx.test.utils.archi.mains.dev.FastTesterMain;
import com.nzt.gdx.test.utils.archi.screens.ScreenTry;
import com.nzt.gdx.test.utils.screen_selector.TestScreen;

@TestScreen(group = "scene2D.hud debug.displayValue")
public class STryHudDebugDisplayVectors extends ScreenTry {
    public STryHudDebugDisplayVectors(FastTesterMain main) {
        super(main);
        Array<Vector> array = new Array<>();
        array.add(V2.v(50.121515f, 50.35655f));
        array.add(Vector2.Zero);
        array.add(V2.v(1515635654, 1515465466));

        for (int i = 0; i < array.size; i++) {
            HudDebug.addBotLeft("Left " + i, array.get(i));
            HudDebug.addBotRight("Right " + i, array.get(i));
        }

    }

    @Override
    public String getTestExplication() {
        return "DebugDisplayUtils print Vectors";
    }

    @Override
    public void renderTestScreen(float dt) {

    }

    @Override
    public void disposeTestScreen() {

    }
}
