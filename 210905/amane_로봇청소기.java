import java.util.*;

public class Main{
	static int[][] map;
	static int cnt = 0;
	static int n, m, Loc_x, Loc_y, Loc_dir;
	static int rotateCnt = 0;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		
		Loc_x = sc.nextInt();
		Loc_y = sc.nextInt();
		Loc_dir = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(cleanCnt());
	}

	static int cleanCnt() {
		while(true) {
			if(rotateCnt == 4) {
				int pre_x = Loc_x - dx[Loc_dir];
				int pre_y = Loc_y - dy[Loc_dir];
				
				if(map[pre_x][pre_y] == 1) {
                    cnt = 0;
					for(int i = 0; i < n; i++) {
						for(int j = 0; j < m; j++) {
							if(map[i][j] == 2)
								cnt++;
						}
					}
					return cnt;
					
				} else {
					Loc_x = pre_x;
					Loc_y = pre_y;
					rotateCnt = 0;
				}
			}
			
			if(map[Loc_x][Loc_y] == 0)
				map[Loc_x][Loc_y] = 2;
			
			int dir = (Loc_dir + 3) % 4;
			int mx = Loc_x + dx[dir];
			int my = Loc_y + dy[dir];
			
			if(map[mx][my] == 0) {
				Loc_x = mx;
				Loc_y = my;
				Loc_dir = dir;
				rotateCnt = 0;
			}
			else {
				Loc_dir = dir;
				rotateCnt += 1;

			}
		}
	}
	
	
}
