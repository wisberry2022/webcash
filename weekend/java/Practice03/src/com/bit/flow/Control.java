package com.bit.flow;

import com.bit.service.Service;
import com.bit.util.CommonModel;

public class Control {
	
	public void doControl(CommonModel model) {
		Service sv = new Service(model);
		sv.doService();
	}
}
