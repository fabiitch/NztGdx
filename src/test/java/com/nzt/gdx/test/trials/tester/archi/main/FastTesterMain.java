package com.nzt.gdx.test.trials.tester.archi.main;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.nzt.gdx.main.AbstractMain;
import com.nzt.gdx.screen.BaseScreen;
import com.nzt.gdx.screen.manager.AbstractAssetsManager;
import com.nzt.gdx.screen.manager.AbstractLogManager;

import java.lang.reflect.Constructor;

/**
 * WIP, test class for launch fast iteration dev on lib change
 * returnScreenToLaunch for test your screen
 *
 * @author fabiitch
 */
public class FastTesterMain extends AbstractMain {

    protected Class screenClass;

    public FastTesterMain(Class screenClass) {
        this.screenClass = screenClass;
    }

    protected BaseScreen returnScreenToLaunch() {
        try {
            Constructor cons = screenClass.getConstructor(FastTesterMain.class);
            Object newInstance = cons.newInstance(this);
            return (BaseScreen) newInstance;
        } catch (Exception e) {
            System.err.println("Cant instance class " + screenClass);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void doCreate() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        Gdx.app.log("FastTesterMain", "Initialisation FastTesterMain");
        Gdx.app.log("=============", "================");
        logManager.activeGlProfiler();
    }

    @Override
    public void render() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        if (deltaTime > 1) { //for debug breakpoint
            deltaTime = 1 / 60f;
        }
        screenManager.render(deltaTime);
    }

    @Override
    public FastTesterScreenManager createScreenManager() {
        return new FastTesterScreenManager(returnScreenToLaunch());
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
