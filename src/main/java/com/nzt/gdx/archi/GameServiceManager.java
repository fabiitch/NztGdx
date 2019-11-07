package com.nzt.gdx.archi;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

public class GameServiceManager implements Disposable {
	private static Array<AbstractGameManager> serviceList = new Array<AbstractGameManager>();

	@SuppressWarnings("unchecked")
	public static <S extends AbstractGameManager> S getGameService(Class<S> classAsk) {
		for (AbstractGameManager service : serviceList) {
			if (classAsk.isAssignableFrom(service.getClass())) {
				return (S) service;
			}
		}
		Gdx.app.setLogLevel(Application.LOG_ERROR);
		Gdx.app.log("service manager", "service not found : " + classAsk.toString());
		return null;
	}

	public static void registerService(AbstractGameManager gameService) {
		serviceList.add(gameService);
	}

	@Override
	public void dispose() {
		for (AbstractGameManager service : serviceList) {
			service.dispose();
		}
	}
}