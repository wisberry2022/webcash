package com.ui;

import java.awt.*;

public class Ex05_component2 extends Frame {

	public Ex05_component2() {
		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		Menu m1 = new Menu("메뉴1");
		Menu m2 = new Menu("메뉴2");
		MenuItem mitm1 = new MenuItem("sub01");
		m1.add(mitm1);
		MenuItem mitm2 = new MenuItem("sub02");
//		MenuItem mitm2_1 = new MenuItem("2-2-1");
		
		m1.add(mitm2);
		Menu mitm3 = new Menu("2-3");
		CheckboxMenuItem ck1 = new CheckboxMenuItem("sub03");
		mitm3.add(ck1);
		m1.add(mitm3);
		mb.add(m1);
		mb.add(m2);
		
		
		setBounds(100, 100, 500, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex05_component2();

	}

}
