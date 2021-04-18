package com.nzt.gdx.test.api.logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.nzt.gdx.logger.tag.LogTagsBase;
import com.nzt.gdx.logger.tag.TagLogger;

/**
 * test class for{@link TagLogger}
 * @author fabiitch
 *
 */
public class TagLoggerBlockTest {

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
		TagLogger.activeTag(LogTagsBase.PERFORMANCE);
		assertEquals(TagLogger.getTags().size(), 1);
		Boolean tagActive = tagMap.get(LogTagsBase.PERFORMANCE);
		assertTrue(tagActive);

		TagLogger.desactiveTag(LogTagsBase.PERFORMANCE);
		tagActive = tagMap.get(LogTagsBase.PERFORMANCE);
		assertFalse(tagActive);

		TagLogger.activeTag(LogTagsBase.PERFORMANCE);
		tagActive = tagMap.get(LogTagsBase.PERFORMANCE);
		assertTrue(tagActive);
	}

	@Test
	public void desactiveAndActiveAllTagsTest() {
		TagLogger.activeTag(LogTagsBase.PERFORMANCE);
		TagLogger.activeTag(LogTagsBase.INPUT);
		assertEquals(TagLogger.getTags().size(), 2);
		Boolean tag1Active = tagMap.get(LogTagsBase.PERFORMANCE);
		Boolean tag2Active = tagMap.get(LogTagsBase.PERFORMANCE);
		assertTrue(tag1Active);
		assertTrue(tag2Active);

		TagLogger.desactiveAllTag(LogTagsBase.class);
		tag1Active = tagMap.get(LogTagsBase.PERFORMANCE);
		tag2Active = tagMap.get(LogTagsBase.PERFORMANCE);
		assertFalse(tag1Active);
		assertFalse(tag2Active);

		TagLogger.activeAllTag(LogTagsBase.class);
		tag1Active = tagMap.get(LogTagsBase.PERFORMANCE);
		tag2Active = tagMap.get(LogTagsBase.PERFORMANCE);
		assertTrue(tag1Active);
		assertTrue(tag2Active);
	}
}