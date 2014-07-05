package com.ncl.test;

import org.springframework.util.Assert;

public class AssertTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println(Long.valueOf(""));
		
		String event = null;
		Assert.notNull(event, "Event must not be null");
		
		
	}

}
