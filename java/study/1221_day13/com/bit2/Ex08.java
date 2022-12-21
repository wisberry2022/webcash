package com.bit2;

public class Ex08 {

	public static void main(String[] args) {
		char ch1 = 'a';
		Character ch2 = new Character('A');
		Character ch3 = new Character((char)35);
		
		// char 변수가 문자인지 알려준다. => 문자(알파벳, 한글)일 경우 true, 문자가 아닐 경우 false
		System.out.println(Character.isAlphabetic('3'));
		System.out.println(Character.isDigit(ch1));
		System.out.println(Character.isSpace(ch1));
		System.out.println(Character.isWhitespace(ch1));
		System.out.println(Character.isUpperCase(ch1));
		System.out.println(Character.isLowerCase(ch1));
		System.out.println(Character.reverseBytes('곿'));
	}

}
