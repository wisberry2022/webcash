package com.bit.struts.action;

import java.sql.SQLException;
import java.util.List;

import com.bit.struts.model.DeptDao;
import com.bit.struts.model.DeptVo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class ListAction implements ModelDriven<DeptVo> {
	List<DeptVo> list;
	DeptDao dao = new DeptDao();
	
	public List<DeptVo> getList() {
		return list;
	}
	
	public String deptList() throws Exception {
		list = dao.findAll();
		return Action.SUCCESS;
	}
	
	public String addDept() throws Exception {	
		dao.insertOne(bean);
		return Action.SUCCESS;
	}

	
	DeptVo bean = new DeptVo();
	
	public String delete() throws SQLException {
		dao.deleteOne(bean.getDeptno());
		return Action.SUCCESS;
	}
	
	public DeptVo getBean() {
		return bean;
	}
	
	public String edit() throws SQLException {
		dao.updateOne(bean);
		return Action.SUCCESS;
	}
	
	public String detail() {
		try {
			
			bean = dao.findOne(bean.getDeptno());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	
	public void setBean(DeptVo bean) {
		this.bean = bean;
	}
	
	@Override
	public DeptVo getModel() {
		return bean;
	}
}
