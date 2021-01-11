package com.nzt.gdx.tester;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nzt.gdx.main.AbstractMain;
import com.nzt.gdx.assets.AbstractAssetsManager;
import com.nzt.gdx.logger.config.AbstractLogManager;
import com.nzt.gdx.screen.BaseScreen;
import com.nzt.gdx.screen.manager.AbstractScreenManager;
import com.nzt.gdx.tester.screen.Vector2TestScreen;

/**
 * WIP, test class for launch fast iteration dev on lib change
 * returnScreenToLaunch for test your screen
 *
 * @author fabiitch
 */
public class FastTesterMain extends AbstractMain {

    private BaseScreen returnScreenToLaunch() {
        return new Vector2TestScreen(this);
//        return new HudDebugDisplayScreen(this);
    }


    @Override
    public void doCreate() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        Gdx.app.log("FastTester", "Initialisation faster tester");
    }

    @Override
    public AbstractScreenManager createScreenManager() {
        return new FastTesterScreenManager(returnScreenToLaunch());
    }

    @Override
    public AbstractAssetsManager createAssetsManager() {
        return null;
    }

    @Override
    public AbstractLogManager<AbstractMain> createLogManager() {
        return null;
    }

    @Override
    public void doExit() {

    }

    public static void main(String args[]) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "toto";
        config.addIcon("badlogic.jpg", Files.FileType.Internal);
        config.useHDPI = true;

        config.foregroundFPS = 0;
        config.backgroundFPS = 0;
        new LwjglApplication(new FastTesterMain(), config);
    }

}
