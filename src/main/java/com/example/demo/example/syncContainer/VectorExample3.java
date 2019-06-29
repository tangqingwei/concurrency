package com.example.demo.example.syncContainer;

import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import com.example.demo.annoations.NotThreadSafe;
import com.example.demo.annoations.ThreadSafe;

import lombok.extern.slf4j.Slf4j;

public class VectorExample3 {

	private static Vector<Integer> list = new Vector<Integer>();

	private static void test2(Vector<Integer> v1) {
		Iterator<Integer> iterator = v1.iterator();
		while (iterator.hasNext()) {
			Integer integer = (Integer) iterator.next();
			if (integer.equals(3)) {
				v1.remove(integer);
			}
		}
	}

	private static void test3(Vector<Integer> v1) {
		for (int i = 0; i < v1.size(); i++) {
			if (v1.get(i).equals(3)) {
				v1.remove(i);
			}
		}
	}

	private static void test1(Vector<Integer> v1) {
		for (Integer integer : v1) {
			if (integer.equals(3)) {
				v1.remove(integer);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		Vector<Integer> vector = new Vector<Integer>();
		vector.add(1);
		vector.add(2);
		vector.add(3);
		
		test1(vector);
//		test2(vector);
//		test3(vector);

	}

}
