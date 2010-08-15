package com.gramercysoftware.utils;

import java.util.List;

import junit.framework.TestCase;

public class PackageClassListerTest extends TestCase {

	public void testDirectory() {
		List<Class<?>> classes = PackageClassLister.getClasses("com.gramercysoftware.utils.pcltest");
		assertNotNull(classes);
		assertEquals(4, classes.size());
	}
	
	public void testDirectoryWithPattern() {
		List<Class<?>> classes = PackageClassLister.getClasses("com.gramercysoftware.utils.pcltest", ".*Class");
		assertNotNull(classes);
		assertEquals(3, classes.size());
	}
}
