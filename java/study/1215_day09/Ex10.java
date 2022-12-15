package day09;

public class Ex10 {

	public static void func1(int[] arr) {
		arr[0] = 0;
	}
	
	public static void main(String[] args) {
		int[] arr1 = new int[] {1,3,5,7};
		int[] arr2 = arr1;
		
		for(int i = 0; i<arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		
		// 배열의 얕은 복사
		
//		System.out.println();
//		
//		for(int i = 0; i<arr1.length; i++) {
//			System.out.print(arr1[i] + " " + arr2[i] + " ");
//		}
		
		// 배열의 깊은 복사
//		int[] arr3 = new int[] {1,3,5,7};
//		for(int i = 0; i<arr3.length; i++) {
//			System.out.print(arr3[i]);
//		}
		
		int[] arr3 = new int[4];
		for(int i = 0; i<arr3.length; i++) {
			arr3[i] = arr1[i];
		}
		
//		for(int i = 0; i<arr3.length; i++) {
//			System.out.print(arr3[i] + " ");
//		}
		
//		arr1[2] = 9;
		// 얕은 복사
		func1(arr1);
		
		for(int i = 0; i<arr3.length; i++) {
			System.out.print(arr1[i] + " ");
		}		
	}

}
