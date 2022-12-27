package com.bit;

import java.util.*;
import java.io.*;

public class Ex20_io5 {

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("E:\\java\\gov\\day17\\src\\com\\bit\\Ex20_io5.java");
//		InputStream is = new FileInputStream(f);
		Scanner sc = new Scanner(f);
		
		String msg = "";
		
		while(sc.hasNextLine()) {
			msg = sc.nextLine();
			System.out.println(msg);
		}
	}

}
