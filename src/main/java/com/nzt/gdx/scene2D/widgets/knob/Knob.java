package com.nzt.gdx.scene2D.widgets.knob;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;

//TODO
public class Knob extends WidgetGroup {
	private Image imageBase;
	private Image imageKnob;

	private KnobConfig knobConfig;

	public Knob(KnobConfig knobConfig) {
		this.knobConfig = knobConfig;
	}

	public void dispose() {

	}
}
