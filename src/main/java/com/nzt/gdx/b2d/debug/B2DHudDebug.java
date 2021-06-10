package com.nzt.gdx.b2d.debug;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.debug.hud.HudDebugPosition;
import com.nzt.gdx.debug.hud.core.HudDebug;

public class B2DHudDebug {

	private B2DHudDebug() {

	}

	public static void initHudDebug(World world) {
		B2DHudDebug.initHudDebug(world, HudDebugPosition.TOP_RIGHT, Color.RED);
	}

	public static void initHudDebug(World world, int positionOnStage, Color color) {
		HudDebug.addItem("Body count", world.getBodyCount(), positionOnStage, color);
		HudDebug.addItem("Contact count", world.getContactCount(), positionOnStage, color);
		HudDebug.addItem("Fixture count", world.getFixtureCount(), positionOnStage, color);
		HudDebug.addItem("Joint count", world.getJointCount(), positionOnStage, color);
		HudDebug.addItem("Proxy count", world.getProxyCount(), positionOnStage, color);
		HudDebug.addItem("World VelocityThreshold", World.getVelocityThreshold(), positionOnStage, color);
	}

	public static void updateHudDebug(World world) {
		HudDebug.update("Body count", world.getBodyCount());
		HudDebug.update("Contact count", world.getContactCount());
		HudDebug.update("Fixture count", world.getFixtureCount());
		HudDebug.update("Joint count", world.getJointCount());
		HudDebug.update("Proxy count", world.getProxyCount());
		HudDebug.update("World VelocityThreshold", World.getVelocityThreshold());
	}

}
