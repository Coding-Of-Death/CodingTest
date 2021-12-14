import java.util.*;

class Main {
	
	public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	
    	int[] t = new int[n];
    	int[] p = new int[n];
    	int[] dp = new int[n + 1];
    	
    	for(int i = 0; i < n; i++) {
    		t[i] = sc.nextInt();
    		p[i] = sc.nextInt();
    	}
    	
    	for(int i = 0; i < n; i++) {
    		if(i + t[i] <= n)
    			dp[t[i] + i] = Math.max(dp[t[i] + i], p[i] + dp[i]);
    		
    		dp[i + 1] = Math.max(dp[i], dp[i + 1]);
    	}
    	
    	System.out.println(dp[n]);
	}
    
    
}
