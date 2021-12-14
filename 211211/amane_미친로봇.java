import java.util.*;

class Main {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[] percent = new int[4];
	static boolean[][] check = new boolean[30][30];
	static int n;
	static double answer = 0;
	
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	n = sc.nextInt();
    	for(int i = 0; i < 4; i++) {
    		percent[i] = sc.nextInt();
    	}
    	
    	check[15][15] = true;
    	dfs(15, 15, 0, 1.0);
    	System.out.println(String.format("%.10f", answer));
	}
	
	static void dfs(int x, int y, int cnt, double val) {
		if(cnt == n) {
			answer += val;
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			
			if(!check[mx][my]) {
				check[mx][my] = true;
				dfs(mx, my, cnt+1, val * 0.01 * percent[i]);
				check[mx][my] = false;
			}
		}
	}
}
