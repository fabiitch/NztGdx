package com.nzt.gdx.test.trials.tester.archi.mains;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.nzt.gdx.main.AbstractMain;

public class StarterTestConfig {

    //https://github.com/BinaryTweed/libgdx-test-runner


    public static void startLwjgl3(AbstractMain main, int witdh, int height) {
        Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
        configuration.setTitle("Tester Lwjgl3");
        configuration.setWindowedMode(witdh, height);
        configuration.setWindowIcon("icons/libgdx128.png", "icons/libgdx64.png", "icons/libgdx32.png", "icons/libgdx16.png");
        new Lwjgl3Application(main, configuration);
    }
}
