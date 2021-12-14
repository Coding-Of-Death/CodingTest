import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        int[] arr = new int[n];
        int[] dp = new int[n];
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
        	A[i] = sc.nextInt();
        	B[i] = sc.nextInt();
        	map.put(A[i], B[i]);
        }
        
        arr[0] = 501;
        Arrays.sort(A);
        
        for(int i = 0; i < n; i++) {
        	arr[i] = (int)map.get(A[i]);
        }
        
        for(int i = 0; i < n; i++) {
        	dp[i] = 1;
        	for(int j = 0; j < i; j++) {
        		if(arr[i] > arr[j] && dp[i] < dp[j] + 1)
        			dp[i] = dp[j] + 1;
        	}
        	
        	answer = Math.max(answer, dp[i]);
        }
        
        System.out.println(n - answer);
    }
}
