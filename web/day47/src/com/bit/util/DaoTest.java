package com.bit.util;

import java.sql.SQLException;
import java.util.List;

import com.bit.model.EmpDao;
import com.bit.model.EmpDto;

public class DaoTest {
	static EmpDto target = new EmpDto();

	public static void main(String[] args) throws SQLException{
		target.setEmpno(1888);
		target.setEname("user18");
		target.setSal(3000);
		getListTest();
		pushListTest();
		EmpDto ed = getOneTest(target.getEmpno());
		editOneTest();
		EmpDto ed2 = getOneTest(target.getEmpno());
		deleteOneTest();
		try {
			EmpDto ed3 = getOneTest(target.getEmpno());
		}catch(Exception e) {
			System.out.println("성공");
		}
	}

	public static void deleteOneTest() throws SQLException {
		EmpDao dao = new EmpDao();
		System.out.println(dao.deleteOne(target.getEmpno())>0);
	}
	
	public static void editOneTest() throws SQLException {
		target.setEname("user8");
		
		EmpDao dao = new EmpDao();
		System.out.println(dao.editOne(target.getEname(), target.getSal(), target.getComm(),  target.getMgr(),  target.getEmpno())>0);
		
	}
	
	public static void pushListTest() throws SQLException {
		EmpDao dao = new EmpDao();	
		System.out.println(dao.pushList(target.getEmpno(), target.getEname(), target.getSal()) > 0);
	}
	
	public static void getListTest() throws SQLException  {
		EmpDao dao = new EmpDao();
		List<EmpDto> list = dao.getList();
		System.out.println(list != null);
		System.out.println(list.size()>0);
	}
	
	public static EmpDto getOneTest(int empno) throws SQLException {
		EmpDao dao = new EmpDao();
		return dao.getOne(empno);
	}
	
}
