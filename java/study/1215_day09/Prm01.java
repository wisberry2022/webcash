package day09;

public class Prm01 {

	public static void main(String[] args) {
		
		System.out.println("주민번호체크(ver 0.1.1)");
		System.out.print("주민번호> ");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		String identify = sc.nextLine();
		boolean isHypen = false;
		sc.close();
		
		boolean result = false;
		char[] cArr = identify.toCharArray();
		
		for(int i = 0; i<cArr.length; i++) {
			if(('0' > cArr[i] || cArr[i] > '9') && cArr[i] != '-') {
				result = true;
			}
		}
		
		if(identify.split("-").length == 2) {
			isHypen = true;
		}
		
		if(!isHypen) {
			System.out.println("입력확인바랍니다(000000-0000000)");
			return;
		}else if(result){
			System.out.println("입력확인바랍니다(숫자만 입력하세요!)");	
			return;
		}else if(identify.length() != 14) {
			System.out.println("입력확인바랍니다(앞자리 6개 뒷자리 7개입니다)");	
			return;
		}else {
			String sAge = identify.substring(0,2);
			int age = 2022 - (1900+(sAge.charAt(0)-'0')*10 + (sAge.charAt(1)-'0'))+1;
					
			char genderPad = identify.charAt(identify.indexOf('-')+1);
			
			if(genderPad > '2') age -= 100;
			if(genderPad == '1' || genderPad == '3') {
				genderPad = '남';
			}else if(genderPad == '2' || genderPad == '4') {
				genderPad = '여';
			}
			System.out.println("당신은 " + age + "살 " + genderPad + "성입니다");				
		}
	}
}
