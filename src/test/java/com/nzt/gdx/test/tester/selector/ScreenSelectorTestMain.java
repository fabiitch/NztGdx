package com.nzt.gdx.test.tester.selector;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.nzt.gdx.screen.manager.AbstractAssetsManager;
import com.nzt.gdx.screen.manager.AbstractLogManager;
import com.nzt.gdx.test.tester.TestScreen;
import com.nzt.gdx.test.tester.archi.main.FastTesterLogManager;
import com.nzt.gdx.test.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.tester.archi.main.FastTesterScreenManager;
import com.nzt.gdx.test.tester.archi.screen.SimpleTestScreen;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ScreenSelectorTestMain extends FastTesterMain {
    private SelectorScreenTest selectorScreenTest;
    private ArrayList<CaseTestScreen> baseTreeTestScreen;

    public ScreenSelectorTestMain(Class screenClass) {
        super(screenClass);
        this.baseTreeTestScreen = TestScreenScanner.scanTestScreens();
    }

    @Override
    public void doCreate() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        Gdx.app.log("ScreenSelectorTestMain", "Initialisation faster tester");
    }

    @Override
    public FastTesterScreenManager createScreenManager() {
        selectorScreenTest = new SelectorScreenTest(this, baseTreeTestScreen);
        return new FastTesterScreenManager(selectorScreenTest);
    }

    @Override
    public void render() {
        super.render();
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE) && screenManager.currentScreen != selectorScreenTest) {
            selectorScreenTest = new SelectorScreenTest(this, TestScreenScanner.scanTestScreens());
            screenManager.setScreen(selectorScreenTest);
        }
    }

    @Override
    public AbstractAssetsManager createAssetsManager() {
        return null;
    }

    @Override
    public AbstractLogManager createLogManager() {
        return FastTesterLogManager.instance;
    }

    @Override
    public void doExit() {

    }

}
