package com.nzt.gdx.scene2D.nz;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.nzt.gdx.math.Percentage;
import com.nzt.gdx.scene2D.StagePlacementUtils;


//TODo continue
public class NzActorPositionner {
	private float width;
	private float height;

	public NzActorPositionner(float width, float height) {
		this.width = width;
		this.height = width;
	}

	public void resize(float width, float height) {
		this.width = width;
		this.height = width;
	}

	Actor actor;
	boolean centerActor;

	public NzActorPositionner giveActor(Actor actor, boolean centerActor) {
		this.actor = actor;
		this.centerActor = centerActor;
		return this;
	}

	public NzActorPositionner setPositionByPercent(float percentWitdh, float percentHeight) {
		setXPercent(percentWitdh);
		setYPercent(percentHeight);
		return this;
	}

	public NzActorPositionner setSizeByPercent(float percentWitdh, float percentHeight) {
		setWidthPercent(percentWitdh);
		setHeightPercent(percentHeight);
		return this;
	}

	public NzActorPositionner setWidthPercent(float percentWitdh) {
		actor.setWidth(Percentage.getValue(percentWitdh, this.width));
		return this;
	}

	public NzActorPositionner setHeightPercent(float percentHeight) {
		actor.setHeight(Percentage.getValue(percentHeight, this.height));
		return this;
	}

	public NzActorPositionner setXPercent(float percentWitdh) {
		if (centerActor) {
			float percentXValue = Percentage.getValue(percentWitdh, this.width);
			StagePlacementUtils.placeCenterX(actor, percentXValue);
		} else {
			actor.setX(Percentage.getValue(percentWitdh, this.width));
		}
		return this;
	}

	public NzActorPositionner setYPercent(float percentHeight) {
		if (centerActor) {
			float percentYValue = Percentage.getValue(percentHeight, this.height);
			StagePlacementUtils.placeCenterY(actor, percentYValue);
		} else {
			actor.setY(Percentage.getValue(percentHeight, this.height));
		}
		return this;
	}

}
