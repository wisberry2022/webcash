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
	// textvalue를 받는, 그리고 value를 수정할 수 있는 컴포넌트만 해당 listener를 장착할 수 있다.
	public void textValueChanged(TextEvent e) {
		String msg = ((TextField)(e.getSource())).getText();
		System.out.println("값 바뀜" + msg);
		
	}

}
