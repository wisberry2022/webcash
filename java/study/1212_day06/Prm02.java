import java.util.Scanner;

class Prm02 {
	class Calc {
		public int num1;
		public int num2;
		public int operand;
		public int Result;

		public void setInfo(int num1, int num2, int operand) {
			num1 = num1;
			num2 = num2;
			operand = operand;
		}

		public void showInfo() {
			System.out.println(num1);
			System.out.println(num2);
			System.out.println(operand);
			System.out.println(Result);
		}
	}

	public static void main(String[] args) {
		int num1, num2, operand;
		Scanner sc = new Scanner(System.in);
		Prm02 P2 = new Prm02();
		System.out.println(P2.Calc());
		System.out.print("첫 번째 숫자를 입력하세요! >> ");
		num1 = sc.nextInt();
		System.out.print("두 번째 숫자를 입력하세요! >> ");
		num2 = sc.nextInt();
		System.out.print("1.+   2.-   3.x   4.÷");
		operand = sc.nextInt();
		System.out.print(num1 + " " + num2 + " " + operand);
		// C.setInfo(num1, num2, operand);
		// C.showInfo();
	}
}