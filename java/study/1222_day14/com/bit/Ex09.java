package com.bit;

import java.util.*;

public class Ex09 {

	public static void main(String[] args) {
		Vector vec;
		vec = new Vector();

		vec.addElement(1111);
		vec.addElement(1112);
		vec.addElement(1113);
		vec.addElement(1114);
		vec.addElement(1115);
		
		System.out.println(vec);
		
		System.out.println(vec.elementAt(0));
		System.out.println(vec.elementAt(1));
		System.out.println(vec.elementAt(2));
		System.out.println(vec.elementAt(3));
		System.out.println(vec.elementAt(4));
	}

}
