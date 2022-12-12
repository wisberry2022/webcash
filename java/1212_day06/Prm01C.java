class Prm01C {
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int su1, su2, su3;
		boolean flag = true;
		System.out.println("계산기(ver 0.1.0)");
		while(flag) {
			System.out.print("첫 번째 숫자를 입력하시오 > ");
			su1 = sc.nextInt();
			System.out.print("두 번째 숫자를 입력하시오 > ");
			su2 = sc.nextInt();
			System.out.print("1.+  2.-  3.x  4.÷");
			su3 = sc.nextInt();
			System.out.println("결과>");
			String msg = "+";
			int result = 0;
			if(su3 == 4 && su1%su2 == 0) {
				double result2 = su1*1.0 / su2;
				msg = "÷";
				System.out.println(su1+msg+su2+"="+ result2);
				flag = false;
			}else if(su3>0 && su3<5) {
				if(su3 == 1) {
					result = su1 + su2;
					msg = "+";
				}
				else if(su3 == 2) {
					result = su1 - su2;
					msg = "-";
				}
				else if(su3 == 3) {
					result = su1 * su2;
					msg = "x";
				}else if(su3 == 4){
					result = su1 / su2;
					msg = "÷";
				}
				System.out.println(su1+msg+su2+"="+ result);
				flag = false;
			}else {
				System.out.println("연산의 선택이 잘못되었습니다!");
				System.out.println("1 ~ 4 사이로 다시 확인하시고 입력바랍니다");
			}	
		}
	}
}	