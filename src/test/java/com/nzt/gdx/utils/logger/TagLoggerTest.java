package com.nzt.gdx.utils.logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TagLoggerTest {

	private static String TAG_1 = "Tag_1";
	private static String TAG_2 = "Tag_2";

	@Before
	public void initTagLogger() {
		TagLogger.clear();
	}

	@Test
	public void activeAndDesactiveTagTest() {
		TagLogger.activeTag(TAG_1);
		assertEquals(TagLogger.tagMap.size(), 1);
		Boolean tagActive = TagLogger.tagMap.get(TAG_1);
		assertTrue(tagActive);

		TagLogger.desactiveTag(TAG_1);
		tagActive = TagLogger.tagMap.get(TAG_1);
		assertFalse(tagActive);

		TagLogger.activeTag(TAG_1);
		tagActive = TagLogger.tagMap.get(TAG_1);
		assertTrue(tagActive);
	}

	@Test
	public void desactiveAndActiveAllTagsTest() {
		TagLogger.activeTag(TAG_1);
		TagLogger.activeTag(TAG_2);
		assertEquals(TagLogger.tagMap.size(), 2);
		Boolean tag1Active = TagLogger.tagMap.get(TAG_1);
		Boolean tag2Active = TagLogger.tagMap.get(TAG_2);
		assertTrue(tag1Active);
		assertTrue(tag2Active);

		TagLogger.desactiveAllTag();
		tag1Active = TagLogger.tagMap.get(TAG_1);
		tag2Active = TagLogger.tagMap.get(TAG_2);
		assertFalse(tag1Active);
		assertFalse(tag2Active);

		TagLogger.activeAllTag();
		tag1Active = TagLogger.tagMap.get(TAG_1);
		tag2Active = TagLogger.tagMap.get(TAG_2);
		assertTrue(tag1Active);
		assertTrue(tag2Active);
	}
}
