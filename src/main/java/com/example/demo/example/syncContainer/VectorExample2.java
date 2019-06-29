package com.example.demo.example.syncContainer;

import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import com.example.demo.annoations.NotThreadSafe;
import com.example.demo.annoations.ThreadSafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
public class VectorExample2 {

	private static Vector<Integer> list = new Vector<Integer>();
	
	
	public static void main(String[] args) throws InterruptedException {
		
		
		while (true) {
			for (int i = 0; i < 10; i++) {
				list.add(i);
			}
			Thread thread1 = new Thread() {
				@Override
				public void run() {
					for (int i = 0; i < 10; i++) {
						list.remove(i);
					}
				}
			};
			
			Thread thread2 = new Thread() {
				@Override
				public void run() {
					for (int i = 0; i < 10; i++) {
						list.get(i);
					}
				}
			};
			
			thread1.start();
			thread2.start();
		}
	}
	
	
	
}
