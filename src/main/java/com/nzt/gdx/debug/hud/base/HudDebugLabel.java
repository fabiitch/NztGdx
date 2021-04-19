package com.nzt.gdx.debug.hud.base;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Used in HudDebug
 */
class HudDebugLabel extends Label {

	public int positionOnStage;
	public int position;

	public HudDebugLabel(int positionOnStage, int position, CharSequence text, Skin skin) {
		super(text, skin);
		this.positionOnStage = positionOnStage;
		this.position = position;
		this.setTouchable(Touchable.disabled);
	}

}
