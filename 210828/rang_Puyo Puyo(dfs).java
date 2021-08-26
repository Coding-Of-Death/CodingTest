import java.util.*;


public class Main {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	static char[][] field = new char[12][6];
	static boolean[][] visited = new boolean[12][6];
	static boolean[][] preVisited = new boolean[12][6];
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < field.length; i++) {
			field[i] = scan.nextLine().toCharArray();
		}
		
		int boomCount = 0;
		
		// 더 이상 터질 뿌요가 없을 때까지 loop
		while (true) {
			// 뿌요 터질 지 체크
			boolean boomCheck = false;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (dfs(i, j, field[i][j]) >= 4) {
						boomCheck = true;
						copy(preVisited, visited);
					} else {
						copy(visited, preVisited);
					}
				}
			}
			
			if (boomCheck) {
				// 뿌요를 새로 정렬
				boomCount++;
				sort();
			} else {				
				break;
			}
		}
		
		System.out.println(boomCount);
	}
	
	static int dfs(int x, int y, char color) {
		if (visited[x][y] || color == '.')
			return 0;
		
		visited[x][y] = true;
		int count = 1;
		
		for (int i = 0; i < dx.length; i++) {
			int nX = x + dx[i];
			int nY = y + dy[i];
			if (check(nX, nY, color)) {
				count += dfs(nX, nY, color);
			}
		}
		
		return count;
	}
	
	static boolean check(int x, int y, char color) {
		if (x < 0 || x >= 12)		return false;
		if (y < 0 || y >= 6)		return false;
		if (visited[x][y])			return false;
		if (field[x][y] != color)	return false;
		return true;
	}
	
	static void sort() {
		char[][] sorted = new char[12][6];
		
		for (int i = 0; i < 6; i++) {
			int index = 12;
			for (int j = 11; j >= 0; j--) {
				if (!visited[j][i] && field[j][i] != '.')
					sorted[--index][i] = field[j][i];
				visited[j][i] = false;
				preVisited[j][i] = false;
			}
			while (index > 0)
				sorted[--index][i] = '.';
		}
		
		field = sorted;
	}
	
	static void copy(boolean[][] copyed, boolean[][] resource) {
		for (int i = 0; i < copyed.length; i++) {
			for (int j = 0; j < copyed[i].length; j++) {
				copyed[i][j] = resource[i][j];
			}
		}
	}
}
