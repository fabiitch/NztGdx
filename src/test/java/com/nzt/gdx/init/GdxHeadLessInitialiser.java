package com.nzt.gdx.init;

import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;

public abstract class GdxHeadLessInitialiser {
	public GdxHeadLessInitialiser() {
		System.out.println("Gdx HeadlessFake init");
		HeadlessApplicationConfiguration conf = new HeadlessApplicationConfiguration();
		HeadlessApplication application = new HeadlessApplication(new FakeMain(), conf);
	}

}