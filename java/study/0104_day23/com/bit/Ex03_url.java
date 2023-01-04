package com.bit;

import java.net.MalformedURLException;
import java.net.URL;

public class Ex03_url {

	public static void main(String[] args) {
		String msg = "https://www.busan.go.kr/depart/ecnmreference/1520507?curPage=&srchBeginDt=2018-01-04&srchEndDt=2023-01-04&srchKey=&srchText=";
//		msg = "https://getbootstrap.com/docs/3.4/components/#thumbnails";
//		msg = "http://www.tzr.io/";
		java.net.URL url = null;
		try {
			url = new URL(msg);
			System.out.println("protocol: " + url.getProtocol());
			System.out.println("domain: " + url.getHost());
			// url에서 port 번호는 생략가능하다.
			System.out.println("port: " + url.getPort());
			System.out.println("default port: " + url.getDefaultPort());
			System.out.println("file: " + url.getFile());
			System.out.println("path: " + url.getPath());
			System.out.println("queryString: " + url.getQuery());
			System.out.println("ref: " + url.getRef());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
