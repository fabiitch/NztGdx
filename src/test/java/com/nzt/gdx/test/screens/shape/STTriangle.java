package com.nzt.gdx.test.screens.shape;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.debug.hud.base.HudDebug;
import com.nzt.gdx.input.impl.simple.SimpleClickInputHandler;
import com.nzt.gdx.math.shape.Triangle;
import com.nzt.gdx.test.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.tester.archi.screens.TestScreenWithHudDebug;
import com.nzt.gdx.test.tester.selector.TestScreen;
import com.nzt.gdx.utils.GdxUtils;

@TestScreen(group = "shape")
public class STTriangle extends TestScreenWithHudDebug {

	private int mode = 0;
	Vector2 middle = GdxUtils.getScreenCenter(new Vector2());
	Triangle triangle;
	private Vector2 a, b, c;
	private final Vector2 tmp = new Vector2();

	public STTriangle(FastTesterMain main) {
		super(main);
		HudDebug.addBotLeft("Mode", "normal");
		changeMode();

		HudDebug.addTopLeft("A", a);
		HudDebug.addTopLeft("B", b);
		HudDebug.addTopLeft("C", c);

		HudDebug.addTopLeft("rotation", 0);
		SimpleClickInputHandler inputHandler = new SimpleClickInputHandler() {
			@Override
			public boolean doTouchDown(int screenX, int screenY, int pointer, int button) {
				mode++;
				changeMode();
				return false;
			}

			@Override
			public boolean doTouchUp(int screenX, int screenY, int pointer, int button) {
				return false;
			}

			@Override
			public boolean doScrolled(float amountX, float amountY) {
				System.out.println("scroll " + amountX + "  " + amountY);
				return false;
			}
		};
		Gdx.input.setInputProcessor(inputHandler);
	}

	@Override
	public void renderAfterHud(float dt) {
		triangle.rotate(0.2f);
		scaleRotate();
		nzShapeRenderer.begin();
		nzShapeRenderer.set(ShapeType.Filled);
		nzShapeRenderer.triangle(triangle);
		nzShapeRenderer.end();

		HudDebug.update("A", triangle.getVertex(tmp, 0));
		HudDebug.update("B", triangle.getVertex(tmp, 1));
		HudDebug.update("C", triangle.getVertex(tmp, 2));;
		HudDebug.update("rotation", triangle.getRotation());
	}

	float scale = 1;
	boolean up;

	private void scaleRotate() {
		if (scale > 5) {
			up = false;
			nzShapeRenderer.randomColor();
		}
		if (scale < 1) {
			up = true;
			nzShapeRenderer.randomColor();
		}
		scale = up ? scale + 0.02f : scale - 0.02f;
		triangle.setScale(scale, scale);
		
		if(triangle.getRotation()>360) {
			triangle.setRotation(0);
		}
			
	}

	private void changeMode() {
		switch (mode) {
		case 0:
			a = v(-50, 0);
			b = v(50, 50);
			c = v(-50, -50);
			HudDebug.update("Mode", "normal");
			break;

		default:
			break;
		}
		construct();
	}

	private void construct() {
		this.triangle = new Triangle(a, b, c);
		triangle.setOrigin(middle);
	}

	private Vector2 v(float x, float y) {
		return new Vector2(x, y).add(middle);
	}

}
