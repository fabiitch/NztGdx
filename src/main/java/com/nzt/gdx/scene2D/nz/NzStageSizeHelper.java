//package com.nzt.gdx.scene2D.nz;
//
//import com.badlogic.gdx.scenes.scene2d.Actor;
//import com.nzt.gdx.math.Percentage;
//
//public class NzStageSizeHelper {
//
//	private NzStage nzStage;
//
//	public float width;
//	public float height;
//
//	public NzStageSizeHelper(NzStage nzStage) {
//		this.nzStage = nzStage;
//		this.width = nzStage.getWidth();
//		this.height = nzStage.getHeight();
//	}
//
//	public void setSizeByPercent(Actor actor, float percentWitdh, float percentHeight) {
//		setWidthPercent(actor, percentWitdh);
////        setHeightPercent();
//	}
//
//	public void setWidthPercent(Actor actor, float percentWitdh) {
//		actor.setWidth(Percentage.getValue(percentWitdh, this.getWidth()));
//	}
//
//	public void setHeightPercent(Actor actor, float percentHeight) {
//		actor.setWidth(Percentage.getValue(percentHeight, this.getWidth()));
//	}
//}
