import java.util.Scanner;

public class Main {
	static final int UP		= 0;
	static final int DOWN	= 1;
	static final int RIGHT	= 2;
	static final int LEFT	= 3;
	
	static int N;
	static int[][] arr;
	static int max;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		arr = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				arr[i][j] = sc.nextInt();
		
		max = 0;
		dfs(0);
		
		System.out.println(max);
		
		sc.close();
	}
	
	static void dfs(int count) {
		if (count == 5) {
			max = Math.max(max, maxInArr());
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int[][] temp = copy(arr);
			move(i);			
			dfs(count+1);
			arr = copy(temp);
		}
	}
	
	static int maxInArr() {
		int result = 0;
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (result < arr[i][j])
					result = arr[i][j];
		return result;
	}
	
	static int[][] copy(int[][] res) {
		int[][] des = new int[N][];
		
		for (int i = 0; i < N; i++) {
			des[i] = res[i].clone();
		}
		return des;
	}
	
	static void move(int dir) {
		if (dir == UP) {
			// 전치행렬
			trans();
		} else if (dir == DOWN) {
			// 전치행렬
			trans();
			// 좌우반전
			reverse();
		} else if (dir == RIGHT) {
			// 좌우반전
			reverse();
		}
		
		// 움직임...
		for (int i = 0; i < N; i++) {
			int flag = -1;
			for (int j = 0; j < N; j++) {
				if (arr[i][j] > 0 && flag == -1) {
					flag = j;
				} else if (arr[i][j] > 0 && flag >= 0) {
					if (arr[i][flag] == arr[i][j]) {
						arr[i][flag] *= 2;
						arr[i][j] = 0;
						flag = -1;
					} else
						flag = j;
				}
			}
			int[] temp = new int[N];
			int idx = 0;
			for (int j = 0; j < N; j++) {
				if (arr[i][j] > 0)
					temp[idx++] = arr[i][j];
			}
			arr[i] = temp.clone();
		}
		
		if (dir == UP) {
			// 전치행렬
			trans();
		} else if (dir == DOWN) {
			// 좌우반전
			reverse();
			// 전치행렬
			trans();
		} else if (dir == RIGHT) {
			// 좌우반전
			reverse();
		}
	}
	
	static void trans() {
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
	}
	
	static void reverse() {
		for (int i = 0; i < N; i++) {
			for (int j = 0 ; j < N/2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][N-1-j];
				arr[i][N-1-j] = temp;
			}			
		}
	}
}
