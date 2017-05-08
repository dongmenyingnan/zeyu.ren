package com.zeyu.dao;

import com.zeyu.controller.Singleton;

public class asdf{
	
	static Singleton a = new Singleton();
	
	private String obj  = "hello word";
	
	private asdf(int a){
		
		System.out.println(a);
	}
	
 //	public static void main(String[] args) {
//		a.a();
//		
//		String obj = "abc";
//		
//		System.out.println(obj);
//		
//		System.out.println(a.h);
//
//	}
	static class test extends asdf{
		
		test(){
			super(1);
			System.out.println("123");
		}
		
		public static void main(String[] args) {
			
			asdf a = new test();
			
			
		}
		
	}

}
