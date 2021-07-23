import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static final int MAXSIZE = 100_001;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] times = new int[MAXSIZE];
		init(times);
		bfs(N, times);
		
		System.out.println(times[K]);
	}
	
	public static void init(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
	}
	
	public static void bfs(int start, int[] arr) {
		Queue<Integer> queue = new LinkedList<>();
		
		arr[start] = 0;
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			
			if (x - 1 >= 0 && arr[x - 1] == -1) {
				arr[x - 1] = arr[x] + 1;
				queue.add(x - 1);
			}
			
			if (x + 1 < MAXSIZE && arr[x + 1] == -1) {
				arr[x + 1] = arr[x] + 1;
				queue.add(x + 1);
			}
			
			if (x * 2 < MAXSIZE && arr[x * 2] == -1) {
				arr[x * 2] = arr[x] + 1;
				queue.add(x * 2);
			}
		}
	}
}
