package com.example.demo.example.publish;

import com.example.demo.annoations.NotRecommend;
import com.example.demo.annoations.NotThreadSafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

	public int thisCanBeEscape = 0;
	public Escape() {
		new InnerClass();
	}
	
	private class InnerClass {
		public InnerClass() {
			log.info("{}", Escape.this.thisCanBeEscape);
		}
	}
	
	public static void main(String[] args) {
		new Escape();
	}
}
