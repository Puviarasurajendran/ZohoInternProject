package javaquestion1;

import java.util.Scanner;

public class Practice {

	
	public static int add(int... a) {
		int res = 0;
		for (int i = 0; i < a.length; i++) {
			res += a[i];
		}
		return res;
	}
	
  public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	System.out.println("How many Numbers do you want to add");
	int n= sc.nextInt();
	System.out.println("Enter Numbers do you want to add");
	int arr[]=new int[n];
	for (int i = 0; i < n; i++) {
		arr[i]=sc.nextInt();
	}
	System.out.println(add(arr));
}
}
