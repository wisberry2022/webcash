package com.ui;

import java.awt.*;

public class Ex03_awt3 extends Frame{
	static CardLayout cL;
	
	public Ex03_awt3() {
		LayoutManager lm;
		lm = new FlowLayout();
//		lm = new GridLayout(3,2);
//		lm = new BorderLayout();
//		cL = new CardLayout();
//		lm = new GridBagLayout();
		setLayout(lm);
		
		Button btn = new Button();
		btn.setLabel("btn1");
		btn.setSize(200, 100);
		add(btn);
		
		Button btn2 = new Button();
		btn2.setLabel("btn2");
		btn2.setSize(200, 100);
		btn2.setLocation(200, 400);
		add(btn2);
		
		Button btn3 = new Button();
		btn3.setLabel("btn3");
		add(btn3);
		
		setSize(300, 300);
		setLocation(200, 200);
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		Ex03_awt3 me = new Ex03_awt3();
		me.setVisible(true);

		
	}

}


// BorderLayout
//Button btn = new Button();
//btn.setLabel("North");
//add(btn, "North");	
//
//Button btn2 = new Button();
//btn2.setLabel("South");
//add(btn2, "South");
//
//Button btn3 = new Button();
//btn3.setLabel("East");
//add(btn3, "East");
//
//Button btn4 = new Button();
//btn4.setLabel("West");
//add(btn4, "West");
//
//Button btn5 = new Button();
//btn5.setLabel("Center");
//add(btn5, "Center");