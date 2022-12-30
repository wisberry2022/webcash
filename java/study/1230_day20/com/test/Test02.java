package com.test;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

//class SaveListener implements ActionListener {
//	String input;
//	public SaveListener(String input) {
//		this.input = input;
//	}
//	
//	public void actionPerformed(ActionEvent e) {
//		Frame f = new Frame("이름없음");
//		FileDialog save = new FileDialog(f, "SAVE", FileDialog.SAVE);
//		save.setVisible(true);
//		
//		File read = new File(save.getDirectory() + "\\" + save.getFile());
//		OutputStream os = null;

//		
//		try {
//			if(!read.exists()) read.createNewFile();
//			os = new FileOutputStream(read);
//			
//			byte[] bArr = input.getBytes();
//			
//			os.write(bArr);
//				
//			if(os != null) os.close();		
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//	}
//}

class TopMenu extends Frame implements ActionListener{
	MenuBar mb = new MenuBar();
	String input = "";
	public TopMenu() {
		Menu m1 = new Menu("파일");
		Menu m2 = new Menu("도움말");
			
		String[] arr = {"새로 만들기", "열기", "저장", "종료"};
		
		for(int i = 0; i<arr.length; i++) {
			MenuItem mitm = new MenuItem(arr[i]);
			m1.add(mitm);
		}
		
		MenuItem help = new MenuItem("정보");
		m2.add(help);
		
		MenuItem save = m1.getItem(2);
		save.addActionListener(this);
		
//		MenuItem open = m1.getItem(1);
//		open.addActionListener(this);
		
		mb.add(m1);
		mb.add(m2);
	}
	
	public MenuBar getTM() {
		return mb;
	}
	
	public void setInput(String input) {
		this.input = input;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Frame f = new Frame("이름없음");
		FileDialog save = new FileDialog(f, "SAVE", FileDialog.SAVE);
		save.setVisible(true);
		
		File read = new File(save.getDirectory() + "\\" + save.getFile());
		OutputStream os = null;
		
		try {
			if(!read.exists()) read.createNewFile();
			os = new FileOutputStream(read);
			
			byte[] bArr = input.getBytes();
			
			os.write(bArr);
				
			if(os != null) os.close();		
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
}

class Tfield extends Frame {
	TextArea ta = new TextArea();
	
	public TextArea getTextArea() {
		return ta;
	}
}

class Notepad extends Frame{
	static Toolkit tk = Toolkit.getDefaultToolkit();
	static double SCREEN_WIDTH = tk.getScreenSize().getWidth();
	static double SCREEN_HEIGHT = tk.getScreenSize().getHeight();
	static int MODAL_WIDTH = 1200;
	static int MODAL_HEIGHT = 700;
	String input = "";
	
	public Notepad() {
		int width = (int)(SCREEN_WIDTH/2)-(int)(MODAL_WIDTH/2);
		int height = (int)(SCREEN_HEIGHT/2)-(int)(MODAL_HEIGHT/2);
		setBounds(width, height, MODAL_WIDTH, MODAL_HEIGHT);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		TopMenu custom = new TopMenu();
		MenuBar mb = custom.getTM();
		
		
		TextArea ta = new Tfield().getTextArea();
		
		ta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				input = ta.getText();
				custom.setInput(input);
			}
		});

		setMenuBar(mb);
	
		add(ta);
		
		setVisible(true);
	}
}

public class Test02 extends Frame {
	
	public static void main(String[] args) {
		Notepad np = new Notepad();
	}

}
