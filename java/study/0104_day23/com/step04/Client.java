package com.step04;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Client extends Frame implements ActionListener {
	static TextField tf = new TextField();
	static TextArea ta = new TextArea();
	static PrintWriter pw;
	
	public Client() {
		tf.addActionListener(this);
		setLayout(new BorderLayout());
		
		add(ta, BorderLayout.CENTER);
		add(tf, BorderLayout.SOUTH);
		
		setBounds(100, 100, 300, 400);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		String msg = tf.getText();
		pw.println(msg);
		// 원래 버퍼가 가득 차야 flush가 자동으로 이루어지나, 통신상에서는 그렇지 않다
		// 사용자가 입력을 끝내더라도 buffer가 가득 차있지 않아 flush가 되지 못한다.
		// 사용자가 임의로 flush를 해주어야 함
		pw.flush();
		tf.setText("");
		tf.setText("");
	}
	
	public static void main(String[] args) {
		Client cn = new Client();
		String url = "127.0.0.1";
		int port = 8080;
		Socket sock = null;
//		sock = new Socket(url, port);
		InputStream is = null;
		OutputStream os = null;
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		BufferedReader br = null;
		
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
				msg = br.readLine();
				if(msg == "exit") break;
				ta.append(msg);
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
