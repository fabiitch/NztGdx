package com.nzt.gdx.utils.logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.nzt.gdx.init.GdxHeadLessInitialiser;

public class TagCountLoggerTest extends GdxHeadLessInitialiser {
	private enum LogTagEnum {
		PERFORMANCE, INPUT
	}

	@Before
	public void initTagLogger() {
		TagCountLogger.clear();
	}

	@Test
	public void tagLogCountTest() {
		TagCountLogger.log(LogTagEnum.PERFORMANCE, "log 1");
		TagCountLogger.log(LogTagEnum.PERFORMANCE, "log 2");
		TagCountLogger.log(LogTagEnum.PERFORMANCE, "log 3");
		// test map of TagLogger and TagCounter logger
		assertEquals(TagCountLogger.tagCountMap.size(), 1);
		assertEquals(TagLogger.tagMap.size(), 1);

		LogTagValues logTagValues = TagCountLogger.tagCountMap.get(LogTagEnum.PERFORMANCE);
		assertTrue(logTagValues != null);
		assertEquals(logTagValues.count, 3);
	}

	@Test
	public void resetCountTagTest() {
		TagCountLogger.log(LogTagEnum.PERFORMANCE, "log 1");
		TagCountLogger.log(LogTagEnum.PERFORMANCE, "log 2");
		TagCountLogger.log(LogTagEnum.PERFORMANCE, "log 3");
		// test map of TagLogger and TagCounter logger
		LogTagValues logTagValues = TagCountLogger.tagCountMap.get(LogTagEnum.PERFORMANCE);
		assertTrue(logTagValues != null);
		assertEquals(logTagValues.count, 3);
		TagCountLogger.resetTag(LogTagEnum.PERFORMANCE);
		assertEquals(logTagValues.count, 0);
	}
}
