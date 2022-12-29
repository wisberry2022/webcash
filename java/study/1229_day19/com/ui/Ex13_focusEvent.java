package com.ui;

import java.awt.*;
import java.awt.event.*;

public class Ex13_focusEvent extends Frame implements FocusListener, TextListener {

	public Ex13_focusEvent() {
		Panel p = new Panel();
		TextField[] arr = new TextField[5];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = new TextField(10);
			arr[i].addFocusListener(this);
			arr[i].addTextListener(this);
			p.add(arr[i]);
		}
		
		add(p);
		
		setBounds(500, 100, 500, 500);
		setVisible(true);
		
		arr[0].nextFocus();
	}
	
	public static void main(String[] args) {
		new Ex13_focusEvent();
	}

	@Override
	public void focusGained(FocusEvent e) {
		TextField tf = (TextField)e.getSource();
		System.out.println(tf.getText() + "인 포커스");
	}

	@Override
	public void focusLost(FocusEvent e) {
		 System.out.println("아웃 포커스");
	}

	@Override
	public void textValueChanged(TextEvent e) {
		 TextField tf = (TextField) e.getSource();
		 if(tf.getText().length() == 4) {
			 tf.nextFocus();
		 }
	}

}
