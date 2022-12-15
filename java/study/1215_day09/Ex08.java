package day09;

public class Ex08 {
	public static void main(String[] args) {
		Ex08[] arr0 = new Ex08[4];
		String[] arr1 = new String[4];
		
		arr0[0] = new Ex08();
		
		for(int i = 0; i<arr0.length; i++) {
			System.out.print(arr0[i]);
		}
		
		System.out.println();
		
		for(int i = 0; i<arr1.length; i++) {
			System.out.print(arr1[i]);
		}
		
		int[][] arr3 = new int[3][2];
		arr3[0] = new int[] {1,2,3};
		arr3[1] = new int[] {4,5};
		arr3[2] = new int[] {6};
		
		System.out.println();
		
		for(int i = 0; i<arr3.length; i++) {
			for(int j = 0; j<arr3[i].length; j++) {
				System.out.print(arr3[i][j]);
			};
			System.out.println();
		}
	}

}
