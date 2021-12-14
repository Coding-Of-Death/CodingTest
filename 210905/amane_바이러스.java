import java.util.*;

public class Main{
	static int[][] computer;
	static int n, m;
	static boolean[] check;
	static int cnt = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();		
		m = sc.nextInt();
		computer = new int[n + 1][n + 1];
		check = new boolean[n + 1];
		
		for(int i = 0; i < m; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			computer[from][to] = computer[to][from] = 1;
		}
		
		System.out.println(dfs(1));
	}
	
	static int dfs(int v) {
		check[v] = true;
		
		for(int i = 1; i <= n; i++) {
			if(computer[v][i] == 1 && !check[i]) {
				cnt++;
				dfs(i);
			}
		}
		return cnt;
	}
}
