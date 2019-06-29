package com.example.demo.example.immutable;

import java.util.Collections;
import java.util.Map;

import com.example.demo.annoations.NotThreadSafe;
import com.example.demo.annoations.ThreadSafe;
import com.google.common.collect.Maps;

@ThreadSafe
public class ImmutableExample2 {

	
	private static Map<Integer, Integer> map = Maps.newHashMap();
	
	static {
		map.put(1, 2);
		map.put(3, 4);
		map.put(5, 6);
		map = Collections.unmodifiableMap(map);
	}
	
	public static void main(String[] args) {
		map.put(1, 3);
		
	}
	
	
}
