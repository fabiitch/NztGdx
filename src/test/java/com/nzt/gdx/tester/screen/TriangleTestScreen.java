package com.nzt.gdx.tester.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.nzt.gdx.archi.AbstractMain;
import com.nzt.gdx.screen.BaseScreen;

public class TriangleTestScreen extends BaseScreen {

	Texture tt = new Texture("mur.jpg");

	public TriangleTestScreen(AbstractMain main) {
		super(main);
	}

	@Override
	protected void renderScreen(float dt) {

		Rectangle rect = new Rectangle(100, 200, 50, 50);

		shapeRenderer.begin();
		shapeRenderer.rect(100, 200, 40, 40);
		shapeRenderer.end();

		spriteBatch.begin();
		spriteBatch.draw(tt, 0, 0);
		spriteBatch.end();
	}

	@Override
	public void doShow() {
		// TODO Auto-generated method stub
		
	}

}
