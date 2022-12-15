package day09;

public class Ex11 {
	public static void main(String[] args) {
		int[] target = {1,3,5,7,9};
		int[] result = new int[5];
		
		// 깊은 복사
		System.arraycopy(target, 0, result, 0, 5);
		
		target[3] = 30;
		
		for(int i = 0; i<result.length; i++) {
			System.out.print(result[i] + " ");
		}
		
	}

}
