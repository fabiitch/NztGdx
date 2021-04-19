package com.nzt.gdx.debug.hud.base;

import java.util.Collection;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.nzt.gdx.debug.hud.HudDebugPosition;

class HudDebugUtils {
	private final static float standartRight = 100;

	private HudDebugUtils() {

	}

	public static void replaceLabels(int positionOnStage, int atPosition, Stage stage,
			Map<String, HudDebugLabel> mapLabels) {
		Collection<HudDebugLabel> allLabels = mapLabels.values();
		for (HudDebugLabel hudLabel : allLabels) {
			if (hudLabel.positionOnStage == positionOnStage && hudLabel.position > atPosition) {
				hudLabel.position--;
				setDebugLabelPosition(stage, hudLabel);
			}
		}
	}

	public static void setDebugLabelPosition(Stage stage, HudDebugLabel label) {
		switch (label.positionOnStage) {
		case HudDebugPosition.TOP_LEFT:
			label.setPosition(1, stage.getViewport().getWorldHeight() - label.getHeight() * label.position - 1);
			break;
		case HudDebugPosition.TOP_MIDDLE:
			label.setPosition(stage.getViewport().getWorldWidth() / 2 - stage.getViewport().getWorldWidth() / 20,
					stage.getViewport().getWorldHeight() - label.getHeight() * label.position - 1);
			break;
		case HudDebugPosition.TOP_RIGHT:
			float witdhMax = Math.max(label.getWidth(), standartRight);
			label.setPosition(stage.getViewport().getWorldWidth() - witdhMax - 10,
					stage.getViewport().getWorldHeight() - label.getHeight() * label.position - 1);
			break;
		case HudDebugPosition.BOT_LEFT:
			label.setPosition(4, label.getHeight() * (label.position - 1) + 1);
			break;
		case HudDebugPosition.BOT_MIDDLE:
			float x = Math.max(label.getWidth() + 2, standartRight);
			label.setPosition(stage.getViewport().getWorldWidth() / 2 - stage.getViewport().getWorldWidth() / 20,
					label.getHeight() * (label.position - 1) + 1);
			break;
		case HudDebugPosition.BOT_RIGHT:
			x = Math.max(label.getWidth() + 2, standartRight);
			label.setPosition(stage.getViewport().getWorldWidth() - x, label.getHeight() * (label.position - 1) + 1);
			break;
		case HudDebugPosition.LEFT_MIDDLE:
			label.setPosition(1, stage.getViewport().getWorldHeight() / 2 + stage.getViewport().getWorldHeight() / 6
					- label.getHeight() * label.position - 1 - Gdx.graphics.getSafeInsetTop());
			break;
		case HudDebugPosition.RIGHT_MIDDLE:
			x = Math.max(label.getWidth() + 2, standartRight);
			label.setPosition(stage.getViewport().getWorldWidth() - x,
					stage.getViewport().getWorldHeight() / 2 + stage.getViewport().getWorldHeight() / 6
							- label.getHeight() * label.position - 1 - Gdx.graphics.getSafeInsetTop());
			break;
		default:
			break;
		}
	}
}
