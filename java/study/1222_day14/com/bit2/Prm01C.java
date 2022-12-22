package com.bit2;

import java.util.*;

public class Prm01C {

	public static void main(String[] args) {
		Set lotto = new TreeSet();
		while(lotto.size() < 6) {
			lotto.add((int)(Math.random()*45)+1);
		}
		Iterator ite = lotto.iterator();
		while(ite.hasNext()) System.out.println(ite.next());
	}

}
