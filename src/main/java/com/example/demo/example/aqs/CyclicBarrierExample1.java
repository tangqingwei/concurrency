package com.example.demo.example.aqs;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CyclicBarrierExample1 {

	private static CyclicBarrier barrier = new CyclicBarrier(5);
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int threadNum = i;
			Thread.sleep(1000);
			executorService.execute(()->{
				try {
					race(threadNum);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
	}
	
	private static void race(int i) throws Exception {
		Thread.sleep(1000);
		log.info("{} is ready", i);
		barrier.await();
		log.info("{} continue", i);
	}
}
