package com.ui;

import java.awt.*;

public class Ex05_awt4 extends Frame{

	public Ex05_awt4() {
		setLayout(null);
		// 배치관리자 미설정 시, 좌표를 사용자가 알아서 작성해야한다
		Button btn1 = new Button();
		btn1.setLabel("btn1");
		btn1.setSize(100, 100);
		btn1.setLocation(50,50);
		
		add(btn1);
		
		setLocation(500, 500);
		setSize(400, 200);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex05_awt4 me = new Ex05_awt4();
	}

}
