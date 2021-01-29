package com.nzt.gdx.scene2D.nz;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.nzt.gdx.math.Percentage;

/**
 * {@link com.badlogic.gdx.scenes.scene2d.Stage} extended with percent placement
 * for scale with size of screen
 * 
 * //TODO continue , do actions too
 */
public class NzStage extends Stage {

	public NzActorPositionner nzPositionner;;

	public NzStage() {
		super(new ScreenViewport());
		this.nzPositionner = new NzActorPositionner(this.getWidth(), this.getHeight());
	}

	public NzStage(Batch batch) {
		super(new ScreenViewport(), batch);
		this.nzPositionner = new NzActorPositionner(this.getWidth(), this.getHeight());
	}

	public NzActorPositionner getPositionner(Actor actor, boolean center) {
		nzPositionner.giveActor(actor, center);
		return nzPositionner;
	}

	public void resize(int width, int height) {
//		resizeAllActors(width, height);
		this.getViewport().update(width, height, true);
	}

	private void resizeAllActors(int width, int height) {
		Array<Actor> actors = getActors();
		float oldWidth = this.getWidth();
		float oldheight = this.getHeight();

		float percentWitdh = Percentage.getPercent(oldWidth, width);
		float percentHeight = Percentage.getPercent(oldheight, height);

		for (Actor actor : actors) {
			actor.setWidth(actor.getWidth() / percentWitdh * 100);
			actor.setHeight(actor.getHeight() / percentHeight * 100);

			actor.setX(actor.getX() / percentWitdh * 100);
			actor.setY(actor.getY() / percentHeight * 100);
		}
	}

	public void setPositionByPercent(Actor actor, float percentWitdh, float percentHeight) {
		setWidthPercent(actor, percentWitdh);
		setHeightPercent(actor, percentHeight);
	}

	public void setSizeByPercent(Actor actor, float percentWitdh, float percentHeight) {
		setWidthPercent(actor, percentWitdh);
		setHeightPercent(actor, percentHeight);
	}

	public void setXPercent(Actor actor, float percentWitdh) {
		actor.setX(Percentage.getValue(percentWitdh, this.getWidth()));
	}

	public void setYPercent(Actor actor, float percentWitdh) {
		actor.setY(Percentage.getValue(percentWitdh, this.getHeight()));
	}

	public void setWidthPercent(Actor actor, float percentWitdh) {
		actor.setWidth(Percentage.getValue(percentWitdh, this.getWidth()));
	}

	public void setHeightPercent(Actor actor, float percentHeight) {
		actor.setHeight(Percentage.getValue(percentHeight, this.getHeight()));
	}
}
