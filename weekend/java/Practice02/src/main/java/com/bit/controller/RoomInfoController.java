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

@WebServlet("/api/infos")
public class RoomInfoController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setContentType("application/json");
		
		try(
				PrintWriter out = resp.getWriter();	
		) {
			RoomDao dao = new RoomDao();
			List<RoomDto> list = dao.getInfoData();
			
			out.print("{\"infos\":[");
			
			int idx = 0;
			for(RoomDto bean:list) {
				out.print("{\"typenum\":"+bean.getTypenum()+", "
						+ "\"roomtype\":\""+bean.getRoomtype()+"\", "
						+ "\"roomname\":\""+bean.getRoomname()+"\", "
						+ "\"maxnum\":"+bean.getMaxnum()+", "
						+ "\"price\":"+bean.getPrice());
				if(idx == list.size()-1) out.print("}");
				else out.print("},");
				idx++;
			}

			out.print("]}");
			
			resp.setStatus(resp.SC_OK);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			resp.setStatus(resp.SC_INTERNAL_SERVER_ERROR);
		}
	}
}
