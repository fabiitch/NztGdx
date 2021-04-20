package com.nzt.gdx.test.trials.st.ecs.anonym;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.Color;
import com.nzt.gdx.debug.hud.base.HudDebug;
import com.nzt.gdx.test.trials.tester.archi.main.FastTesterMain;
import com.nzt.gdx.test.trials.tester.archi.screens.TestScreenWithHudDebug;
import com.nzt.gdx.test.trials.tester.selector.TestScreen;

/**
 * Test to see if ashley can work with anonym class
 */
@TestScreen(group = "ecs.ashley")
public class STAshleyAnonymeSystems extends TestScreenWithHudDebug {

	Engine engine;

	public STAshleyAnonymeSystems(FastTesterMain main) {
		super(main);

		engine = new Engine();

		EntitySystem system1 = new EntitySystem() {
		};

		EntitySystem system2 = new EntitySystem() {
		};
		EntitySystem system3 = new EntitySystem() {
		};
		EntitySystem system4 = new EntitySystem() {
		};
		engine.addSystem(system1);
		engine.addSystem(system2);
		engine.addSystem(system3);
		engine.addSystem(system4);

		ImmutableArray<EntitySystem> systemsOnEngine = engine.getSystems();
		for (EntitySystem system : systemsOnEngine) {
			HudDebug.addTopLeft(system.getClass().getName(), system.toString());
		}

		if (systemsOnEngine.size() == 4) {
			HudDebug.addBotMiddle("Test Ok", "4 Systems !", Color.CYAN);
		}

	}

	@Override
	public void renderAfterHud(float dt) {
		engine.update(dt);

	}

}
