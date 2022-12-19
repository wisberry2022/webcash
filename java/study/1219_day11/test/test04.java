package test;

public class test04 {
	public static void main(String[] args) {
		System.out.println("학생성적관리프로그램(0.2.0)");
		java.util.Scanner sc;
		sc = new java.util.Scanner(System.in);
		int input = 0;
		String data = "";
		String[] arr2;
		
		while(true) {
			System.out.println("1.리스트      2.입력      3.상세보기      4.삭제      0.종료");
			input = sc.nextInt();
			if(input == 0) break;
			else if(input == 1) {
				System.out.println("-----------------------------");
				System.out.println("학번\tjava\tweb\tframework");
				System.out.println("-----------------------------");
				System.out.print(data);
				System.out.println("-----------------------------");
			}
			else if(input == 2) {
				System.out.print("학번>");
				input = sc.nextInt();
				data+=input+"\t";
				System.out.print("java>");
				input = sc.nextInt();
				data+=input+"\t";
				System.out.print("web>");
				input = sc.nextInt();
				data+=input+"\t";
				System.out.print("framework>");
				input = sc.nextInt();
				data+=input+"\n";
			}
			else if(input == 3) {
				System.out.print("학번>");
				input = sc.nextInt();				
				String[] arr1 = data.split("\n");
				for(int i = 0; i<=arr1.length-1; i++) {
					arr2 = arr1[i].split("\t");
					if(arr2[0].equals(input + "")) {
						int sum = inputSu(arr2[1])
								+ inputSu(arr2[2])
								+ inputSu(arr2[3]);
						System.out.println("합계:" + sum);
						break;
					}
				}
				System.out.println(input + "학번의 합계, 평균, 학점");
			}
			else if(input == 4) {}
		}
		
	}

	// String input을 숫자로 바꿔주는 기능
	public static int inputSu(String input) {
		int sum = 0;
		int m = 0;
		int n = 1;
		for(int i = input.length()-1; i>=0; i--) {
			for(int j = 0; j<m; j++) {n*=10;}
			sum+=(input.charAt(i) - '0')*n;n=1;m++;
		}
		return sum;
	}
}
