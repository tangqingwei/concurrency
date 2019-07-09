package com.example.demo.example.aqs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SemaphoreExample3 {

	private final static int threadCount = 200;
	
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		final Semaphore semaphore = new Semaphore(3);
		for (int i = 0; i < threadCount; i++) {
			final int threadNum = i;
			
			exec.execute(()->{
				try {
					if (semaphore.tryAcquire()) {//尝试获取一个许可
						test(threadNum);
						semaphore.release();//释放一个许可
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					
				}
			});
		}
		exec.shutdown();
	}
	
	private static void test(int i) throws  Exception {
		
		log.info("{}", i);
		Thread.sleep(1000);
	}
}
