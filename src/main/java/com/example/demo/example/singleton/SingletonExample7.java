package com.example.demo.example.singleton;

import com.example.demo.annoations.Recommend;
import com.example.demo.annoations.ThreadSafe;
/**
 * 枚举模式 安全
 * @author sqhtech
 *
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

	//私有构造函数
		private SingletonExample7() {}
		
		public static SingletonExample7 getInstance() {
			return Singleton.INSTANCE.getInstance();
		}
		
		
		private enum Singleton {
			INSTANCE;
			private SingletonExample7 singleton;
			
			//JVM保证这个方法绝对只调用一次
			private Singleton() {
				singleton = new SingletonExample7();
			}
			
			public SingletonExample7 getInstance() {
				return singleton;
			}
		}
}
