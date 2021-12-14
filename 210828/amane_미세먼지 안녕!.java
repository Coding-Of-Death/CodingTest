import java.util.*;

public class Main{
	static int[][] map;
	static int r, c, t;
	static ArrayList<Integer> air = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		r = sc.nextInt();
		c = sc.nextInt();
		t = sc.nextInt();
		
		map = new int[r][c];
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == -1) {
					air.add(i);
				}
			}
		}
		
		while(t --> 0) {
			map = spread();
			airCondition();
		}
        
        int sum = 0;
			
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(map[i][j] != -1)
                    sum += map[i][j];
			}	
		}
        
        System.out.println(sum);
		
	}

	static void airCondition() {
		int top = air.get(0);
		
		for(int i = top - 1; i > 0; i--)
			map[i][0] = map[i - 1][0];
		
		for(int j = 0; j < c - 1; j++)
			map[0][j] = map[0][j + 1];
		
		for(int i = 0; i < top; i++)
			map[i][c - 1] = map[i + 1][c - 1];
		
		for(int j = c - 1; j > 1; j--)
			map[top][j] = map[top][j - 1];
		
		map[top][1] = 0;
		
		int bottom = air.get(1);
		
		for(int i = bottom + 1; i < r - 1; i++)
			map[i][0] = map[i + 1][0];
		
		for(int j = 0; j < c - 1; j++)
			map[r - 1][j] = map[r - 1][j + 1];
		
		for(int i = r - 1; i > bottom; i--)
			map[i][c - 1] = map[i - 1][c - 1];
		
		for(int j = c - 1; j > 1; j--)
			map[bottom][j] = map[bottom][j - 1];
		
		map[bottom][1] = 0;
	}

	private static int[][] spread() {
		int[][] tmp = new int[r][c];
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(map[i][j] == -1) {
					tmp[i][j] = -1;
					continue;
				}
				
				tmp[i][j] += map[i][j];
				
				for(int d = 0; d < 4; d++) {
					int mx = i + dx[d];
					int my = j + dy[d];
					
					if(mx < 0 || my < 0 || mx >= r || my >= c)
						continue;
					if(map[mx][my] == -1)
						continue;
					
					tmp[mx][my] += (map[i][j] / 5);
					tmp[i][j] -= (map[i][j] / 5);
				}
			}
		}
		return tmp;
	}
}
