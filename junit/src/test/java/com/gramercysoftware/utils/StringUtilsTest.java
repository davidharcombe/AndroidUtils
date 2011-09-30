package com.gramercysoftware.utils;

import junit.framework.TestCase;

public class StringUtilsTest extends TestCase {

	public void testCenter() {
		assertEquals("  1  ", StringUtils.center("1", 5));
		assertEquals("XX1XX", StringUtils.center("1", 5, "X"));
	}

	public void testLeftPad() {
		assertEquals("  1", StringUtils.leftPad("1", 2));
		assertEquals("XX1", StringUtils.leftPad("1", 2, "X"));
	}

	public void testRightPad() {
		assertEquals("1  ", StringUtils.rightPad("1", 2));
		assertEquals("1XX", StringUtils.rightPad("1", 2, "X"));
	}

	public void testRepeat() {
		assertEquals("XXX", StringUtils.repeat(3, "X"));
	}
}
