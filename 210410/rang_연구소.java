/*
1. 가능한 위치에 벽 3개를 배치. **(DFS)**
2. 바이러스가 퍼져나갈 수 있는 위치에 바이러스를 표시. **(BFS)**
3. 안정 영역의 갯수를 찾기.
*/

import java.util.*;

class Point {
	int x;
	int y;
	
	Point(int y, int x) {
		this.x = x;
		this.y = y;
	}
}


public class Main {
	final static int MAX_WALL_COUNT = 3;
	final static int BLANK	= 0;
	final static int WALL	= 1;
	final static int VIRUS	= 2;
	
	final static int ALL_DIRECTIONS = 4;
	final static int[] DX = {0, -1, 0, 1};
	final static int[] DY = {-1, 0, 1, 0};
	
	static int[][] map;
	static int n;
	static int m;
	static int max = Integer.MIN_VALUE;
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		m = scan.nextInt();
		
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		
		makeWall(0);
		
		System.out.println(max);
	}
	
	static void makeWall(int count) {
		if (count == MAX_WALL_COUNT) {
			spreadVirus();
			return;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == BLANK) {
					map[i][j] = WALL;
					makeWall(count+1);
					map[i][j] = BLANK;
				}
			}
		}
	}
	
	static void spreadVirus() {
		int[][] virusMap = new int[n][m];
		initMap(virusMap);
		
		Queue<Point> queue = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (virusMap[i][j] == VIRUS)
					queue.add(new Point(i, j));
			}
		}
		
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			
			for (int i = 0; i < ALL_DIRECTIONS; i++) {
				int nextX = p.x + DX[i];
				int nextY = p.y + DY[i];
				
				if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n) {
					if (virusMap[nextY][nextX] == BLANK) {
						virusMap[nextY][nextX] = VIRUS;
						queue.add(new Point(nextY, nextX));
					}
				}
			}			
		}
		
		countMaxSafe(virusMap);
	}
	
	static void countMaxSafe(int[][] array) {
		int safeCount = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (array[i][j] == BLANK)
					safeCount++;
			}
		}
		
		max = Math.max(max, safeCount);
		
	}
	
	static void initMap(int[][] array) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				array[i][j] = map[i][j];
			}
		}
	}
}
