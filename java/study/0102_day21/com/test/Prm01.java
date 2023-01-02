package com.test;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;


class TimeCheck implements Runnable {
	private Toolkit tk = Toolkit.getDefaultToolkit();
	private int time = 60;
	Label left;
	Panel selector;
	ImageIcon img;
	
	
	public TimeCheck(Label lb, Panel selector) {
		this.left = lb;
		this.selector = selector;
	}
	
	public void run() {
		while(time >= 0) {
			try {
				Random rd = new Random();
				JButton btn = (JButton)selector.getComponent(rd.nextInt(15));
				img = new ImageIcon("unit.png");
				btn.setIcon(img);
				time--;
				left.setText(String.valueOf(time));
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}


public class Prm01 extends Frame {
	Label left = new Label("60");
	Label sright = new Label("  point");
	static TimeCheck tc;
	static Thread thr;
	static Toolkit tk = Toolkit.getDefaultToolkit();
	Panel selector;
	
	private int score = 0;
	
	public Prm01() {
		LayoutManager lm = new BorderLayout();
		setLayout(lm);
				
		Panel timePad = new Panel();
		Label right = new Label("sec");
		
		timePad.add(left);
		timePad.add(right);
		
		Panel gamePad = new Panel();
		gamePad.setLayout(new BorderLayout());
		selector = new Panel();
		
		selector.setLayout(new GridLayout(4,4));
		for(int i = 0; i<16; i++) {
			JButton btn = new JButton(String.valueOf(i));
			btn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println(btn.getIcon());
					if(btn.getIcon() != null) {
						score++;
						sright.setText(score + " score");
						btn.setIcon(new ImageIcon());	
					}else {
						score--;
						sright.setText(score + " score");
					}
					
				}
			});
			selector.add(btn);
		}
		
		gamePad.add(selector, BorderLayout.CENTER);
		
		Panel Proceed = new Panel();
		Button start = new Button("START");
		// 시작
		start.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tc = new TimeCheck(left, selector);
				thr = new Thread(tc);
				thr.start();
			}
		});
		Button end = new Button("END");
		end.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				thr.stop();
			}
		});
		Proceed.add(start);
		Proceed.add(end);
		gamePad.add(Proceed, BorderLayout.EAST);
		
		
		Panel scorePad = new Panel();
		Label sleft = new Label("score: ");
		scorePad.add(sleft);
		scorePad.add(sright);
		
		add(timePad, BorderLayout.NORTH);
		add(gamePad, BorderLayout.CENTER);
		add(scorePad, BorderLayout.SOUTH);
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setBounds(500, 100, 1200, 900);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Prm01();

	}

}
