package com.nzt.gdx.logger;

import com.badlogic.gdx.Gdx;

//TODO pourri
public class LoggerHelper {

	String blockName;
	StringBuffer sb;

	private static String SEPARATOR_NAME_VALUE = "###";
	private static String SEPARATOR_LINE = "|||";

	LoggerHelper() {
		sb = new StringBuffer();
	}

	LoggerHelper(String name) {
		this.blockName = name;
		sb = new StringBuffer();
	}

	public LoggerHelper add(String name, String value) {
		sb.append(name).append(SEPARATOR_NAME_VALUE).append(value).append(SEPARATOR_LINE);
		return this;
	}

	public LoggerHelper add(String value) {
		sb.append(blockName).append(SEPARATOR_NAME_VALUE).append(value).append(SEPARATOR_LINE);
		return this;
	}

	public void log() {
		String split[] = sb.toString().split(SEPARATOR_LINE);
		Gdx.app.log(blockName, "Start == " + blockName);
		for (String s : split) {
			String[] split2 = s.split(SEPARATOR_NAME_VALUE);
			Gdx.app.log(split2[0], split2[1]);
		}
		Gdx.app.log(blockName, "End   == " + blockName);
	}

}
