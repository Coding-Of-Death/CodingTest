import java.util.*;

public class Main{
    static int[] arr;
    static Integer[] r_dp, l_dp;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        arr = new int[n];
        r_dp = new Integer[n];
        l_dp = new Integer[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        
        for(int i = 0; i < n; i++){
            LIS(i);
            LDS(i);
        }
        
        int max = -1;
        
        for(int i = 0; i < n; i++){
            max = Math.max(r_dp[i] + l_dp[i], max);
        }
        
        System.out.println(max - 1);
        
        
    }
    
    static int LIS(int n){
        if(r_dp[n] == null){
            r_dp[n] = 1;
            
            for(int i = n - 1; i >= 0; i--){
                if(arr[i] < arr[n]){
                    r_dp[n] = Math.max(r_dp[n], LIS(i) + 1);
                }
            }
        }
        
        return r_dp[n];
    }
    
    static int LDS(int n){
        if(l_dp[n] == null){
            l_dp[n] = 1;
            
            for(int i = n + 1; i < l_dp.length; i++){
                if(arr[i] < arr[n])
                    l_dp[n] = Math.max(l_dp[n], LDS(i) + 1);
            }
        }
        
        return l_dp[n];
    }
    
}
