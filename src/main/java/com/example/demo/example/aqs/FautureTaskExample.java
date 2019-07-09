package com.example.demo.example.aqs;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FautureTaskExample {

	
	//与示例代码的结果顺序不一致
	public static void main(String[] args) throws Exception {
		FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {

			@Override
			public String call() throws Exception {
				log.info("do something in callable");
				Thread.sleep(5000);
				return "Done";
			}
			
		});
		
		new Thread(futureTask).start();
		
		log.info("do something in main");
		
		Thread.sleep(1000);
		
		String result = futureTask.get();
		log.info("resukt: {}", result);
	}
}
