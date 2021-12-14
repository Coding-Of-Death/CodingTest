import java.util.*;

public class Main{
	static char[][] map = new char[12][6];
	static boolean[][] check;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int cnt = 0;
	
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 12; i++) {
			String tmp = sc.next();
			for(int j = 0; j < 6; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		
		int result = 0;
		
		while(true) {
			check = new boolean[12][6];
			boolean flag = false;
			
			for(int i = 0; i < 12; i++) {
				for(int j = 0; j < 6; j++) {
					if(!check[i][j] && map[i][j] != '.') {
						cnt = 1;
						
						if(countCnt(i, j, map[i][j])) {
							flag = true;
							bfs(i, j, map[i][j]);
						}
					}
				}
			}
			
			if(flag)
				result++;
			else
				break;
			
			while(true) {
				boolean down = false;
				down = gravity(down);
				
				if(!down)
					break;
			}
		}
		System.out.println(result);
	}
	
	static void bfs(int i, int j, char c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(i, j));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			int x = p.x;
			int y = p.y;
			
			for(int d = 0; d < 4; d++) {
				int mx = x + dx[d];
				int my = y + dy[d];
				
				if(mx < 0 || my < 0 || mx >= 12 || my >= 6 || map[mx][my] != c) {
					continue;
				}
				
				if(check[mx][my] && map[mx][my] == c) {
					map[mx][my] = '.';
					q.add(new Point(mx, my));
				}
			}
		}
	}

	static boolean countCnt(int i, int j, char c) {
		check[i][j] = true;
		
		for(int d = 0; d < 4; d++) {
			int mx = i + dx[d];
			int my = j + dy[d];
			
			if(mx < 0 || my < 0 || mx >= 12 || my >= 6 || map[mx][my] != c) {
				continue;
			}
			
			if(!check[mx][my] && map[mx][my] == c) {
				cnt++;
				countCnt(mx, my, c);
			}
		}
		
		if(cnt >= 4)
			return true;
		
		return false;
	}

	static boolean gravity(boolean down) {
		for(int i = 11; i > 0; i--) {
			for(int j = 5; j >= 0; j--) {
				if(map[i][j] == '.' && map[i - 1][j] != '.') {
					down = true;
					map[i][j] = map[i - 1][j];
					map[i - 1][j] = '.';
				}
			}
		}
		return down;
	}
}
