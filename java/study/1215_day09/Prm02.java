package day09;

public class Prm02 {

	public static void main(String[] args) {
		//Q1.
		System.out.println("================Q1================");
		
		int[] su1 = {1,4,6,7,9};
		for(int i = 0; i<su1.length; i++) {
			su1[i] += 2;
		}
		
		for(int i = 0; i<su1.length; i++) {
			System.out.print(su1[i] + " ");
		}
		
		System.out.println("\n================Q2================");
		
		int[] oddSet = new int[5];
		int j = 0;
		for(int i = 1; i<=9; i+=2) {
			oddSet[j] = i;
			j++;
		}
		
		for(int i = 0; i<oddSet.length; i++) {
			System.out.print(oddSet[i] + " ");
		}
		
		
		System.out.println("\n================Q3================");
		
		// 1번째 방법
		char[] alphaSet = new char['Z'-'A'+1];
		int k = 0;
		for(char i='A'; i<='Z'; i++) {
			alphaSet[k] = i;
			k++;
		}
		
		for(int i = 0; i<alphaSet.length; i++) {
			System.out.print(alphaSet[i] + " ");
		}
		
		System.out.println();
		
		// 2번째 방법
		char[] alphaSet2 = new char['Z' - 'A' + 1];
		for(int i = 0; i<alphaSet2.length; i++) {
			alphaSet2[i] = (char)('A'+i);
		}
		
		for(int i = 0; i<alphaSet2.length; i++) {
			System.out.print(alphaSet2[i] + " ");
		}
		
		System.out.println("\n================Q4================");
		
		int[] su4 = {9,10,20,7,2,4,8,3};
//		int[] su4 = {1,5,30,32,51,19,8,2};
		int cnt = 0;
		// 중지 조건?
		while(true) {
			for(int i = 0; i<su4.length; i++) {
				int temp = 0;
				if(i != su4.length-1 && su4[i] >= su4[i+1]) {
					temp = su4[i+1];
					su4[i+1] = su4[i];
					su4[i] = temp;
					// 비교연산이 진행되었을 때만 cnt가 체크된다.
					cnt++;
				}	
			}
			// 비교연산이 진행되지 않았다는 것은 모든 정렬이 완료되었다는 의미이므로 cnt값은 증가하지 않는다. 이 때 break하여 while문 탈출
			if(cnt == 0) {
				break;
			}
			cnt = 0;
		}
		
		
		for(int i = 0; i<su4.length; i++) {
			System.out.print(su4[i] + " ");
		}
	}

}
