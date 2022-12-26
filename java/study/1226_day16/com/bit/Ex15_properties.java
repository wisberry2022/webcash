package com.bit;

import java.util.Properties;
import java.util.*;


public class Ex15_properties {

	public static void main(String[] args) {
		Properties props;

		props = System.getProperties();

		Set set = props.keySet();
		Iterator ite = set.iterator();
		while(ite.hasNext()) {
			Object obj = ite.next();
			System.out.println(obj + " @ " + props.get(obj));
		}
	}

}


//props = new Properties();
//System.out.println(props);
//props.setProperty("key1", "val1");

//System.out.println(props.get("key1"));