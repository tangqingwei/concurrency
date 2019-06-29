package com.example.demo.example.immutable;

import java.util.Map;

import com.example.demo.annoations.NotThreadSafe;
import com.google.common.collect.Maps;

@NotThreadSafe
public class ImmutableExample1 {

	private final static Integer a = 1;
	private final static String b = "2";
	private final static Map<Integer, Integer> map = Maps.newHashMap();
	
	static {
		map.put(1, 2);
		map.put(3, 4);
		map.put(5, 6);
	}
	
	public static void main(String[] args) {
//		a = 2;
//		b = "3";
//		map = Maps.newHashMap();
		
	}
	
	private void test(final int a) {
//		a = 1;
	}
}
