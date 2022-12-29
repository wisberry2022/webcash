package com.ui;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Ex07_event extends Frame implements WindowListener{

	public Ex07_event() {
		addWindowListener(this);
		setBounds(100, 100, 400, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Ex07_event me = new Ex07_event();
		

	}

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("창열림");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("닫기버튼");		
		// 창 닫기 이후 후행작업이 필요할 때
		dispose();
//		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("call disposed");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("창 최소화");
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("안최소화");
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("활성화");
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("비활성화");
		
	}

}
