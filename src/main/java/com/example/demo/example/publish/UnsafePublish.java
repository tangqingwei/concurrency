package com.example.demo.example.publish;

import java.util.Arrays;

import com.example.demo.annoations.NotThreadSafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
public class UnsafePublish {

	public String[] states = {"a","b","c"};
	
	public String[] getStates() {
		return states;
	}
	
	
	public static void main(String[] args) {
		UnsafePublish unsafePublish = new UnsafePublish();
		log.info("{}",Arrays.toString(unsafePublish.getStates()));
		
		unsafePublish.getStates()[0] = "d";
		log.info("{}",Arrays.toString(unsafePublish.getStates()));
	}
}
