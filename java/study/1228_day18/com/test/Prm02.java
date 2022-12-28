package com.test;

import java.awt.*;
import java.util.*;

public class Prm02 extends Frame {
	public Prm02() {
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
		
		buttonBox.setLayout(new GridBagLayout());
		GridBagConstraints subGbc = new GridBagConstraints(); 
		subGbc.fill = GridBagConstraints.BOTH;
		
		String[] padStr = new String[] {"7","8","9","+","4","5","6","-","1","2","3","=","0","."};
		
		Map<String, int[]> cpnSet = new TreeMap<>();
		
		
		cpnSet.put("7", new int[] {0, 0, 1, 1, 1, 1});
		cpnSet.put("8", new int[] {1, 0, 1, 1, 1, 1});
		cpnSet.put("9", new int[] {2, 0, 1, 1, 1, 1});
		cpnSet.put("+", new int[] {3, 0, 1, 1, 1, 1});
		cpnSet.put("4", new int[] {0, 1, 1, 1, 1, 1});
		cpnSet.put("5", new int[] {1, 1, 1, 1, 1, 1});
		cpnSet.put("6", new int[] {2, 1, 1, 1, 1, 1});
		cpnSet.put("-", new int[] {3, 1, 1, 1, 1, 1});
		cpnSet.put("1", new int[] {0, 2, 1, 1, 1, 1});
		cpnSet.put("2", new int[] {1, 2, 1, 1, 1, 1});
		cpnSet.put("3", new int[] {2, 2, 1, 1, 1, 1});
		cpnSet.put("=", new int[] {3, 2, 1, 2, 1, 1});
		cpnSet.put("0", new int[] {0, 3, 2, 1, 1, 1});
		cpnSet.put(".", new int[] {2, 3, 1, 1, 1, 1});
		
		for(int i = 0; i<padStr.length; i++) {
			int[] coord = cpnSet.get(padStr[i]);
			Button pad = new Button(padStr[i]);
			subGbc.gridx = coord[0];
			subGbc.gridy = coord[1];
			subGbc.gridwidth = coord[2];
			subGbc.gridheight = coord[3];
			subGbc.weightx = coord[4];
			subGbc.weighty = coord[5];
			buttonBox.add(pad, subGbc);
		}
		
		setSize(700, 900);
		setLocation(500,100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Prm02 calc = new Prm02();
	}

}
