package com.example.demo.example.singleton;

import com.example.demo.annoations.NotThreadSafe;

/**
 * 懒汉模式 双重同步锁单例模式
 * 单例的实例在第一次使用的时候创建
 * @author sqhtech
 *
 */
@NotThreadSafe
public class SingletonExample4 {

	
	//单例对象
	private static SingletonExample4 instance = null;
	
	//私有构造函数
	private SingletonExample4() {}
	
	//1.memory 分配对象内存空间
	//2. 初始化对象
	//3. instance = memory 设置instance指向刚分配的内存
	
	//JVM和cpu优化，发生了指令重排
	//1.memory 分配对象内存空间
	//3. instance = memory 设置instance指向刚分配的内存
	//2. 初始化对象
	//静态工厂方法
	public static SingletonExample4 getInstance() {
		if (instance == null) {
			synchronized (SingletonExample4.class) {
				instance = new SingletonExample4();
			}
		}
		return instance;
	}
}
