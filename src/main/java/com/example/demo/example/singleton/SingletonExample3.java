package com.example.demo.example.singleton;

import com.example.demo.annoations.NotRecommend;
import com.example.demo.annoations.ThreadSafe;

/**
 * 懒汉模式
 * 单例的实例在第一次使用的时候创建
 * @author sqhtech
 *
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

	
	//单例对象
	private static SingletonExample3 instance = null;
	
	//私有构造函数
	private SingletonExample3() {}
	
	//静态工厂方法
	public static synchronized SingletonExample3 getInstance() {
		if (instance == null) {
			instance = new SingletonExample3();
		}
		return instance;
	}
}
