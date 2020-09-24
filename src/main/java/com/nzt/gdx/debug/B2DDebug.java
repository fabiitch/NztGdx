package com.nzt.gdx.debug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.logger.LoggerUtils;

//TODO a revoir le champ world en static
public class B2DDebug {

	private static World world;

	public static void init(World world) {
		B2DDebug.world = world;
	}

	public static void logInfo() {
		LoggerUtils.logSeparator("Box2D Debug");
		Gdx.app.log("Body count", world.getBodyCount() + "");
		Gdx.app.log("Contact count", world.getContactCount() + "");
		Gdx.app.log("Fixture count", world.getFixtureCount() + "");
		Gdx.app.log("Joint count", world.getJointCount() + "");
		Gdx.app.log("Proxy count", world.getProxyCount() + "");
		Gdx.app.log("World VelocityThreshold", World.getVelocityThreshold() + "");
		
		LoggerUtils.logSeparator("Box2D Debug End");
	}

}
