package com.nzt.gdx.test.utils.screen_selector.screen;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.nzt.gdx.screen.BaseScreen;
import com.nzt.gdx.screen.manager.AbstractAssetsManager;
import com.nzt.gdx.screen.manager.AbstractLogManager;
import com.nzt.gdx.test.utils.archi.mains.FastTesterLogManager;
import com.nzt.gdx.test.utils.archi.mains.mains.FastTesterMain;
import com.nzt.gdx.test.utils.archi.mains.screen_manager.FastTesterScreenManager;

public class ScreenSelectorTestMain extends FastTesterMain {
    protected BaseScreen selectorScreenTest;

    protected final CaseST rootCase;
    protected CaseST lastGroupCase;

    public ScreenSelectorTestMain(Class screenClass, String packageToScan) {
        super(screenClass);
        this.rootCase = ScreenTestAnnotationScanner.scanTestScreens(packageToScan);
        this.lastGroupCase = rootCase;
    }

    @SuppressWarnings("GDXJavaLogLevel")
    @Override
    public void doCreate() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        Gdx.app.log("ScreenSelectorTestMain", "Initialisation with ScreenSelectorTestMain");
        Gdx.app.log("=============", "================");
        logManager.activeGlProfiler();
    }

    @Override
    public FastTesterScreenManager createScreenManager() {
        selectorScreenTest = new ScreenSelector(this, rootCase);
        return new FastTesterScreenManager(selectorScreenTest);
    }

    @Override
    public void render() {
        super.render();
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            selectorScreenTest = new ScreenSelector(this, lastGroupCase);
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
