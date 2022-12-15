package day09;

public class Prm01C {

	public static void main(String[] args) {
		int age=2022 - 1900;
		char gender = '여';
		
		boolean boo2 = true;
		
		String msg = null;
		char[] hangul = {
			'영','일','이','삼','사','오','육','칠','팔','구'	
		};
		

		java.util.Scanner sc;
		sc = new java.util.Scanner(System.in);
		
		do{
		System.out.print("주민번호>");
		String input = sc.nextLine();
		
		for(int i =0; i<input.length(); i++) {
			System.out.print(input.charAt(i));
		}
		
		for(int i = 0; i<hangul.length; i++) {
			input = input.replace(hangul[i], (char)(i+'0'));
		}
		
		System.out.println(input);
		boolean boo = false;
		
		for(int i = 0; i<input.length(); i++) {
			if(i != 6) {
				if(input.charAt(i)<'0' || input.charAt(i)>'9') {
					boo = true;
				}
			}
		}
		
		if(input.charAt(6) != '-') {
			msg="입력확인바랍니다(000000-0000000)";
			
		}else if(input.length() != 14) {
			msg = "입력확인바랍니다(앞자리 6개 뒷자리 7개)";
			
		}else if(boo) {
			msg = "입력확인바랍니다(숫자를  입력바랍니다)";
		}else {
	
			age-=(input.charAt(0) - '0')*10+(input.charAt(1) - '0')*1;
			age++;
		
			if(input.charAt(7)%2 != 0) gender = '남';
			if(input.charAt(7) > '2') {
				age -= 100;
			}
		
		
			msg = "당신은" + age + "세 " + gender+"성입니다";
			boo2 = false;
		}
			System.out.println(msg);
		}while(boo2);
	}

}
