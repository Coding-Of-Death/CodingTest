import java.util.*;

class Main {
	static int v, e, start;
	static List<Node>[] list;
	static boolean[] check;
	static int[] dist;
	
	static class Node implements Comparable<Node>{
		int next;
		int cost;
		
		public Node(int next, int cost) {
			this.next = next;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        v = sc.nextInt();
        e = sc.nextInt();
        start = sc.nextInt();
        list = new ArrayList[v + 1];
        check = new boolean[v + 1];
        dist = new int[v + 1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int i = 0; i <= v; i++) {
        	list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < e; i++) {
        	int u = sc.nextInt();
        	int next = sc.nextInt();
        	int cost = sc.nextInt();
        	
        	list[u].add(new Node(next, cost));
        }
        
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        dist[start] = 0;
        
        while(!q.isEmpty()) {
        	Node now = q.poll();
        	int c_next = now.next;
        	
        	if(!check[c_next])
        		check[c_next] = true;
        	
        	for(Node next_N : list[c_next]) {
        		if(dist[next_N.next] > dist[c_next] + next_N.cost) {
        			dist[next_N.next] = dist[c_next] + next_N.cost;
        			q.add(new Node(next_N.next, dist[next_N.next]));
        		}
        	}
        }
        
        for(int i = 1; i <= v; i++) {
        	if(dist[i] == Integer.MAX_VALUE)
        		System.out.println("INF");
        	else
        		System.out.println(dist[i]);
        }
    }
}
