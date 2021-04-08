package com.nzt.gdx.scene2D.widgets.knob;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.nzt.gdx.graphics.DrawableUtils;

public class TouchPadConfig {

	public Drawable drawableBase;
	public Drawable drawableKnob;

	public boolean isFixed; // base dont follow knob

	public Vector2 posInactive;

	public float sizeBase;
	public float sizeKnob;

	public TouchPadConfig(Drawable drawableBase, Drawable drawableKnob, boolean isFixed, Vector2 posInactive,
			float sizeBase, float sizeKnob) {
		super();
		this.drawableBase = drawableBase;
		this.drawableKnob = drawableKnob;
		this.isFixed = isFixed;
		this.posInactive = posInactive;
		this.sizeBase = sizeBase;
		this.sizeKnob = sizeKnob;
	}

	public TouchPadConfig(Texture textureBase, Texture textureKnob, boolean isFixed, Vector2 posInactive,
			float sizeBase, float sizeKnob) {
		super();
		this.drawableBase = DrawableUtils.fromTexture(textureBase);
		this.drawableKnob = DrawableUtils.fromTexture(textureKnob);
		this.isFixed = isFixed;
		this.posInactive = posInactive;
		this.sizeBase = sizeBase;
		this.sizeKnob = sizeKnob;
	}

}
