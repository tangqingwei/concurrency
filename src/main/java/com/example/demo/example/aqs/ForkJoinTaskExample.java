package com.example.demo.example.aqs;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ForkJoinTaskExample extends RecursiveTask<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int threshold = 2;
	private int start;
	private int end;
	
	public ForkJoinTaskExample(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected Integer compute() {
		int sum = 0;
		//如果任务足够小就计算任务
		boolean canCompute = (end - start) <= threshold;
		if (canCompute) {
			for (int i = start; i <= end; i++) {
				sum += i;
			}
		}else {
			//如果任务大于阈值，就分裂成两个子任务计算
			int middle = (start + end) / 2;
			ForkJoinTaskExample leftTask = new ForkJoinTaskExample(start, middle);
			ForkJoinTaskExample righTask = new ForkJoinTaskExample(middle + 1, end);
			//执行子任务
			leftTask.fork();
			righTask.fork();
			
			//等待任务执行结束合并其结果
			int leftResult = leftTask.join();
			int rightResult = righTask.join();
			
			//合并子任务
			sum = leftResult + rightResult;
		}
		
		
		
		return sum;
	}
	
	public static void main(String[] args) {
		
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		//生成一个计算任务，计算 1+2+3+4
		ForkJoinTaskExample task = new ForkJoinTaskExample(1, 100);
		//执行一个任务
		Future<Integer> result = forkJoinPool.submit(task);
		try {
			log.info("result:{}", result.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
