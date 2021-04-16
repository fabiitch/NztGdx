package com.nzt.gdx.test.trials.st.shape;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.debug.hud.base.HudDebug;
import com.nzt.gdx.input.impl.simple.SimpleClickInputHandler;
import com.nzt.gdx.math.shape.Triangle;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreenWithHudDebug;
import com.nzt.gdx.test.trials.tester.selector.TestScreen;
import com.nzt.gdx.utils.GdxUtils;

@TestScreen(group = "shape")
public class STTriangle extends TestScreenWithHudDebug {

	private int mode = 0;
	Vector2 middle = GdxUtils.getScreenCenter(new Vector2());
	Triangle triangle;
	private Vector2 a, b, c;
	private final Vector2 tmp = new Vector2();

	BitmapFont font;

	public STTriangle(FastTesterMain main) {
		super(main);
		this.font = new BitmapFont();
		HudDebug.addBotLeft("Mode", "normal");
		changeMode();

		HudDebug.addTopRight("Angle A", triangle.getAngleDeg(0));
		HudDebug.addTopRight("Angle B", triangle.getAngleDeg(1));
		HudDebug.addTopRight("Angle C", triangle.getAngleDeg(2));

		HudDebug.addTopLeft("A", a);
		HudDebug.addTopLeft("B", b);
		HudDebug.addTopLeft("C", c);

		HudDebug.addLeftMiddle("Dir AB", Vector2.X);
		HudDebug.addLeftMiddle("Dir AC", Vector2.X);
		HudDebug.addLeftMiddle("Dir BC", Vector2.X);

		HudDebug.addTopLeft("Rotation", 0);
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

		spriteBatch.begin();
		triangle.getA(tmp);
		font.draw(spriteBatch, "A", tmp.x, tmp.y);
		triangle.getB(tmp);
		font.draw(spriteBatch, "B", tmp.x, tmp.y);
		triangle.getC(tmp);
		font.draw(spriteBatch, "C", tmp.x, tmp.y);

		spriteBatch.end();
		count++;
		if (count > 4) {
			count = 0;
			updateHud();
		}

	}

	private int count = 0;

	private void updateHud() {
		HudDebug.update("A", triangle.getVertex(tmp, 0));
		HudDebug.update("B", triangle.getVertex(tmp, 1));
		HudDebug.update("C", triangle.getVertex(tmp, 2));
		HudDebug.update("Rotation", triangle.getRotation());

		HudDebug.update("Dir AB", triangle.getDir(tmp, 0, 1));
		HudDebug.update("Dir AC", triangle.getDir(tmp, 0, 2));
		HudDebug.update("Dir BC", triangle.getDir(tmp, 1, 2));
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

		if (triangle.getRotation() > 360) {
			triangle.setRotation(0);
		}

	}

	private void changeMode() {
		switch (mode) {
		case 0:
			a = v(0, 0);
			b = v(50, 0);
			c = v(0, 50);
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

	public void doDispose() {
		super.doDispose();
		font.dispose();
	}

}
