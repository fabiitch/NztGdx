package com.nzt.gdx.test.api.fake;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;

public class BaseGdxTest {

    public BaseGdxTest() {
        Gdx.app = new HeadlessApplication(new ApplicationAdapter() {
        });
    }

    public BaseGdxTest(int logLevel) {
        Gdx.app = new HeadlessApplication(new ApplicationAdapter() {
        });
        Gdx.app.setLogLevel(logLevel);
    }
}
