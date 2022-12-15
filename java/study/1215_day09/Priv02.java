package day09;

public class Priv02 {

	public static void main(String[] args) {
		// Scanner + 반복문
		boolean isEnd = true;
		while(isEnd) {
			System.out.println("아래 메뉴를 선택하세요!");
			System.out.println("A.1   B.2   C.3   D.4   E.5");
			java.util.Scanner sc = new java.util.Scanner(System.in);
			String key = sc.nextLine();
			if(key.equals("E")) {
				System.out.println("종료!");
				isEnd = false;
			}
		}
		
		int[] arr = new int[5];
		System.out.println("숫자를 입력하세요!");
		for(int i = 0; i<5; i++) {
			System.out.println(5-i + "번 남았습니다!");
			java.util.Scanner sc = new java.util.Scanner(System.in);
			arr[i] = sc.nextInt();
		}
		System.out.println();
		
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
