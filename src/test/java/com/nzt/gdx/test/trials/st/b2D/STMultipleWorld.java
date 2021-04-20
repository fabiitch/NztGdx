package com.nzt.gdx.test.trials.st.b2D;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreenWithHudDebug;
import com.nzt.gdx.test.trials.tester.selector.TestScreen;

@TestScreen(group = "box2D")
public class STMultipleWorld extends TestScreenWithHudDebug {

	private World world1;
	private World world2;

	public STMultipleWorld(FastTesterMain main) {
		super(main);
		world1 = new World(Vector2.Zero, true);
		world2 = new World(Vector2.Zero, true);
		
	}

	@Override
	public void renderAfterHud(float dt) {
		world1.step(1 / 60f, 2, 6);
		world2.step(1 / 60f, 2, 6);
	}

}
