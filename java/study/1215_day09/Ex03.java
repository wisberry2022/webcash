package day09;

public class Ex03 {
	public static void main(String[] args) {
		String msg1 = "문자"+"열";
		String msg2 = "문자".concat("열");	
		System.out.println(msg1 == msg2);
		System.out.println(msg1.equals(msg2));
		
		byte[] arr1 = msg1.getBytes();
		char[] arr2 = msg2.toCharArray();
		System.out.println(arr1.length);
		System.out.println(arr2.length);
		
//		char[] arr3 = new char[3];
		char[] arr3 = {'a','b','c','d','e'};
		msg1.getChars(0, 2, arr3, 1);
		System.out.println(new String(arr3));
		System.out.println(msg1.length());
		
		
		System.out.println(msg1.toString());
		
		System.out.println(msg1 == msg1.toString());
	}

}
