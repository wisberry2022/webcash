package com.ui;

import java.awt.*;
import java.awt.event.*;

public class Ex14_containerEvent extends Frame implements MouseListener, ContainerListener {
	Panel p = new Panel();
	Button btn = new Button("추가");
	
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
		Label la = new Label("추-가");
		la.addMouseListener(this);
		p.add(la);
		// 새로고침
//		validate();	// 검사
//		revalidate();	// 재검사
		
//		repaint();	// 다시 그리기 -> 이미지 repaint를 위해서 자주 사용한다(성능 좋음)
		
	}

	@Override
	public void componentAdded(ContainerEvent e) {
		System.out.println("추가됨");
		validate();
	}

	@Override
	public void componentRemoved(ContainerEvent e) {
		System.out.println("제거됨");
		
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
			System.out.println("label위로");
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
