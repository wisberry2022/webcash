package com.ui;

import java.awt.*;

public class Ex06_Frame {

	public static void main(String[] args) throws InterruptedException {
		Frame f = new Frame("�̸�����!");
		f.setBounds(100, 100, 500, 500);
		f.setVisible(true);
		
		// f�� ���ӵ� â
//		Dialog dia = new Dialog(f);
//		dia.setBounds(200, 200, 200, 200);
//		dia.setVisible(true);
		

		FileDialog dia2 = new FileDialog(f, "TEST", FileDialog.LOAD);
		dia2.setLocation(500, 100);
		dia2.setVisible(true);
		// filename
		String filename = dia2.getFile();
		// parent directory
		String dir = dia2.getDirectory();
		// frame �̸�
		String name = dia2.getName();
		String title = dia2.getTitle();
		System.out.println("���ϴ��̾�α� ȣ��...");
		System.out.println(filename);
		System.out.println(dir);
		System.out.println(name);
		System.out.println(title);
		
	}

}
