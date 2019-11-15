package com.nzt.gdx.archi;

import com.badlogic.gdx.utils.Disposable;

public abstract class AbstractGameService implements Disposable {

	public AbstractGameService() {
		GameServiceManager.registerService(this);
	}
}