package com.example.demo.example.singleton;

import com.example.demo.annoations.ThreadSafe;

/**
 * 饿汉模式
 * 单例的实例在类装载的时候创建
 * @author sqhtech
 *
 */
@ThreadSafe
public class SingletonExample6 {

	
	//单例对象
	private static SingletonExample6 instance =null;
	
	//私有构造函数
	private SingletonExample6() {}
	
	static {
		instance = new SingletonExample6();
	}
	
	//静态工厂方法
	public static SingletonExample6 getInstance() {
		return instance;
	}
	
	public static void main(String[] args) {
		System.out.println(getInstance());
		System.out.println(getInstance());
	}
}
