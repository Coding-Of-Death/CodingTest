import java.util.*;


class Point {
	int x, y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}


public class Main {
	static int minCount = 10001;
	static int m, n;
	static int[][] dist;
	static char[][] map;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		m = scan.nextInt();
		
		map = new char[n][m];
		dist = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String s = scan.nextLine();
			map[i] = scan.next().toCharArray();
		}
		
		bfs(0, 0);
		System.out.println(dist[n-1][m-1]);
	}
	
	static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		
		dist[x][y] = 1;
		queue.add(new Point(x, y));
		
		while (!queue.isEmpty()) {
			Point loc = queue.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int nextX = loc.x + dx[i];
				int nextY = loc.y + dy[i];
				
				if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
					if (map[nextX][nextY] == '1' && dist[nextX][nextY] == 0) {
						dist[nextX][nextY] = dist[loc.x][loc.y] + 1;
						queue.add(new Point(nextX, nextY));
					}
				}
			}
		}
	}
}
