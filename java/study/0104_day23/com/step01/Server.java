package com.step01;

import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	public static void main(String[] args) {
		Socket sock = null;
		ServerSocket serve = null;
		InetAddress inet = null;
		OutputStream os = null;
		InputStream is = null;
		
		
		try {
			// 서버 소켓은 항상 port를 열고 있어야 한다
			// CLient가 접속할 때까지 대기해야한다.
			serve = new ServerSocket(8000);
			// 접속한 Client의 정보(Socket 객체)를 받는다.
			sock = serve.accept();

			os = sock.getOutputStream();
			is = sock.getInputStream();
//			os.write("hello world".getBytes());
			System.out.println("클라이언트 요청 받음!");
			
			int su;
			while((su=is.read()) != -1) {
				os.write(su);
			}
			
			if(is != null) is.close();
			if(os != null) os.close();
			if(sock != null) sock.close();
			if(serve != null) serve.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}

// Client의 정보
//inet = sock.getInetAddress();
//System.out.println(
//		inet.getHostName() + " " +
//		Arrays.toString(inet.getAddress())
//		);
