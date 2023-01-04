package com.step02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		String url = "127.0.0.1";
		int port = 8080;
		Socket sock = null;
//		sock = new Socket(url, port);
		InputStream is = null;
		OutputStream os = null;
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			sock = new Socket(url, port);
			is = sock.getInputStream();
			os = sock.getOutputStream();
			isr = new InputStreamReader(is);
			osw = new OutputStreamWriter(os);
			br = new BufferedReader(isr);
			pw = new PrintWriter(osw);
			
			String msg = null;
			
			while(true) {
				System.out.print("> ");
				msg = sc.nextLine();
				if(msg.equals("end")) break;
				pw.println(msg);
				// 원래 버퍼가 가득 차야 flush가 자동으로 이루어지나, 통신상에서는 그렇지 않다
				// 사용자가 입력을 끝내더라도 buffer가 가득 차있지 않아 flush가 되지 못한다.
				// 사용자가 임의로 flush를 해주어야 함
				pw.flush();
				msg = br.readLine();
				System.out.println(msg);
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pw != null) pw.close();
				if(br != null) br.close();
				if(osw != null) osw.close();
				if(isr != null) isr.close();
				if(os != null) os.close();
				if(is != null) is.close();
				if(sock != null) sock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}

}
