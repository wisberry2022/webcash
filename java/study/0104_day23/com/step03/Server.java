package com.step03;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
	Socket sock;
	
	public Server(Socket sock) {
		this.sock = sock;
	}
	
	@Override
	public void run() {
		InputStream is = null;
		OutputStream os = null;
		
		try {
			is = sock.getInputStream();
			os = sock.getOutputStream();
			
			while(true) {
				int su = is.read();
				if(su == -1) break;
				os.write(su);
			}
			
			if(os != null) os.close();
			if(is != null) is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		ServerSocket serve = null;
		
		try {
			serve = new ServerSocket(8080);
			while(true) {		
				Socket sock = serve.accept();
				System.out.println("Client 입장!");
				Server me = new Server(sock);
				me.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
