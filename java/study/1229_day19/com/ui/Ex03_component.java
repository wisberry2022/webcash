package com.ui;

import java.awt.*;
import javax.swing.*;

public class Ex03_component extends Frame{

	public Ex03_component() {
		Panel p = new Panel();
		Label la = new Label("한글");
		Font f = new Font("Serif",  Font.BOLD, 30);
		la.setFont(f);
		Color fcolor = Color.MAGENTA;
		Color bcolor = new Color(0, 0, 0);
		// font color
		la.setForeground(fcolor);
		// background color
		la.setBackground(bcolor);
		p.setBackground(bcolor);
		p.add(la);
		add(p);
		Button btn = new Button("버튼");
		p.add(btn);
//		btn.setEnabled(false);
		
		// textField의 좌우 너비는 글자 개수로 조절하나, 상하 너비는 Font로 조절해야한다
		TextField tf = new TextField(10);
		tf.setFont(f);
//		tf.setEnabled(false);
//		tf.setVisible(false);
		tf.setEditable(false);
		p.add(tf);
		
		setBounds(100, 100, 400, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex03_component();

	}

}
