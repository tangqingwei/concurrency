package com.example.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import com.example.demo.annoations.NotThreadSafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
public class ConcurrencyTest {

	//请求总行数
	public static int clientTotal = 5000;
	//同时并发执行的线程数
	public static int treadTotal = 200;
	
	public static int count = 0;
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		final Semaphore semaphore = new Semaphore(treadTotal);
		final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
		for (int i = 0; i < clientTotal; i ++) {
			executorService.execute(() -> {
				try {
					semaphore.acquire();
					add();
					semaphore.release();
				} catch (Exception e) {
					log.error("exception", e);
				}
				countDownLatch.countDown();
			});
		}
		countDownLatch.await();
		executorService.shutdown();
		log.info("count:{}",count);
	}
	
	
	public static void add() {
		count ++;
	}
}
