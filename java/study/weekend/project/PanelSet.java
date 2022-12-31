package project;

import java.awt.*;
import java.awt.event.*;

class PanelManager extends Frame{
	Label lb;
	Panel panel;
	
	PanelManager() {	}

	Label getTitle(String name) {
		this.lb = new Label();
		lb.setText(name);
		return this.lb;
	}
	
	Panel getTitlePanel(String name) {
		panel = new Panel();
		LayoutManager fl = new FlowLayout();
		panel.setLayout(fl);
		lb = getTitle(name);
		panel.add(lb);
		return panel;
	}
}
