package com.nzt.gdx.init;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;

public abstract class GdxHeadLessInitialiser {
	public GdxHeadLessInitialiser() {

		HeadlessApplicationConfiguration conf = new HeadlessApplicationConfiguration();
		HeadlessApplication application = new HeadlessApplication(new FakeMain(), conf);
		application.setLogLevel(Application.LOG_NONE);
		application.log("Unit Test initialisation", "HeadlessFake");
	}

	protected void enableLog() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
	}
}