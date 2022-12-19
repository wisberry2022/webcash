package test;

class Stu {
	int num;
	final String name;
	int java, web, framework;
	
	public Stu(int num, String name) {
		this.num = num;
		this.name = name;
	}
	
	int total() {
		return java+web+framework;
	}
	
	double avg() {
		return total()*100/3/100.0;
	}
	
	char grade() {
		if(total() >= 3*90) return 'A';
		else if(total() >= 3*80) return 'B';
		else if(total() >= 3*70) return 'C';
		else if(total() >= 3*60) return 'D';
		else return 'F';
	}
}

public class test03 {
	public static void main(String[] args) {
		System.out.println("학생성적관리프로그램(0.2.0)");
		java.util.Scanner sc;
		sc = new java.util.Scanner(System.in);
		java.util.Scanner sc2;
		sc2 = new java.util.Scanner(System.in);
		int input = 0;
		System.out.print("총원>");
		input = sc.nextInt();
		Stu[] data = new Stu[input];
		int cnt = 0;
		
		while(true) {
			System.out.println("1.리스트      2.입력      3.상세보기      4.삭제      0.종료");
			input = sc.nextInt();
			if(input == 0) break;
			else if(input == 1) {
				System.out.println("-----------------------------------");
				System.out.println("학번\t이름\tjava\tweb\tframework");
				System.out.println("-----------------------------------");
				for(int i = 0; i<data.length; i++) {
					Stu stu = data[i];
					if(stu == null) {
						break;
					}
					System.out.println(stu.num + "\t" + stu.name + "\t" + stu.java + "\t" + stu.web + "\t" + stu.framework);
				}
				System.out.println("-----------------------------------");
			}
			else if(input == 2) {
				Stu stu;
				System.out.print("학번>");
				input = sc.nextInt();
				System.out.print("이름>");
				String input2 = sc2.nextLine();
				stu = new Stu(input, input2);
				System.out.print("java>");
				input = sc.nextInt();
				stu.java = input;
				System.out.print("web>");
				input = sc.nextInt();
				stu.web = input;
				System.out.print("framework>");
				input = sc.nextInt();
				stu.framework = input;
				data[cnt++] = stu;
			}
			else if(input == 3) {
				System.out.print("학번>");
				input = sc.nextInt();
				for(int i = 0; i<data.length; i++) {
					Stu stu = data[i];
					if(stu.num == input) {
						System.out.println("합계:"+stu.total());
						System.out.println("평균:"+stu.avg());
						System.out.println("학점:"+stu.grade());	
						break;
					}
				}
				
			}
			else if(input == 4) {}
		}
		
	}

}
