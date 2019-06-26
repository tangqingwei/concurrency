package com.example.demo.example.singleton;

import com.example.demo.annoations.ThreadSafe;

/**
 * 懒汉模式 双重同步锁单例模式
 * 单例的实例在第一次使用的时候创建
 * @author sqhtech
 *
 */

@ThreadSafe
public class SingletonExample5 {

	
	//单例对象 volatile + 双重检测机制 禁止 指令重排
	private volatile static SingletonExample5 instance = null;
	
	//私有构造函数
	private SingletonExample5() {}
	
	//1.memory 分配对象内存空间
	//2. 初始化对象
	//3. instance = memory 设置instance指向刚分配的内存
	
	
	//静态工厂方法
	public static SingletonExample5 getInstance() {
		if (instance == null) {
			synchronized (SingletonExample5.class) {
				instance = new SingletonExample5();
			}
		}
		return instance;
	}
}
