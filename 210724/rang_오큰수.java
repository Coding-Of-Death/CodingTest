import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		
		nge(arr);
		
		scan.close();
	}
	
	static void nge(int[] arr) {		
		Stack<Integer> stack = new Stack<>();
		StringBuffer sb = new StringBuffer();
		int[] result = new int[arr.length];
		
		int end = arr.length - 1;
		stack.push(arr[end]);
		result[end] = -1;
		
		int max = -1;
		for (int i = end - 1; i >= 0; i--) {
			if (arr[i] < stack.peek())
				max = stack.peek();
			
			if (arr[i] < max) {
				result[i] = max;			
			} else {
				while (!stack.isEmpty()) {
					max = stack.pop();
					if (arr[i] < max) {
						result[i] = max;
						stack.push(max);
						break;
					}
					
					if (stack.isEmpty()) {
						result[i] = -1;
					}
				}
			}
			stack.push(arr[i]);
		}
		
		for (int r : result) {
			sb.append(r).append(" ");
		}
		System.out.println(sb);
	}
}
