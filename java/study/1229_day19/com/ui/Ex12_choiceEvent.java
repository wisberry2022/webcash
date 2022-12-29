package com.ui;

import java.awt.*;
import java.awt.event.*;

public class Ex12_choiceEvent extends Frame implements ItemListener{

	public Ex12_choiceEvent() {
		Panel p = new Panel();
		Choice tf = new Choice();
		tf.addItem("item1");
		tf.addItem("item2");
		tf.addItem("item3");
		tf.addItem("item4");
		tf.addItemListener(this);
		p.add(tf);
		
		add(p);
		
		setBounds(500,500,500,500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Ex12_choiceEvent me = new Ex12_choiceEvent();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Choice cho = (Choice)(e).getSource();
		System.out.println(cho.getSelectedIndex() + "\t" + cho.getSelectedItem());
		
	}

}
