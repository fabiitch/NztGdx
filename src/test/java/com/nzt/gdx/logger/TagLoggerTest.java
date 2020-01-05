package com.nzt.gdx.logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.nzt.gdx.logger.tag.LogTagBase;
import com.nzt.gdx.logger.tag.TagLogger;

/**
 * test class for{@link TagLogger}
 * @author fabiitch
 *
 */
public class TagLoggerTest {

	private static Map<Enum<?>, Boolean> tagMap;

	@SuppressWarnings("unchecked")
	@Before
	public void initTagLogger()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		TagLogger.clearTags();
		Field fieldTagMap = TagLogger.class.getDeclaredField("tagMap");
		fieldTagMap.setAccessible(true);
		tagMap = (Map<Enum<?>, Boolean>) fieldTagMap.get(null);
	}

	@Test
	public void activeAndDesactiveTagTest() {
		TagLogger.activeTag(LogTagBase.PERFORMANCE);
		assertEquals(TagLogger.getTags().size(), 1);
		Boolean tagActive = tagMap.get(LogTagBase.PERFORMANCE);
		assertTrue(tagActive);

		TagLogger.desactiveTag(LogTagBase.PERFORMANCE);
		tagActive = tagMap.get(LogTagBase.PERFORMANCE);
		assertFalse(tagActive);

		TagLogger.activeTag(LogTagBase.PERFORMANCE);
		tagActive = tagMap.get(LogTagBase.PERFORMANCE);
		assertTrue(tagActive);
	}

	@Test
	public void desactiveAndActiveAllTagsTest() {
		TagLogger.activeTag(LogTagBase.PERFORMANCE);
		TagLogger.activeTag(LogTagBase.INPUT);
		assertEquals(TagLogger.getTags().size(), 2);
		Boolean tag1Active = tagMap.get(LogTagBase.PERFORMANCE);
		Boolean tag2Active = tagMap.get(LogTagBase.PERFORMANCE);
		assertTrue(tag1Active);
		assertTrue(tag2Active);

		TagLogger.desactiveAllTag(LogTagBase.class);
		tag1Active = tagMap.get(LogTagBase.PERFORMANCE);
		tag2Active = tagMap.get(LogTagBase.PERFORMANCE);
		assertFalse(tag1Active);
		assertFalse(tag2Active);

		TagLogger.activeAllTag(LogTagBase.class);
		tag1Active = tagMap.get(LogTagBase.PERFORMANCE);
		tag2Active = tagMap.get(LogTagBase.PERFORMANCE);
		assertTrue(tag1Active);
		assertTrue(tag2Active);
	}
}
