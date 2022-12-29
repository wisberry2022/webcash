package com.ui;

import java.awt.*;


public class Ex04_canvas extends Frame{
	static Ex04_canvas me;
	Canvas can = new MyCanvas();
	class MyCanvas extends Canvas {
		// vector 방식의 drawing
		@Override
		public void paint(Graphics g) {
			char[] arr = "한글".toCharArray();
			g.drawChars(arr, 0, arr.length, 100, 100);
			
			g.drawLine(100, 100, 200, 200);
			g.setColor(Color.RED);
			
			g.draw3DRect(200, 200, 100, 100, true);
			g.setColor(Color.BLUE);
			g.drawOval(300, 300, 100, 100);
			
			
			Toolkit tool = Toolkit.getDefaultToolkit();
			
			Image img = tool.createImage("cancel.png");
			g.drawImage(img, 100, 100, me);
			g.drawArc(100, 100, 100, 100, 45, 180);
		}
	}
	
	public Ex04_canvas() {
		add(can);
		
		setBounds(100, 100, 500, 500);
		setVisible(true);
		
		repaint();
	}
	
	public static void main(String[] args) {
		Ex04_canvas me = new Ex04_canvas();
		

	}

}
