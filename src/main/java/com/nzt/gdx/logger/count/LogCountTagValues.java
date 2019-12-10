package com.nzt.gdx.logger.count;

public class LogCountTagValues {

	public String tag;
	public int count;

	public <E extends Enum<E>> LogCountTagValues(E tag) {
		this.tag = tag.name();
		this.count = 0;
	}

}