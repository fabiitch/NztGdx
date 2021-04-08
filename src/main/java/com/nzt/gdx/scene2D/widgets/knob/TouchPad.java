package com.nzt.gdx.scene2D.widgets.knob;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.nzt.gdx.math.vectors.VectorUtils;
import com.nzt.gdx.scene2D.StagePlacementUtils;

public class TouchPad extends WidgetGroup {

	private Image imageBase;
	private Image imageKnob;

	private Vector2 posBase = new Vector2();
	private Vector2 posKnob = new Vector2();

	public Vector2 direction = new Vector2();
	public float force = 0f;

	private Vector2 tmp = new Vector2();
	private TouchPadConfig config;

	public TouchPad(TouchPadConfig config) {
		this.config = config;
	}

	private void init() {
		imageBase = new Image(config.drawableBase);
		imageBase.setSize(config.sizeBase, config.sizeBase);
		imageBase.setPosition(config.posInactive.x, config.posInactive.y);
		addActor(imageBase);

		imageKnob = new Image(config.drawableKnob);
		imageKnob.setSize(config.sizeKnob, config.sizeKnob);
		imageKnob.setPosition(config.posInactive.x, config.posInactive.y);
		addActor(imageBase);
		desactive();
	}

	public void updateDirForce() {
		this.direction.set(posKnob).sub(posBase).nor();
		float dst = posBase.dst(posKnob);
		this.force = Math.min(1, dst / config.sizeBase / 2);
	}

	public void desactive() {
		imageKnob.setColor(1, 1, 1, 0.2f);
		imageBase.setColor(1, 1, 1, 0.2f);
		imageBase.setPosition(config.posInactive.x, config.posInactive.y);
		imageKnob.setPosition(config.posInactive.x, config.posInactive.y);
	}

	public void active() {
		imageKnob.setColor(1, 1, 1, 1);
		imageBase.setColor(1, 1, 1, 1);
	}

	public void moveTouchPad(float x, float y) {
		moveBase(x, y);
		moveKnob(x, y);
	}

	public void moveBase(float x, float y) {
		StagePlacementUtils.placeCenter(imageBase, x, y);
		StagePlacementUtils.getCenterPos(imageBase, posBase);
	}

	public void moveKnob(float x, float y) {
		StagePlacementUtils.placeCenter(imageKnob, x, y);
		StagePlacementUtils.getCenterPos(imageKnob, posKnob);
		float dstToBase = posKnob.dst(posBase);
		if (dstToBase > config.sizeBase / 2) {
			Vector2 directionTo = VectorUtils.directionTo(posKnob, posBase);
			posBase.add(directionTo.scl(dstToBase - config.sizeBase / 2));
			StagePlacementUtils.placeCenter(imageBase, posBase);
		}
		this.updateDirForce();
	}
}
