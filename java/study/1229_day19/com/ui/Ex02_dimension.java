package com.ui;

import java.awt.*;

public class Ex02_dimension extends Frame {

	public static void main(String[] args) {
		Ex02_dimension me = new Ex02_dimension();
		
		me.setLocation(100, 100);
		Dimension dim = new Dimension();
		dim.width = 500;
		dim.height = 1000;
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension dim2 = tool.getScreenSize();
		int w = dim2.width/2-dim.width/2;
		int h = dim2.height/2-dim.height/2;
		me.setSize(dim);
		me.setBounds(w, h, dim.width, dim.height);
		me.setVisible(true);
		

	}

}
