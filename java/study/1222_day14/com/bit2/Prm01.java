package com.bit2;

import java.util.*;

public class Prm01 {
	public static void main(String[] args) {
		Set lottos = new TreeSet();
		while(lottos.size()<6) lottos.add((int)(Math.random()*45)+1); 
		System.out.print(lottos);
	}

}
