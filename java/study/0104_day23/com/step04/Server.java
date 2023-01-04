package com.step04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server extends Thread {
	static List<PrintWriter> list = new ArrayList<>();
	public static void main(String[] args) {
		ServerSocket serv = null;
		try {
			serv = new ServerSocket(8080);
			while(true) {
				final Socket sock = serv.accept();
				
				Thread thr = new Thread(new Runnable() {
					@Override
					public void run() {
						InputStream is = null;
						OutputStream os = null;
						InputStreamReader isr = null;
						OutputStreamWriter osw = null;
						BufferedReader br = null;
						PrintWriter pw = null;
						InetAddress addr = null;
						
						try {
							addr = sock.getInetAddress();
							is = sock.getInputStream();
							os = sock.getOutputStream();
							isr = new InputStreamReader(is);
							osw = new OutputStreamWriter(os);
							br = new BufferedReader(isr);
							pw = new PrintWriter(osw);
							
							String msg = null;
							while((msg= br.readLine()) != null) {
								msg = "[" + addr.getHostAddress() + "]" + msg;
								pw.println(msg);
								pw.flush();
								System.out.println(msg);
							}
							if(pw != null) pw.close();
							if(br != null) br.close();
							if(osw != null) osw.close();
							if(isr != null) isr.close();
							if(os != null) os.close();
							if(is != null) is.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
				thr.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
