package com.example.demo.example.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CountDownLatchExample2 {

	private final static int threadCount = 200;
	
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
		for (int i = 0; i < threadCount; i++) {
			final int threadNum = i;
			exec.execute(()->{
				try {
					test(threadNum);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					countDownLatch.countDown();
				}
			});
		}
		countDownLatch.await();
		log.info("finish");
	}
	
	private static void test(int i) throws  Exception {
		Thread.sleep(100);
		log.info("{}", i);
		Thread.sleep(100);
	}
}
