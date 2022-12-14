import java.util.Scanner;

class Prm01 {
	public int num1;
	public int num2;
	public int operand;
	public int Result;
	public float fResult;

	public static void main(String[] args){
		Prm01 Calc = new Prm01();
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 숫자를 입력하시오 >> ");
		Calc.num1 = sc.nextInt();
		System.out.print("두 번째 숫자를 입력하시오 >> ");
		Calc.num2 = sc.nextInt();
		System.out.print("1.+   2.-   3.x   4.÷ > ");
		Calc.operand = sc.nextInt();
		sc.close();
		Calc.calcNum();
	}

	public void calcNum() {
		if(operand == 1){
			plusNum(num1, num2);
			System.out.println("결과 >> ");
			System.out.print(num1 + " " + "+" + " " + num2 + " = " + Result);
		}else if(operand == 2){
			minusNum(num1, num2);
			System.out.println("결과 >> ");
			System.out.print(num1 + " " + "-" + " " + num2 + " = " + Result);
		}else if(operand == 3){
			productNum(num1, num2);
			System.out.println("결과 >> ");
			System.out.print(num1 + " " + "x" + " " + num2 + " = " + Result);
		}else if(operand == 4){
			divideNum(num1, num2);
			System.out.println("결과 >> ");
			System.out.print(num1 + " " + "÷" + " " + num2 + " = " + fResult);
		}
	}

	public void plusNum(int num1, int num2) {
		Result = num1 + num2;
	}

	public void minusNum(int num1, int num2) {
		Result = num1 - num2;
	}

	public void productNum(int num1, int num2) {
		Result = num1 * num2;
	}

	public void divideNum(int num1, int num2) {
		fResult = (float)num1 / (float)num2;
	}
}