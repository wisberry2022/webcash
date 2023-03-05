package com.gof.obj;

import com.gof.util.Iterator;

public class ArrayIterator implements Iterator {
	private Array array;
	private int index;
	
	public ArrayIterator(Array array) {
		this.array = array;
		this.index = -1;
	}
	
}
