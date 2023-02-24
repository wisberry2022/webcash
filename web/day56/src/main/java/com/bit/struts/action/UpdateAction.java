package com.bit.struts.action;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bit.struts.model.DeptVo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class UpdateAction implements Action, ModelDriven<DeptVo>, Preparable {
   Logger log = LogManager.getLogger(UpdateAction.class);
   DeptVo bean;
   
   @Override
   public String execute() throws Exception {
      log.info(bean);
      return Action.SUCCESS;
   }

	@Override
	public DeptVo getModel() {
		return bean;
	}
	
	@Override
	public void prepare() throws Exception {
		bean = new DeptVo();
	}
}