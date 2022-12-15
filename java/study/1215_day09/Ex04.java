package day09;

public class Ex04 {
	// 필수적으로 알아야하는 메소드
	public static void main(String[] args) {
		String st1 = "abcabcdefg";
		// 인덱스를 통해 문자열의 문자 반환
		System.out.println(st1.charAt(1));
		// 특정 문자열이 포함되어있는지 확인(boolean return)
		System.out.println(st1.contains("Ccde"));
		// 특정 문자열이 특정 문자로 시작/끝나는지 확인하는 메소드(boolean true)
		System.out.println(st1.endsWith("f"));
		System.out.println(st1.startsWith("efg"));
		// 문자/문자열을 통해 문자열 내 문자가 위치한 인덱스를 반환
		// 중복된 문자가 있을 경우 첫 번째로 등장한 문자의 인덱스만 반환
		// 검색 시작범위 지정 가능(두 번째 파라미터)
		System.out.println(st1.indexOf('a', 1));
		System.out.println(st1.indexOf("ab", 2));
		// String이 비어있는지를 검사(boolean return)
		System.out.println("".isEmpty());
		System.out.println("ab".isEmpty());
		// indexOf의 역
		System.out.println(st1.lastIndexOf('a',1));
		System.out.println(st1.indexOf('A'));
		// Substring - 인자로 받은 인덱스부터 끝까지 위치한 문자열을 반환한다. 
		System.out.println(st1.substring(2));
		String st3 = st1.substring(3,5);
		System.out.println(st3);
		System.out.println(st1.charAt(8));
		System.out.println(st1.substring(8,9));
		System.out.println(st1.substring(st1.indexOf('a',2), st1.indexOf('c',3)+1));
		String st4 = st1.substring(9,10);
		// replace - 문자열에 존재하는 모든 문자를 두 번째 인자로 받은 문자로 모두 바꾼다. (새로운 String return)
		// 잘 활용하면 생성, 수정, 삭제가 가능하다
		// 첫 번째 인자가 문자열에 존재하지 않을 경우 아무 일도 하지 않는다
		String st5 = st1.replace("abca", "Abca");
		System.out.println(st5);
		String st6 = st1.replace("ca", "c");
		System.out.println(st6);
		// 위와 같은 문자열 메소드는 대부분 원본 문자열(혹은 문자열 변수)를 변경하지 않고 새로운 문자열을 return한다.
		System.out.println(st1);
		
//		int[] arr1 = new int[2];
//		arr1[0] = 1;
//		arr1[1] = 2;
		
//		System.out.println(arr1);
//		System.out.println(st1);
//		System.out.print(new String("자바")=="자바");
//		System.out.println(1+1);
//		System.out.println("1"+1);
		
	}

}
