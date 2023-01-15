package day0115;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Join {

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation", "root", "");
			System.out.println("success!");
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select b.no from reservation as a right join room as b on a.room_no = b.no where a.room_no is null");
			while(rs.next()) {
				System.out.print("미예약 호실: ");
				System.out.print(rs.getNString("no") + "\n");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
