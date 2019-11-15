package com.nzt.gdx.archi;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

public class GameServiceManager implements Disposable {
	private static Array<AbstractGameService> serviceList = new Array<AbstractGameService>();

	@SuppressWarnings("unchecked")
	public static <S extends AbstractGameService> S getGameService(Class<S> classAsk) {
		for (AbstractGameService service : serviceList) {
			if (classAsk.isAssignableFrom(service.getClass())) {
				return (S) service;
			}
		}
		Gdx.app.setLogLevel(Application.LOG_ERROR);
		Gdx.app.log("service manager", "service not found : " + classAsk.toString());
		return null;
	}

	public static void registerService(AbstractGameService gameService) {
		serviceList.add(gameService);
	}

	@Override
	public void dispose() {
		for (AbstractGameService service : serviceList) {
			service.dispose();
		}
	}
}