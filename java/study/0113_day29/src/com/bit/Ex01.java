package com.bit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex01 {

   public static void main(String[] args) {
      ServerSocket serv = null;
      Socket sock = null;
      OutputStream os = null;
      InputStream is = null;
      InputStreamReader isr = null;
      BufferedReader br = null;
      File f;
      
      try {
         serv = new ServerSocket(8080);
         sock = serv.accept(); // favicon
         System.out.println("first");
         sock = serv.accept(); // data
         System.out.println("second");

         is = sock.getInputStream();
         isr = new InputStreamReader(is);
         br = new BufferedReader(isr);
         
         os = sock.getOutputStream();
         os.write("HTTP/1.1 200 OK\r\n".getBytes());
         os.write("Content-Type: text/plain\r\n".getBytes());
         os.write("\r\n".getBytes());
         os.write("<h1>abcd</h1>".getBytes());
         
         os.write("\r\n".getBytes());
         os.write("abcdefg".getBytes());
        
//         String msg = null;
//         msg = br.readLine();
//         String[] msgs = msg.split(" ");
//         if(msgs[1].equals("/")) {
//        	 f = new File("Ex02.java");
//         }else {
//        	 f = new File(msgs[1].substring(1));	 
//         }
//         InputStream inn = new FileInputStream(f);
         
//         while((msg=br.readLine())!=null) {
//        	 System.out.println(msg);
//         }
         
         os.close();
         br.close();
         isr.close();
         is.close();
         sock.close();
         serv.close();
         
      } catch (IOException e) {
         e.printStackTrace();
      }

   }

}