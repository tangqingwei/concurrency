package com.example.demo.example.aqs;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FutureExample {

	static class MyCallable implements Callable<String>{

		@Override
		public String call() throws Exception {
			log.info("do something in callable");
			Thread.sleep(5000);
			return "Done";
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		ExecutorService service = Executors.newCachedThreadPool();
		Future<String> future = service.submit(new MyCallable());
		log.info("do something main");
		Thread.sleep(1000);
		String result = future.get();
		log.info("resukt: {}", result);
	}
}
