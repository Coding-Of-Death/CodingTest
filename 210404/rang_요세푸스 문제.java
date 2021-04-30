import java.util.*;

public class Main {
	static String order ="";
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int k = scan.nextInt();
		
		josephusPerm(n, k);
		System.out.println("<" + order + ">");
	}
	
	
	public static void josephusPerm(int n, int k) {
		Queue<String> in = new LinkedList<>();
		
		for (int i = 1; i <= n; i++)
			in.offer(String.valueOf(i));
		
		while (!in.isEmpty()) {
			if (in.size() == 1) {
				order += in.poll();
				break;
			}
			
			for (int i = 1; i < k; i++) {
				in.offer(in.poll());
			}
			order += in.poll() + ", ";
			
		}
	}
}
