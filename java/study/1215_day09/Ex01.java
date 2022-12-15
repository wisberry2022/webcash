package day09;

public class Ex01 {
	public static void main(String[] args) {
	     String msg1 = "문자열";
	     String msg2 = "문자";
	     String msg3 = "열";
	     String msg4 = msg2 + msg3;
	     String msg5 = "문자" + "열";
	     String msg6 = msg2.concat(msg3);
	     System.out.println(msg6);
	     System.out.println(msg1 == msg5);
	     System.out.println(msg1 == msg6);
	     String st1 = "문자열";
	     String st2 = "문자열";
	     String st3 = new String("문자열");
	     System.out.println(st1 == st2);
	     System.out.println(st1 == st3);
	     
	}

}
