package com.priv;

import java.util.*;

interface Branch {
	void show();
}

class Tree implements Branch {
	public void show() {
		System.out.println("hello!");
	}
	
	void func01() {
		System.out.println("Tree func!");
	}
}

public class Priv04 {
	public static void main(String[] args) {
		
		
	}
}
