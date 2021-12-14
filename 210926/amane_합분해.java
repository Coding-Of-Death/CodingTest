import java.util.*;

class Main {
	// 정수 n을 k개로 만들기
	// -> dp[k][n]
	static long[][] dp = new long[201][201];
	
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int k = sc.nextInt();
    	
    	// 정수 1개로 N을 만드는 경우 -> 1가지
    	for(int i = 1; i < 201; i++) {
    		dp[i][0] = 1;
    		dp[1][i] = 1;
    	}
    	
    	// 정수 2개로 N을 만드는 경우 -> N + 1가지
    	for(int i = 1; i < 201; i++) {
    		dp[2][i] = i + 1;
    	}
    	
    	// 정수 3개 이상으로 N을 만드는 경우
    	// 	-> ex) 정수 3개로 1 만들기
    	//         0과 2개의 정수(1 만들기) // 1과 2개의 정수(0 만들기)
    	//        -> dp[3][1] = dp[2][0] + dp[2][1]
    	for(int i = 3; i < 201; i++) {
    		for(int j = 1; j < 201; j++) {
    			for(int l = 0; l <= j; l++) {
    				dp[i][j] += dp[i - 1][j - l] % 1_000_000_000;
    			}
    		}
    	}
    	
    	System.out.println(dp[k][n] % 1_000_000_000);
    }
    
    
}
