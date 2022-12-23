package com.priv;

import java.util.*;

public class Priv02 {

	public static void main(String[] args) {
		Map map = new TreeMap();
		
		ArrayList a = new ArrayList();
		a.add("2");
		a.add("3");
		a.add("4");
		
		map.put("key1", a);
		
		System.out.println(map.get("key1"));

	}

}
