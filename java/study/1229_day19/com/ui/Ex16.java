package com.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex16 extends Frame{

	public Ex16() {
		// 원래 window event를 장착하기 위해서는 listener interface에 정의된 메소드를 모두 오버라이드해야한다. 하지만 Adapter를 사용하면 필요한 메소드만을 오버라이드 할 수 있다.
		// 리스너 내에 이벤트 메소드가 두 개 이상일 경우, 해당 리스너에 Adapter를 제공한다.(MouseAdapter ...)
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("window closing~");
				dispose();
			}	
		});
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 500, 500, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Ex16 me = new Ex16();

	}

}
