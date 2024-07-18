package labeledstatement;

public class LabelsExample {
	
	public static void eliminateNegativeArray(int [][] arr) {
		
		firstLoop:
			for (int i=0;i<arr.length;i++) {
				secondLoop:
					for (int j=0;j<arr[i].length;j++) {
						
						if(arr[i][j]<0) {
							System.out.println();
							System.out.println("-------------------");
							continue firstLoop;
						}
						System.out.print(arr[i][j]+" ");
					}
				System.out.println();
				thirdLoop:
                       for (int j=arr[i].length-1;j>=0;j--) {
						System.out.print(arr[i][j]+" ");
					}
				System.out.println();
				System.out.println("-------------------");
			}
		
	}
	
	public static void main(String[] args) {
		
		int[][] mat= { { 1, 2, 3 }, { 6, -7, 8 }, { 4, 5, 6 } };
		
		eliminateNegativeArray(mat);
	}

}
