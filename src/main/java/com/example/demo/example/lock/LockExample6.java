package com.example.demo.example.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LockExample6 {

	public static void main(String[] args) {
		ReentrantLock reentrantLock = new ReentrantLock();
		Condition condition = reentrantLock.newCondition();
		
		new Thread(() -> {
			try {
				reentrantLock.lock();
				log.info("wait signal");
				condition.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
			log.info("get signal");
		}).start();
		
		new Thread(()->{
			reentrantLock.lock();
			log.info("get lock");
			try {
				Thread.sleep(3000);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			condition.signalAll();
			log.info("send signal ~");
			reentrantLock.unlock();
		}).start();
	}
}
