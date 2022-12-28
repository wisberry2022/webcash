package com.ui;

import java.awt.*;
import java.io.*;

import javax.swing.JButton;
import javax.swing.*;


public class Ex07_awt_panel2 extends Frame{

	public Ex07_awt_panel2() {
		Panel p = new Panel();
		add(p);
		
		Button btn1 = new Button("bbbb");
		btn1.setEnabled(false);
		p.add(btn1);
		
		JButton btn2 = new JButton("한글");
		btn2.setText("수정");
		
		
		byte[] arr = new byte[1611];
		
		File f = new File("cancel.png");
		InputStream is = null;
		
		try {
			is = new FileInputStream(f);
			for(int i = 0; i<arr.length; i++) {
				arr[i] = (byte)is.read();
			}
			if(is!= null) is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Icon defaultIcon = new ImageIcon(arr);
		btn2.setIcon(defaultIcon);
		p.add(btn2);
		
		// textfield -> text를 입력받을 수 있다.
		TextField tf = new TextField(10);
		tf.setText("ab");
		tf.setEchoChar('*');
		p.add(tf);
		
		// textarea
		TextArea ta = new TextArea("", 5, 10, TextArea.SCROLLBARS_VERTICAL_ONLY);
		p.add(ta);
		
		// 체크박스/라디오박스
		CheckboxGroup cbg = new CheckboxGroup();
		Checkbox ch1 = new Checkbox("item1", cbg, false);
		ch1.setLabel("item1");
		Checkbox ch2 = new Checkbox("item1",cbg, true);
		ch2.setLabel("item2");
		ch2.setState(true);
		Checkbox ch3 = new Checkbox("item1", cbg, false);
		ch3.setLabel("item3");
		p.add(ch1);
		p.add(ch2);
		p.add(ch3);
		
		// html select 창
		Choice cho = new Choice();
		cho.addItem("item1");
		cho.addItem("item2");
		cho.addItem("item3");
		cho.addItem("item4");
		// default 값 -> item 인덱스로 설정
		cho.select(1);
		
		p.add(cho);
		
		List list = new List(10, true);
		list.add("item01");
		list.add("item02");
		list.add("item03");
		list.add("item04");
		list.add("item05");
		list.add("item06");
		list.add("item07");
		list.add("item08");
		list.select(2);
		
		p.add(list);
		
		Label la = new Label("HELLO AWT");
		la.setText("HELLO AWT~~~");
		p.add(la);
		
		JLabel jla = new JLabel("HELLO AWT");
		jla.setText("HELLO SWING~~~");
		Icon labelImage = new ImageIcon(arr);
		jla.setIcon(labelImage);
		p.add(jla);
		
		
		
		setVisible(true);
		setLocation(50, 50);
		setSize(500, 500);
	}
	
	public static void main(String[] args) {
		Ex07_awt_panel2 me = new Ex07_awt_panel2();

	}

}
