package com.nzt.gdx.scene2D;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.nzt.gdx.main.AbstractMain;
import com.nzt.gdx.scene2D.nz.NzStage;
import com.nzt.gdx.screen.SimpleScreen;
import com.nzt.gdx.tester.FastTesterMain;
import com.nzt.gdx.tester.StarterConfigTest;

public class NzStageTestScreen extends SimpleScreen<AbstractMain> {

	public static void main(String args[]) {
		StarterConfigTest.startLwjgl(new FastTesterMain(NzStageTestScreen.class), 700, 450);
	}

	float internalTimer = 0;

//	private void changeScreenSize(int width, int height) {
//		Gdx.graphics.setWindowedMode(width, height);
//	}

	private NzStage nzStage;

	public NzStageTestScreen(AbstractMain main) {
		super(main);
		nzStage = new NzStage();
		Texture txt = new Texture("badlogic.jpg");
//
		Image img1 = new Image(txt);
		nzStage.setSizeByPercent(img1, 50, 50);
		nzStage.addActor(img1);

//		changeScreenSize(300, 200);
	}

	@Override
	protected void renderScreen(float dt) {
		nzStage.act();
		nzStage.draw();
	}

	@Override
	public void doResize(int width, int height) {
		nzStage.resize(width, height);
	}
}
