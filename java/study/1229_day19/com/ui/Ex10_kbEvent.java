package com.ui;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ex10_kbEvent extends Frame implements KeyListener{

	TextField tf;
	public Ex10_kbEvent() {
		Panel p = new Panel();
		
		tf = new TextField(10);
		
		tf.addKeyListener(this);
		p.add(tf);
		
//		Choice cho = new Choice();
//		cho.addKeyListener(this);
//		p.add(cho);
//		
//		Button btn = new Button();
//		btn.addKeyListener(this);
//		p.add(btn);
				
		add(p);
		
		setBounds(500, 100, 300, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) throws InterruptedException {
		Ex10_kbEvent me = new Ex10_kbEvent();
//		while(true) {
//			Thread.sleep(1000);
//			la.setLocation(la.getX(), la.getY()+10);
//		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char a = e.getKeyChar();
		int su = e.getKeyCode();
		System.out.println(a + "눌렸고" + su);
		System.out.println("gt: " + tf.getText());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char a = e.getKeyChar();
		int su = e.getKeyCode();
		System.out.println(a + "누르는 중이고" + su);
		System.out.println("gt: " + tf.getText());
	}

	@Override
	// 온전한 값의 전달은 keyReleased에서만 발생하고 있다
	public void keyReleased(KeyEvent e) {
		System.out.println("올라옴");
		System.out.println("gt: " + tf.getText());
//		int su = e.getKeyCode();
//		int x = la.getX();
//		int y = la.getY();
//		if(su == 39) {
//			// 오른쪽 화살표
//			la.setLocation(x+10, y);
//		}else if(su == 37) {
//			// 왼쪽 화살표
//			la.setLocation(x-10, y);
//		}else if(su == 38) {
//			la.setLocation(x, y-10);
//		}else if(su == 40) {
//			la.setLocation(x, y+10);
//		}
	}

}
