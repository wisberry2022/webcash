package com.test;

import java.awt.*;

public class Prm01 extends Frame {
	public Prm01() {
		LayoutManager lm = new GridBagLayout();
		GridBagConstraints gbc;
		gbc = new GridBagConstraints();
		setLayout(lm);
		
		gbc.fill = GridBagConstraints.BOTH;
		
		Panel resultMonitor = new Panel();
		resultMonitor.setSize(650, 200);
		resultMonitor.setBackground(Color.GRAY);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth= 1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(resultMonitor, gbc);
	
		TextArea ta = new TextArea("", 10, 90, TextArea.SCROLLBARS_NONE);
		resultMonitor.add(ta);
		
		Panel buttonBox = new Panel();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth=1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 2;
		add(buttonBox, gbc);
		
		buttonBox.setLayout(new GridLayout(4,4));
		
		String[] padStr = new String[] {"7","8","9","*","4","5","6","/","1","2","3","-","+","0",".","="};
		
		for(int i = 0; i<padStr.length; i++) {
			Button pad = new Button(padStr[i]);
			buttonBox.add(pad);
		}
		
		setSize(700, 900);
		setLocation(500,100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Prm01 calc = new Prm01();
	}

}
