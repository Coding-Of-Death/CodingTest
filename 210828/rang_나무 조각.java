import java.util.*;


public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] arr = new int[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = scan.nextInt();
		}
		
		while (!checkOrder(arr)) {
			for (int i = 0; i < 4; i++) {
				if (arr[i] > arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					print(arr);
				}
			}
		}
	}
	
	static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	static boolean checkOrder(int[] arr) {
		for (int i = 0 ; i < arr.length; i++) {			
			if(arr[i] != i+1)
				return false;
		}
		return true;
	}
}
