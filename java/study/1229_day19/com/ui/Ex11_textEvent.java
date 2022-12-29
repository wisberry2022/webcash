package com.ui;

import java.awt.*;
import java.awt.event.*;

public class Ex11_textEvent extends Frame implements TextListener{

	public Ex11_textEvent() {
		Panel p = new Panel();
		TextField tf = new TextField(10);
		tf.addTextListener(this);
		p.add(tf);
		
		add(p);
		
		setBounds(500,500,500,500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Ex11_textEvent me = new Ex11_textEvent();
	}

	@Override
	// textvalue�� �޴�, �׸��� value�� ������ �� �ִ� ������Ʈ�� �ش� listener�� ������ �� �ִ�.
	public void textValueChanged(TextEvent e) {
		String msg = ((TextField)(e.getSource())).getText();
		System.out.println("�� �ٲ�" + msg);
		
	}

}
