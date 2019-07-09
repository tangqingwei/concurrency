package com.example.demo.example.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CyclicBarrierExample2 {

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
		executorService.shutdown();
	}
	
	private static void race(int i) throws Exception {
		Thread.sleep(1000);
		log.info("{} is ready", i);
		try {
			barrier.await(2000, TimeUnit.MILLISECONDS);
		} catch (BrokenBarrierException | TimeoutException e) {
			log.warn("BarrierException",e);
		}
		log.info("{} continue", i);
	}
}
