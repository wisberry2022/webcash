package day0114;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DBCON {
	public static String getWhereQuery(String left, String right) {
		return "select * from employee where " + left + "=" + "'" + right + "'";
	}
	
	public static String getInsertQuery(String iData) {
		return "insert into employee(emp_id, name, gender, depart, recruit, salaries, behavior)"
				+ "values(" + iData + ")" ;
	}
	
	public static String getDeleteQuery(String target) {
		return "delete from employee where name="+"'" + target +"'";
	}
	
	public static String getUpdateQuery(String whereLeft, String whereRight, String set) {
		return "update employee set " + set + "where " + whereLeft + "=" + "'" + whereRight + "'";
	}
	
	public static void showData(ResultSet rs) {
		System.out.println("사원번호" + "\t" + "사원명" + "\t\t" + "성별" + "\t" + "소속부서" + "\t\t" + "입사일자" + "\t\t" + "연봉" + "\t" + "근무태도");
		try {
			while(rs.next()) {
				System.out.print(rs.getInt("emp_id") + "\t");
				if(rs.getNString("name").length() > 7) {
					System.out.print(rs.getNString("name") + "\t");	
				}else {
					System.out.print(rs.getNString("name") + "\t\t");
				}
				System.out.print(rs.getNString("gender") + "\t");
				if(rs.getNString("depart").equals("Marketing")) {
					System.out.print(rs.getNString("depart") + "\t");	
				}else {
					System.out.print(rs.getNString("depart") + "\t\t");
				}
				
				System.out.print(rs.getDate("recruit") + "\t");
				System.out.print(rs.getInt("salaries") + "\t");
				System.out.print(rs.getInt("behavior") + "\n");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		String select;
		Map<String, String> fieldMap = new HashMap<>();
		String[] korSet = {"사원번호", "사원명", "성별", "소속부서", "입사일자", "연봉", "근무태도"};
		String[] engSet = {"emp_id", "name", "gender", "depart", "recruit", "salaries", "behavior"};
		
		for(int i = 0; i<korSet.length; i++) {
			fieldMap.put(korSet[i], engSet[i]);	
		}
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root", "");
			System.out.println("success!");
			
			Statement stmt = conn.createStatement();
		
			while(true) {
				Scanner sc = new Scanner(System.in);
				System.out.print("1.전체 데이터 조회" + "\t" + "2.특정 데이터 조회" + "\t" + "3.데이터 삽입 " + "\t" + "4.데이터 삭제 " + "\t" + "5.데이터 수정> ");
				select = sc.nextLine();
				if(select.equals("1")) {
					ResultSet rs = stmt.executeQuery("select * from employee");
					showData(rs);
				}else if(select.equals("2")) {
					String key;
					String value;
					String[] searchs = {"사원번호", "사원명", "성별", "소속부서", "입사일자"};
					for(int i = 0; i<searchs.length; i++) {
						System.out.print(searchs[i] + "로 조회하기" + "\t");
						if(i == searchs.length-1) System.out.println();
					}
					System.out.println("==========================================================================================================");
					System.out.print("조회할 필드 > ");
					key = sc.nextLine();
					System.out.print("조회할 대상 > ");
					value = sc.nextLine();
					String query = getWhereQuery(fieldMap.get(key), value);
					ResultSet sr = stmt.executeQuery(query);
					showData(sr);
				}else if(select.equals("3")) {
					String inserting = "";
					for(int i = 0; i<korSet.length; i++) {
						System.out.print(korSet[i] + "> ");
						if(i == korSet.length-1) inserting += "'" + sc.nextLine() + "'";
						else inserting += "'" + sc.nextLine() + "',";		
					}
					String query = getInsertQuery(inserting);
					try {
						stmt.execute(query);
						System.out.println("데이터 추가 성공!");
					}catch(Exception e) {
						System.out.println("데이터 추가 실패! 관리자에게 문의하세요!");	
					}
					
				}else if(select.equals("4")) {
					String target;
					System.out.print("삭제하고자 하는 사원의 이름을 입력하세요!> ");
					target = sc.nextLine();
					String query =  getDeleteQuery(target);
					try {
						stmt.execute(query);
						System.out.println("데이터 삭제 성공!");
					}catch(Exception e) {
						System.out.println("데이터 삭제 실패! 관리자에게 문의하세요!");	
					}
				}else if(select.equals("5")) {
					String emp_id, key, value;
					String set = "";
					System.out.println("수정하고자 하는 사원의 번호를 입력하세요!");
					emp_id = sc.nextLine();
					for(int i = 1; i<korSet.length; i++) {
						if(i == korSet.length-1) {
							System.out.print(korSet[i] + " 수정" + "\n");	
						}else {
							System.out.print(korSet[i] + " 수정" + "\t");
						}
					}
					System.out.println("==========================================================================================================");
					System.out.println("수정 중단은  필드 입력 시 exit를 누르시면 됩니다");
					while(true) {
						System.out.print("수정할 필드> ");
						key = sc.nextLine();
						if(key.equals("exit")) break;
						System.out.print("수정할 값> ");
						value = sc.nextLine();
						String fields = fieldMap.get(key) + "=" + "'" + value + "',";
						set += fields;
					}
					if(set.contains("=")) {
						set = set.substring(0, set.length()-1);
						String query = getUpdateQuery("emp_id", emp_id, set);
						stmt.execute(query);
						System.out.println("데이터 수정 성공!");
					}else {
						System.out.println("데이터 수정 실패! 관리자에게 문의하세요!");
						System.out.println(set);
					}
					
				}else {
					System.out.println("프로그램을 종료합니다!");
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
