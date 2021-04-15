package com.nzt.gdx.test.trials.tester.archi.main;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.nzt.gdx.main.AbstractMain;

public class StarterTestConfig {

    public static void startLwjgl(AbstractMain main, int witdh, int height) {
        LwjglApplicationConfiguration configuration = new LwjglApplicationConfiguration();
        configuration.title = "Tester Lwjgl";
        configuration.addIcon("badlogic.jpg", Files.FileType.Internal);

        configuration.useHDPI = true;
        configuration.width = witdh;
        configuration.height = height;

        configuration.foregroundFPS = 0;
        configuration.backgroundFPS = 0;
        new LwjglApplication(main, configuration);
    }

    /*
    marche pas pb de dependence
     */
    public static void startLwjgl3(AbstractMain main, int witdh, int height) {
        Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
        configuration.setTitle("Tester Lwjgl3");
        configuration.setWindowedMode(witdh, height);
        configuration.setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png");
        new Lwjgl3Application(main, configuration);
    }
}
