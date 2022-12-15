package day09;

public class Ex06 {

	public static void main(String[] args) {
//		String target = "24148|강원도|화천군|상서면";
		String target = "java,DB,,web,framework";
		// trim() -> 문자열의 좌우 양측 공백을 제거한다
		System.out.println(target.trim());

		//split(String str) -> str 기준으로 String 배열로 반환
//		String[] arr1 = target.split("\\|");
		String[] arr1 = target.split(",");
		for(int i = 0; i<arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		
		//compareTo - 두 문자열을 비교하여 같을 경우 0을 출력한다.
		// 길이가 다를 경우 길이의 차에 대한 정보를 배출한다.
		// 문자가 다를 경우 두 문자 간의 차이를 반환한다(아스키코드 값 - 아스키코드 값) (단 처음으로 달라지는 문자에 대한 차이만 반환한다)
		String st1 = "java";
		String st2 = "jbvaaaa";
		System.out.println(st1.compareTo(st2));
		
	}

}
