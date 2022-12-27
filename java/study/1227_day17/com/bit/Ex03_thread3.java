package com.bit;

import java.util.*;

public class Ex03_thread3 implements Runnable {

	public static void main(String[] args) {
		
		Runnable runner = new Ex03_thread3();
		Thread thr2 = new Thread(runner);
		thr2.start();
		Thread thr = Thread.currentThread();
		String name = thr.getName();
		System.out.println(name + " start .. ");

		List list = new LinkedList();
		
		for(int i = 0; i<100000; i++) {
			list.add(i);
		}
		
		System.out.println(name + " end .. ");

	}
	
	@Override
	public void run() {
		Thread thr = Thread.currentThread();
		String name = thr.getName();
		
		System.out.println(name + " start ... ");
		List list = new LinkedList();
		
		for(int i = 0; i<100000; i++) {
			list.add(i);
		}
		System.out.println(name + " end ...");
	}

}
