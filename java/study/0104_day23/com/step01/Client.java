package com.step01;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.io.OutputStream;


public class Client {

	public static void main(String[] args) {
		byte[] arr = {(byte)192, (byte)168, (byte)240, 111};
		InetAddress addr = null;
		int port = 8000;
		Socket sock = null;
		InputStream is = null;
		OutputStream os = null;
		
		try {
			addr = InetAddress.getByAddress(arr);
			sock = new Socket(addr, port);
			os = sock.getOutputStream();
			is = sock.getInputStream();

			// 서버 측에서 읽기를 끝내면 통신이 종료되기 때문에  읽기가 끝나면 자연스레 끝난다.
//			os.write(65);
//			os.write(66);
//			os.write(67);
//			System.out.println(is.read());
//			System.out.println(is.read());
//			System.out.println(is.read());

			os.write("Hi server..".getBytes());

			// 통신의 끝점이 애매모호하기 때문에 while문을 탈출하지 않게 된다.
			// 사용자가 임의로 통신 종료 포인트를 지정해야한다.
			int su;
			while((su = is.read()) != '.') {
				System.out.print((char)su);
			}
			
//			System.out.println("while문 탈출!");
			if(is != null) is.close();
			if(os != null) os.close();
			if(sock != null) sock.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		

	}

}
