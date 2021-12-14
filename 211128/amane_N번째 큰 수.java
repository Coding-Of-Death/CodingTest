import java.util.*;

class Main {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
    	for(int i = 0; i < n * n; i++) {
    		q.add(sc.nextInt());
    	}
    	
    	for(int i = 1; i < n; i++) {
    		q.poll();
    	}
    	
    	System.out.print(q.poll());
	}
}
