import java.util.*;
import java.io.*;

class Main {
	static int n, l;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
    	
    	Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		l = sc.nextInt();
		map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int count = 0;
		for(int i = 0; i < n; i++) {
			if(pass(i, 0, 0))
				count++;
			
			if(pass(0, i, 1))
				count++;
		}
		
		System.out.println(count);
	}
	
	static boolean pass(int x, int y, int dir) {
		boolean[] check = new boolean[n];
		int[] height = new int[n];
		
		for(int i = 0; i < n; i++) {
			height[i] = (dir == 0) ? map[x][y + i] : map[x + i][y];
		}
		
		for(int i = 0; i < n - 1; i++) {
			// 높이가 같음
			if(height[i] == height[i + 1])
				continue;
			
			// 높이 차이가 1 이상
			if(Math.abs(height[i] - height[i + 1]) > 1)
				return false;
			
			// ↘방향으로 높이 1차이 
			if(height[i] - 1 == height[i + 1]) {
				for(int j = i + 1; j <= i + l; j++) {
					if(j >= n || check[j] || height[j] != height[i + 1])
						return false;
					
					check[j] = true;
				}
			}
			
			// ↗ 방향으로 높이 1차이
			else if(height[i] + 1 == height[i + 1]) {
				for(int j = i; j > i - l; j--) {
					if(j < 0 || check[j] || height[j] != height[i])
						return false;
					
					check[j] = true;
				}
			}
		}
		return true;
	}
}
