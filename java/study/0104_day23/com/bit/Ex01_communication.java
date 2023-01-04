package com.bit;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Ex01_communication {

	public static void main(String[] args) {
		java.net.InetAddress addr1 = null;
//		 192.168.240.111
//		byte[] bArr = {(byte)172,(byte)17,(byte)240,1};
		byte[] bArr = {(byte)127,(byte)0,(byte)0,1};
		System.out.println(Arrays.toString(bArr));
		try {
			addr1 = InetAddress.getByName("google.com");
			
//			addr1 = InetAddress.getByAddress(bArr);
			
			System.out.println(addr1.getHostName());
			// naver - 223.130.200.104 (naver 주소) -> (byte 배열 4개짜리)
			System.out.println(addr1.getHostAddress());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
