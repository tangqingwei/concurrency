package com.example.demo.example.lock;

import java.sql.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.example.demo.annoations.ThreadSafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LockExample3 {

	
	private final Map<String, Data> map = new TreeMap<String, LockExample3.Data>();
	
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	private final Lock readLock = lock.readLock();
	private final Lock writeLock = lock.writeLock();
	
	public Data get(String key) {
		readLock.lock();
		try {
			return map.get(key);
		} finally {
			readLock.unlock();
		}
	}
	
	public Set<String> getAllkeys(){
		readLock.lock();
		try {
			return map.keySet();
		} finally {
			readLock.unlock();
		}
	}
	
	public Data put(String key, Data value) {
		writeLock.lock();
		try {
			return map.put(key, value);
		} finally {
			writeLock.unlock();
		}
	}
	
	class Data {
		
	}
	
	
}
