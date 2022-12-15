package day09;

public class Priv01 {

	public static boolean isRightSettingNum(String msg, int num) {
		return msg.length() <= num;
	}
	
	public static void main(String[] args) {
		
		boolean endFlag = false;
		
		do 
		{
//			하나의 스캐너는 하나의 입력만 받을 수 있다.
			java.util.Scanner numStream = new java.util.Scanner(System.in);
			java.util.Scanner strStream = new java.util.Scanner(System.in);
			System.out.println("아무 숫자나 입력해보세요!");
			int inputNum = numStream.nextInt();
			System.out.println("아무 글자나 입력해보세요!");
			String inputMSG = strStream.nextLine();
						
			if(!isRightSettingNum(inputMSG, inputNum)) {
				System.out.println(inputNum + "자 이내로 작성해주세요!");
			}else {
				for(int i = 0; i<inputMSG.length(); i++) {
					System.out.print(inputMSG.charAt(i));
				}
				endFlag = true;	
			}
		}while(!endFlag);
		

	}

}
