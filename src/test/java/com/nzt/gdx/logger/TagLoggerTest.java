package com.nzt.gdx.logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.nzt.gdx.logger.LogTagBase;
import com.nzt.gdx.logger.TagLogger;

public class TagLoggerTest {

	@Before
	public void initTagLogger() {
		TagLogger.clear();
	}

	@Test
	public void activeAndDesactiveTagTest() {
		TagLogger.activeTag(LogTagBase.PERFORMANCE);
		assertEquals(TagLogger.tagMap.size(), 1);
		Boolean tagActive = TagLogger.tagMap.get(LogTagBase.PERFORMANCE);
		assertTrue(tagActive);

		TagLogger.desactiveTag(LogTagBase.PERFORMANCE);
		tagActive = TagLogger.tagMap.get(LogTagBase.PERFORMANCE);
		assertFalse(tagActive);

		TagLogger.activeTag(LogTagBase.PERFORMANCE);
		tagActive = TagLogger.tagMap.get(LogTagBase.PERFORMANCE);
		assertTrue(tagActive);
	}

	@Test
	public void desactiveAndActiveAllTagsTest() {
		TagLogger.activeTag(LogTagBase.PERFORMANCE);
		TagLogger.activeTag(LogTagBase.INPUT);
		assertEquals(TagLogger.tagMap.size(), 2);
		Boolean tag1Active = TagLogger.tagMap.get(LogTagBase.PERFORMANCE);
		Boolean tag2Active = TagLogger.tagMap.get(LogTagBase.PERFORMANCE);
		assertTrue(tag1Active);
		assertTrue(tag2Active);

		TagLogger.desactiveAllTag(LogTagBase.class);
		tag1Active = TagLogger.tagMap.get(LogTagBase.PERFORMANCE);
		tag2Active = TagLogger.tagMap.get(LogTagBase.PERFORMANCE);
		assertFalse(tag1Active);
		assertFalse(tag2Active);

		TagLogger.activeAllTag(LogTagBase.class);
		tag1Active = TagLogger.tagMap.get(LogTagBase.PERFORMANCE);
		tag2Active = TagLogger.tagMap.get(LogTagBase.PERFORMANCE);
		assertTrue(tag1Active);
		assertTrue(tag2Active);
	}
}
