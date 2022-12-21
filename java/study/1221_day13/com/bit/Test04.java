package com.bit;

public class Test04 {

	public static void main(String[] args) {
		System.out.println("주민등록번호 검사기 ver0.2.0");
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		while(true) {
			boolean isBool = false;
			String gender, id;
			System.out.print("주민등록번호를 입력하세요>");
			id = sc.nextLine();
			int age = 0;
			
			for(int i = 0; i<id.length(); i++) {
				if(i != 6 && ((id.charAt(i) < '0') || (id.charAt(i) >'9'))) {
					isBool = true;
				}
			}
			
			if(id.split("-").length != 2) {
				System.out.println("잘못된 입력입니다!(000000-0000000)");
			}else if(id.length() != 14) {
				System.out.println("잘못된 입력입니다! 주민등록번호는 특수문자(-)포함 14자리입니다!");
			}else if(isBool) {
				System.out.println("잘못된 입력입니다! 숫자만 입력해주세요!");
			}else {
				if(Integer.parseInt(String.valueOf(id.charAt(7))) <= 2) age = 2022 - (1900 + new Integer(id.substring(0,2)))+1;
				else if(Integer.parseInt(String.valueOf(id.charAt(7))) > 2) age = 2022 - (2000 + new Integer(id.substring(0,2)))+1;		
				if((id.charAt(7)-'0') % 2 == 1) gender = "남성";
				else gender = "여성";
				System.out.println(age + "살의 " + gender + "입니다");	
				break;
			}
		}

	}

}
