package com.ui;

import java.awt.*;
import java.awt.event.*;


public class Ex08_mouseEvent extends Frame implements MouseListener{

	public Ex08_mouseEvent() {
		Panel p = new Panel();
		
		Button btn = new Button("��ư");
		btn.addMouseListener(this);
		
		p.add(btn);
		add(p);
		
		setBounds(600, 100, 600, 600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex08_mouseEvent();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		System.out.println("Ŭ��!" + x + "\t" + y);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		 System.out.println("����");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("���Ⱦ��µ� �ö��");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("������Ʈ ���� �ö��");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("��������");
		
	}

}
