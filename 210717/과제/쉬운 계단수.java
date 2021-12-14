import java.util.*;

public class Main{
    static Long dp[][];
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        dp = new Long[n + 1][10];
        
        for(int i = 0; i < 10; i++){
            dp[1][i] = 1L;
        }
        
        long res = 0;
        
        for(int i = 1; i <= 9; i++){
            res += recur(n, i);
            
        }
        
        res = res % 1000000000;
        System.out.println(res);
    }
    
    static long recur(int digit, int val){
        if(digit == 1){
            return dp[digit][val];
        }
        
        if(dp[digit][val] == null){
            if(val == 0){
                dp[digit][val] = recur(digit - 1, 1);
            }
            
            else if(val == 9){
                dp[digit][val] = recur(digit - 1, 8);
            }
            
            else{
                dp[digit][val] = recur(digit - 1, val - 1)
                    + recur(digit - 1, val + 1);
            }
            
        }
        
        return dp[digit][val] % 1000000000;
    }
}
