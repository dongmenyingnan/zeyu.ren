package com.zeyu.controller;

public class Singleton {

	private static final Singleton instance = new Singleton();
	
	public String h ="asdf";
	public static void a(){
		
	}
  

	public Singleton() {
	}
	//通过一个静态方法向外界提供这个类的实例
	public static Singleton getInstance() {
	   return instance;
	}
}
