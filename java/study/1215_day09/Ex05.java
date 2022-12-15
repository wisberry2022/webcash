package day09;

public class Ex05 {
	public static void main(String[] args) {
		String msg = "abcABC1234!@#$";
		// 대소문자 변환
		String st1 = msg.toUpperCase();
		String st2 = msg.toLowerCase();
		System.out.println(st1);
		System.out.println(st2);
		
		// valueOf - String으로 만들어준다.
		char[] arr1 = {'a','b','c'};
		System.out.println(new String(arr1));
		System.out.println(String.valueOf(arr1));
		System.out.println(arr1);
		
		String st3 = 1234+"";
		String st4 = String.valueOf(1234);
		System.out.println(st4);
		
		
		
		
	}

}
