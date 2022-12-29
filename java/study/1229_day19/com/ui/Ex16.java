package com.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex16 extends Frame{

	public Ex16() {
		// ���� window event�� �����ϱ� ���ؼ��� listener interface�� ���ǵ� �޼ҵ带 ��� �������̵��ؾ��Ѵ�. ������ Adapter�� ����ϸ� �ʿ��� �޼ҵ常�� �������̵� �� �� �ִ�.
		// ������ ���� �̺�Ʈ �޼ҵ尡 �� �� �̻��� ���, �ش� �����ʿ� Adapter�� �����Ѵ�.(MouseAdapter ...)
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
