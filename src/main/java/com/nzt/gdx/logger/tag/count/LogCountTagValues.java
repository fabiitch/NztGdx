package com.nzt.gdx.logger.tag.count;

import com.nzt.gdx.logger.tag.TagLogger;

/**
 * Values Object for {@link TagLogger}
 * contains the tag and count of call it
 * 
 * @author fabiitch
 *
 */
public class LogCountTagValues {

	public String tag;
	public int count;

	public <E extends Enum<E>> LogCountTagValues(E tag) {
		this.tag = tag.name();
		this.count = 0;
	}

}