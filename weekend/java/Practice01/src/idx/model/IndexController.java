package idx.model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		System.out.println(req.getParameter("name"));
		System.out.println("hello");
		try {
			out.println("{\"emp\":[");
			out.println("{\"empno\": "+ 1
				+", \"ename\":\""+ "smith"
				+"\", \"sal\":" + 5000
				+ ", \"hiredate\":\"" + "2023.02.03"
				+"\", \"comm\":"+ 3500
				+", \"mgr\":"+ "hi"
				+", \"deptno\":"+ 20 +  "}");
			out.println("]}");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(out != null) out.close();
		}
		
	}
}
