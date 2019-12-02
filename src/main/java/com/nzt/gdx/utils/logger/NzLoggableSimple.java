package com.nzt.gdx.utils.logger;

public class NzLoggableSimple implements NzLoggable {

	private final String tag;
	private final String value;

	public NzLoggableSimple(String tag, String value) {
		this.tag = tag;
		this.value = value;
	}

	@Override
	public String gdxLogTag() {
		return tag;
	}

	@Override
	public String gdxLogValue() {
		return value;
	}

}
