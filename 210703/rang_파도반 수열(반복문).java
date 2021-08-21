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
			
			if (N >= 5)
				for (int j = 5; j <= N; j++)
					dp[j] = dp[j-1] + dp[j-5];
			
			System.out.println(dp[N]);
		}
	}

}
