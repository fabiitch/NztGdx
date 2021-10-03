package com.nzt.gdx.test.trials.st.scene2D.huddebug;

import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.test.trials.tester.archi.mains.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreen;
import com.nzt.gdx.test.trials.tester.selector.TestScreenList;

@TestScreenList(group = "scene2D.hud debug")
public class STHudDebugRightDisplay extends TestScreen {
    public STHudDebugRightDisplay(FastTesterMain main) {
        super(main);
        for (int i = 0; i < 3; i++) {
            HudDebug.addTopRight(i + "a", getStringX10(i));
        }
        HudDebug.addTopRight("---", "---");
        for (int i = 0; i < 3; i++) {
            HudDebug.addTopRight(i + "b", getStringX10(i));
        }


        for (int i = 0; i < 3; i++) {
            HudDebug.addMiddleRight(i + "c", getStringX10(i));
        }
        HudDebug.addMiddleRight("---", "---");
        for (int i = 0; i < 3; i++) {
            HudDebug.addMiddleRight(i + "d", getStringX10(i));
        }

        for (int i = 0; i < 3; i++) {
            HudDebug.addBotRight(i + "e", getStringX10(i));
        }
        HudDebug.addBotRight("---", "---");
        for (int i = 0; i < 3; i++) {
            HudDebug.addBotRight(i + "f", getStringX10(i));
        }
    }

    @Override
    public String getTestExplication() {
        return "Test le display sur le right pour le décalage";
    }

    @Override
    public void renderTestScreen(float dt) {

    }

    private String getStringX10(int number) {

        String s = (number * 10) + "  ";
        for (int i = 0; i < number * 10; i++) {
            s += i + " ";
        }
        return s;
    }

    @Override
    public void disposeTestScreen() {

    }
}
