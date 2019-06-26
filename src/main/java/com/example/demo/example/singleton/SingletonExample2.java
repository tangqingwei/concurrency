package com.example.demo.example.singleton;

import com.example.demo.annoations.NotThreadSafe;
import com.example.demo.annoations.ThreadSafe;

/**
 * 饿汉模式
 * 单例的实例在类装载的时候创建
 * @author sqhtech
 *
 */
@ThreadSafe
public class SingletonExample2 {

	
	//单例对象
	private static SingletonExample2 instance = new SingletonExample2();
	
	//私有构造函数
	private SingletonExample2() {}
	
	//静态工厂方法
	public static SingletonExample2 getInstance() {
		return instance;
	}
}
