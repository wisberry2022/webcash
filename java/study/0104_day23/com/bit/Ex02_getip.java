package com.bit;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Ex02_getip {

	public static void main(String[] args) {
		InetAddress[] inets = null;
		try {
			inets = InetAddress.getAllByName("google.com");
			for(int i = 0; i<inets.length; i++) {
				System.out.println(inets[i].getHostAddress() + " " + inets[i].getHostName());
				System.out.println(Arrays.toString(inets[i].getAddress()));
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
