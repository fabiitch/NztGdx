package com.nzt.gdx.entitys.concept;

import java.util.Arrays;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;

public enum GameObjectType {

	PLAYER, BALL, WALL;

	public static GameObjectType getGameObjectType(AbstractGameObject abstractGameObject) {
		for (GameObjectType type : Arrays.asList(GameObjectType.values())) {
			if (abstractGameObject.getClass().getName().toLowerCase().contains(type.toString().toLowerCase())) {
				return type;
			}
		}

//		if (abstractGameObject instanceof AbstractHero) {
//			return PLAYER;
//		} else if (abstractGameObject instanceof AbstractBullet) {
//			return BULLET;
//		}

		Gdx.app.setLogLevel(Application.LOG_ERROR);
		Gdx.app.log("GameObjectType.class Game object type problems :", abstractGameObject.getClass() + " not found");
		return null;
	}

}
