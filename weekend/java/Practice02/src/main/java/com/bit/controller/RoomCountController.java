package com.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.RoomDao;
import com.bit.model.RoomDto;

@WebServlet("/api/rooms/*")
public class RoomCountController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setContentType("application/json");
		
		String[] uri = req.getRequestURI().split("/");
		int dept = Integer.parseInt(uri[uri.length-1]);
		
		try(
				PrintWriter out = resp.getWriter();		
		) {
			
			RoomDao dao = new RoomDao();
			
			List<RoomDto> datas = dao.getData(dept);
			
			out.print("{\"rooms\":[");
			
			int idx = 0;
			
			for(RoomDto bean:datas) {
				out.print("{\"num\":"+bean.getNum()+
						", \"type\":\""+bean.getRoomtype()+
						"\", \"name\":\""+bean.getRoomname()+
						"\", \"maxnum\":"+bean.getMaxnum()+
						", \"price\":"+bean.getPrice());
				if(idx != datas.size()-1) out.print("},");
				else out.print("}");
				idx++;
			}
			out.print("]}");
			
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
		
		resp.setStatus(resp.SC_OK);
	}
}
