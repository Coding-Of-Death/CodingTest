import java.util.*;

class Main {
	static int n, l, r;
	static int[][] map;
	static boolean[][] check;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	
	public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		l = sc.nextInt();
		r = sc.nextInt();
		
		map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int cnt = count();
    	
		System.out.println(cnt);
	}
	
	static int count() {
		int cnt = 0;
		boolean flag = false;
		
		while(true) {
			check = new boolean[n][n];
			flag = false;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(check[i][j])
						continue;
					if(open(i, j))
						flag = true;
				}
			}
			
			if(flag)
				cnt++;
			else
				return cnt;
		}
	}
	
	static boolean open(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		Queue<Point> list = new LinkedList<>();
		
		q.add(new Point(x, y));
		list.add(new Point(x, y));
		check[x][y] = true;
		
		int sum = map[x][y];
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int mx = now.x + dx[i];
				int my = now.y + dy[i];
				
				if(mx < 0 || my < 0 || mx >= n || my >= n || check[mx][my])
					continue;
				
				int diff = Math.abs(map[now.x][now.y] - map[mx][my]);
				
				if(diff < l || diff > r)
					continue;
				
				sum += map[mx][my];
				q.add(new Point(mx, my));
				list.add(new Point(mx, my));
				
				check[mx][my] = true;
			}
		}
		
		if(list.size() == 1) {
			return false;
		} else {
			int tmp = sum / list.size();
			for(Point p : list) {
				map[p.x][p.y] = tmp;
			}
		}
		return true;
	}
	
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
