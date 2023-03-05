package com.bit.flow;

import com.bit.object.ModelA;

public class Main {

	public static void main(String[] args) {
		Control con = new Control();
		con.doControl(new ModelA("nick"));
	}

}
