package com.ui;

import java.awt.*;
import java.awt.event.*;

public class Ex14_containerEvent extends Frame implements MouseListener, ContainerListener {
	Panel p = new Panel();
	Button btn = new Button("�߰�");
	
	public Ex14_containerEvent() {
		
		btn.addMouseListener(this);
		p.addContainerListener(this);
		p.add(btn);
		add(p);
		setBounds(500, 100, 300, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex14_containerEvent();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Label la = new Label("��-��");
		la.addMouseListener(this);
		p.add(la);
		// ���ΰ�ħ
//		validate();	// �˻�
//		revalidate();	// ��˻�
		
//		repaint();	// �ٽ� �׸��� -> �̹��� repaint�� ���ؼ� ���� ����Ѵ�(���� ����)
		
	}

	@Override
	public void componentAdded(ContainerEvent e) {
		System.out.println("�߰���");
		validate();
	}

	@Override
	public void componentRemoved(ContainerEvent e) {
		System.out.println("���ŵ�");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println(e.getSource().getClass());
		if(e.getSource() != btn) {
			System.out.println("label����");
			Label la = (Label)e.getSource();
			la.setVisible(false);
//			validate();
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
