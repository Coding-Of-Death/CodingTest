import java.util.*;

 
public class Main {
	static final boolean DROP = true;
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		boolean flag = DROP;
		
		int n = scan.nextInt();
		
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}
		
		while (queue.size() > 1) {
			if(flag == DROP) {
				queue.poll();
			} else {
				queue.offer(queue.poll());
			}
			flag = !flag;
		}
		
		System.out.println(queue.poll());
	}
}
