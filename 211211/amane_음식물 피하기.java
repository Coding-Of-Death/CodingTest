import java.util.*;

class Main {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static char[][] map;
	static boolean[][] check;
	static int tmp = 0, answer = 0;
	static int r, c;
	
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	r = sc.nextInt();
    	c = sc.nextInt();
    	int k = sc.nextInt();
    	map = new char[r][c];
    	check = new boolean[r][c];
    	
    	for(char[] m : map) {
    		Arrays.fill(m, '.');
    	}
    	
    	while(k --> 0) {
    		int x = sc.nextInt() - 1;
    		int y = sc.nextInt() - 1;
    		
    		map[x][y] = '*';
    	}
    	
    	for(int i = 0; i < r; i++) {
    		for(int j = 0; j < c; j++) {
    			if(!check[i][j] && map[i][j] == '*') {
    				tmp = 0;
    				dfs(i, j);
    				answer = Math.max(answer, tmp);
    			}
    		}
    	}
    	
    	System.out.print(answer);
	}
	
	static void dfs(int x, int y) {
		tmp++;
		check[x][y] = true;
		for(int d = 0; d < 4; d++) {
			int mx = x + dx[d];
			int my = y + dy[d];
			
			if(mx < 0 || mx >= r || my < 0 || my >= c)
				continue;
			
			if(!check[mx][my] && map[mx][my] == '*')
				dfs(mx, my);
		}
	}
}
