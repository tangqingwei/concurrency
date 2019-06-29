package com.example.demo.example.commonUnsafe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import com.example.demo.annoations.NotThreadSafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
public class DateFormatExample2 {

	
	
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
		
	}
	
	
	public static void update() {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			simpleDateFormat.parse("20180208");
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
	}
}
