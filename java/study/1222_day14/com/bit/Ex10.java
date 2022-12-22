package com.bit;

import java.util.*;

public class Ex10 {

	public static void main(String[] args) {
		Vector vec;
		vec = new Vector();

		vec.addElement(1111);
		vec.addElement(1112);
		vec.addElement(1113);
		vec.addElement(1114);
		vec.addElement(1115);

		// Vector를 위한 객체
		// 값을 뽑아내기 위해 새로운 객체를 받음
		// 한 번 nextElement()를 진행하면 다시 뒤돌아갈 수 없다
		Enumeration enu;
		enu = vec.elements();
//		System.out.println(enu.hasMoreElements());
//		System.out.println(enu.nextElement());
//		System.out.println(enu.nextElement());
//		System.out.println(enu.nextElement());
//		System.out.println(enu.nextElement());
//		System.out.println(enu.hasMoreElements());
		while(enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}
		
	}

}
