package com.bit.util.listen;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

@WebListener
public class Ex02Listener implements ServletRequestListener {
	Logger log = Logger.getLogger(this.getClass().getCanonicalName());
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
//		log.debug("listen req init...");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
//		log.debug("listen req destroy...");
	}

}
