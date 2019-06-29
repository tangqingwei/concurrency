package com.example.demo.example.syncContainer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import com.example.demo.annoations.ThreadSafe;

import lombok.extern.slf4j.Slf4j;

/**
 * 示例代码显示 结果为5000（线程安全），实际测试结果与示例代码不一致
 * @author sqhtech
 *
 */
@Slf4j
@ThreadSafe
public class CollectionsExample3 {

	private static Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap<Integer, Integer>());
	
	//请求总行数
	public static int clientTotal = 5000;
	//同时并发执行的线程数
	public static int treadTotal = 200;
	
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		final Semaphore semaphore = new Semaphore(treadTotal);
		final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
		for (int i = 0; i < clientTotal; i ++) {
			final int count = i;
			executorService.execute(() -> {
				try {
					semaphore.acquire();
					update(count);
					semaphore.release();
				} catch (Exception e) {
					log.error("exception", e);
				}
				countDownLatch.countDown();
			});
		}
		
		countDownLatch.await();
		executorService.shutdown();
		
		log.info("size:{}",map.size());
		
	}
	
	
	public static void update(Integer i) {
		map.put(i, i);
	}
}
