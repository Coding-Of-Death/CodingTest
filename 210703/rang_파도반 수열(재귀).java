import java.util.Scanner;

public class Main {
	static long[] dp = new long[101];

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 초기값 설정
		dp[1] = 1;	dp[2] = 1;	dp[3] = 1;	dp[4] = 2;
		
		int T = scan.nextInt();
		for (int i = 0; i < T; i++) {
			int N = scan.nextInt();
			System.out.println(recur(N));
		}
	}
	
	public static long recur(int n) {
		if (n < 0)	return 0;
		
		if (dp[n] == 0) {
			dp[n] = recur(n-1) + recur(n-5);
		}
		return dp[n];
	}

}
