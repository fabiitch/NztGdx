package com.nzt.gdx.test.trials.st.shapes;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Polyline;
import com.badlogic.gdx.math.Vector2;
import com.nzt.gdx.debug.hud.core.HudDebug;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreenWithHudDebug;
import com.nzt.gdx.test.trials.tester.selector.TestScreen;
import com.nzt.gdx.utils.GdxUtils;

@TestScreen(group = "shapes")
public class STPolyline extends TestScreenWithHudDebug {

	Vector2 middle = GdxUtils.getScreenCenter(new Vector2());

	Polyline polyline1 = new Polyline(new float[] { middle.x, middle.y, middle.x + 50, middle.y + 50 });

	public STPolyline(FastTesterMain main) {
		super(main);
		polyline1.setOrigin(middle.x, middle.y);

		HudDebug.addTopLeft("rotation", 0);
		HudDebug.addTopLeft("scale", scale);
	}

	float scale = 1;
	boolean up;

	@Override
	public void renderAfterHud(float dt) {
		nzShapeRenderer.begin();
		nzShapeRenderer.set(ShapeType.Filled);
		nzShapeRenderer.polyline(polyline1);
		nzShapeRenderer.end();
		polyline1.rotate(0.2f);

		if (scale > 10) {
			up = false;
			nzShapeRenderer.randomColor();
		}
		if (scale < 1) {
			up = true;
			nzShapeRenderer.randomColor();
		}

		scale = up ? scale + 0.01f : scale - 0.01f;
		polyline1.setScale(scale, scale);

		HudDebug.update("rotation", polyline1.getRotation());
		HudDebug.update("scale", polyline1.getScaleX());
	}

	@Override
	public void doDispose() {
		super.doDispose();

	}
}
