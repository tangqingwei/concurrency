package com.example.demo.example.syncContainer;

import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import com.example.demo.annoations.ThreadSafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadSafe
public class VectorExample1 {

	private static Vector<Integer> list = new Vector<Integer>();
	
	//请求总行数
	public static int clientTotal = 5000;
	//同时并发执行的线程数
	public static int treadTotal = 200;
	
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		final Semaphore semaphore = new Semaphore(treadTotal);
		final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
		for (int i = 0; i < clientTotal; i ++) {
			executorService.execute(() -> {
				try {
					semaphore.acquire();
					update();
					semaphore.release();
				} catch (Exception e) {
					log.error("exception", e);
				}
				countDownLatch.countDown();
			});
		}
		
		countDownLatch.await();
		executorService.shutdown();
		
		log.info("size:{}",list.size());
		
	}
	
	
	public static void update() {
//		log.info("{},{}");
		list.add(1);
	}
}
