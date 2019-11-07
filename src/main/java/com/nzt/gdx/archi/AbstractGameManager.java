package com.nzt.gdx.archi;

import com.badlogic.gdx.utils.Disposable;

public abstract class AbstractGameManager implements Disposable {

	public AbstractGameManager() {
		GameServiceManager.registerService(this);
	}
}