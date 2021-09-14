import java.util.*;


public class Main {
	static int N, K;
	static int[] val;
	static int[][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		val = new int[N];
		for (int i = 0; i < N; i++) {
			val[i] = sc.nextInt();
		}
		
		dp = new int[K+1][N+1];
		for (int i = 0; i <= N; i++)
			dp[0][i] = 1;
		
		for (int i = 1; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				if (val[j-1] > i) {
					dp[i][j] = dp[i][j-1];
				} else {
					dp[i][j] = dp[i-val[j-1]][j] + dp[i][j-1];
				}
			}
		}
		
		System.out.println(dp[K][N]);
	}
}
