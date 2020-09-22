package com.nzt.gdx.debug;

import com.badlogic.gdx.physics.box2d.World;
import com.nzt.gdx.logger.tag.LogTagBase;
import com.nzt.gdx.logger.tag.TagLogger;

//TODO a revoir le champ world en static
public class B2DDebug {

	private static World world;

	public static void init(World world) {
		B2DDebug.world = world;
	}

	public static void logInfo() {
		TagLogger.error(LogTagBase.B2D_INFO, "Body count =" + world.getBodyCount());
		TagLogger.error(LogTagBase.B2D_INFO, "Contact Count = " + world.getContactCount());
		TagLogger.error(LogTagBase.B2D_INFO, "Fixture count = " + world.getFixtureCount());
		TagLogger.error(LogTagBase.B2D_INFO, "Joint count = " + world.getJointCount());
		TagLogger.error(LogTagBase.B2D_INFO, "Proxy Count = " + world.getProxyCount());
		TagLogger.error(LogTagBase.B2D_INFO, "World VelocityThreshold = " + World.getVelocityThreshold());
	}

}
