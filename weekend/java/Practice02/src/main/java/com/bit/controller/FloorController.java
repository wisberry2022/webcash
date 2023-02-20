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

@WebServlet("/api/floors/*")
public class FloorController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] uri = req.getRequestURI().split("/");
		int floor = Integer.parseInt(uri[uri.length-1]);
		resp.setContentType("application/json");
		
		try(PrintWriter out = resp.getWriter()) {
			RoomDao dao = new RoomDao();
			List<RoomDto> list = dao.getFloorRoom(floor);
			out.print("{\"rooms\":[");
			for(int i = 0; i<list.size(); i++) {
				RoomDto bean = list.get(i);
				out.print("{\"roomtype\":\""+ bean.getRoomtype() +"\""
						+ ", \"roomname\":\""+ bean.getRoomname() +"\""
						+ ", \"maxnum\":"+ bean.getMaxnum()
						+ ", \"price\":"+ bean.getPrice()
						+ ", \"num\":"+ bean.getNum());
				if(i == list.size()-1) out.print( "}");
				else out.print("},");
			}
			out.print("]}");
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
