package com.ui;

import java.awt.*;
import java.awt.event.*;

public class Ex09_mouseMove extends Frame implements MouseMotionListener {

	Label la;
	
	public Ex09_mouseMove() {
		Panel p = new Panel();
		p.setLayout(null);
		
		Label la = new Label("*");
		la.setSize(35, 35);
		la.setLocation(100, 100);
		p.add(la);
		p.addMouseMotionListener(this);
		add(p);
		
		setBounds(500, 500, 300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex09_mouseMove();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
//		int x = e.getXOnScreen();
//		int y = e.getYOnScreen();
		System.out.println("드래그 x=" + x + ",y=" +y);
		
		la.setLocation(x, y);		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println("마우스 이동 x=" + x + ",y=" +y);
		

	}

}
