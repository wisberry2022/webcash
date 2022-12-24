package week3;

import java.util.*;

class Customer {
	static int wait = 0;
	int customerId;
	String name;
	String inquiry;
	String counselor;
	
	public Customer(String name){
		this.name = name;
		customerId = ++wait;
	}
}

public class Priv01 {
	static String[] Counselors = new String[] {"장진욱", "우동현", "강지우", "박지훈", "왕인서"};
	static String[] Inqueries = new String[] {"에러문의", "솔루션 도입문의", "솔루션 해지문의", "기타"};
	
	public static void main(String[] args) {
		Queue<Customer> Service = new LinkedList<>();
		System.out.println("웹케시 고객센터 ver0.1.0");
		
		String select;
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			boolean isFinish = true;
			System.out.print("0.상담신청         1.신청내역         2.상담내용수정         3.종료   > ");
			select = sc.nextLine();
			if(select.equals("0")) {
				String name;
				System.out.print("이름을 입력해주세요! >  ");
				name = sc.nextLine();
				Customer you = new Customer(name);
				while(isFinish) {
					System.out.println("------------------------------------------------");
					System.out.println("0.에러문의    1.솔루션 도입문의    2.솔루션 해지문의    3.기타    4.취소");
					select = sc.nextLine();
					if("01234".contains(select)) {
						int idx = Integer.parseInt(select);
						if(idx == 4) {
							System.out.println("이용해주셔서 감사합니다.");
							Customer.wait--;
							break;
						}else {
							you.inquiry = Inqueries[idx];
							you.counselor = Counselors[(int)(Math.random()*5)];	
							Service.offer(you);
						}
					}
					else {
						System.out.println("0번에서 4번까지의 번호만 입력할 수 있습니다. 다시 확인해주세요!");
						System.out.println("------------------------------------------------");
						continue;
					}
					System.out.println("대기번호: " + Customer.wait + "번");
					System.out.println("신청자 성함: " + you.name + "님");
					System.out.println("배정상담사: " + you.counselor + " 상담사");
					System.out.println("상담내용: " + you.inquiry);
					System.out.println("------------------------------------------------");
					isFinish = false;
				}
			}else if(select.equals("1")) {
				String name;
				System.out.println("------------------------------------------------");
				System.out.print("이름을 입력하세요> ");
				name = sc.nextLine();
				Iterator<Customer> ite = Service.iterator();
				if(ite.hasNext()) {
					boolean isNotCheck = true;
					while(ite.hasNext()) {
						Customer you = ite.next();
						if(you.name.equals(name)) {
							System.out.println("대기번호: " + you.customerId + "번");
							System.out.println("신청자 성함: " + you.name + "님");
							System.out.println("배정상담사: " + you.counselor + " 상담사");
							System.out.println("상담내용: " + you.inquiry);
							System.out.println("------------------------------------------------");
							isNotCheck = false;
							break;
						}
					}
					if(isNotCheck) {
						System.out.println("일치하는 이름이 없습니다! 먼저 상담신청부터 해주세요!");
						System.out.println("------------------------------------------------");	
					}
				}else {
					System.out.println("신청한 상담내용이 없습니다!");
				}
			}else if(select.equals("2")) {
				System.out.println("------------------------------------------------");
				boolean finish = false;
				String name;
				System.out.print("이름을 입력하세요!> ");
				name = sc.nextLine();
				Iterator<Customer> ite = Service.iterator();
				while(ite.hasNext()) {
					Customer you = ite.next();
					if(you.name.equals(name)) {
						int modify;
						System.out.println("수정하고자 하는 상담내용번호를 입력해주세요");
						for(int i = 0; i<Inqueries.length; i++) {
							if(you.inquiry.equals(Inqueries[i])) {
								System.out.print(i+ "." + Inqueries[i] + "(기존신청내역)  ");
							}else {
								System.out.print(i+ "." + Inqueries[i] + "   ");
							}
						}
						System.out.print(" >  ");
						modify = sc.nextInt();
						you.inquiry = Inqueries[modify];
						finish = true;
						break;
					}
				}
				if(finish) {
					System.out.println("------------------------------------------------");
				}else {
					System.out.println("일치하는 이름이 없습니다! 먼저 상담신청부터 해주세요!");
					System.out.println("------------------------------------------------");
				}
			}else if(select.equals("3")) {
				System.out.println("이용해주셔서 감사합니다");
				return;
			}else {
				System.out.println("0번과 1번 메뉴 중 하나만 선택해주세요!");
			}
		}
	}

}
