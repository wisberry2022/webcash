package com.ui;

import java.awt.*;
import java.awt.event.*;

public class Ex15_actionListener extends Frame implements ActionListener {
	
	
	
	
	public Ex15_actionListener() {
		MenuBar mb = new MenuBar();
		Menu m = new Menu("메뉴");
		MenuItem mi = new MenuItem("메뉴1");
		MenuItem mj = new MenuItem("메뉴2");
		m.add(mi);
		m.add(mj);
		mb.add(m);
		setMenuBar(mb);
		Panel p = new Panel();
		Label la = new Label("label");
		Button btn = new Button("btn");
		TextField tf = new TextField(10);
		TextArea ta = new TextArea();
		Choice cho = new Choice();
		cho.add("cho1");
		cho.add("cho2");
		cho.add("cho3");
		List list = new List();
		list.add("litem1");
		list.add("litem2");
		list.add("litem3");
		Checkbox cb = new Checkbox("chk1");
		Checkbox cb2 = new Checkbox("chk2");
		Checkbox cb3 = new Checkbox("chk3");

		p.add(la);
		p.add(btn);
		p.add(tf);
		p.add(ta);
		p.add(cho);
		p.add(list);
		p.add(cb);
		p.add(cb2);
		p.add(cb3);
		
		add(p);
		
//		la.addActionListener(this);
		btn.addActionListener(this);
		tf.addActionListener(this);
//		ta.addActionListener(this);
		list.addActionListener(this);
		mi.addActionListener(this);
		mj.addActionListener(this);
		
		setBounds(500,500,500,500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex15_actionListener();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		Object src = e.getSource();
		System.out.println("action...");
	}

}
