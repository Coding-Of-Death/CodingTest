import java.util.*;

class Solution {
    static boolean[] check;
    static int cnt = 0;
    
    public int solution(int[] nums) {
        int answer = -1;
        
        check = new boolean[nums.length];
        
        dfs(0, 0, nums);
        
        answer = cnt;

        return answer;
    }
    
    static void dfs(int start, int depth, int[] nums){
        if(depth == 3){
            int tmp = 0;
            
            for(int i = 0; i < check.length; i++){
                if(check[i]){
                    tmp += nums[i];
                    System.out.print(nums[i] + " ");
                }
            }
            System.out.println();
            
            if(isPrime(tmp)){
                //System.out.println(tmp);
                cnt++;
            }
            return;
        }
        
        for(int i = start; i < check.length; i++){
            if(!check[i]){
                check[i] = true;
                dfs(i, depth + 1, nums);
                check[i] = false;
            }
        }
    }
    
    static boolean isPrime(int num){
        if(num < 2) return false;
        if(num < 4) return true;
        if(num % 2 == 0 || num % 3 == 0)    return false;
        for(int i = 5; i*i <= num; i+= 6){
            if(num % i == 0 || num % (i + 2) == 0)  return false;
        }
        return true;
    }
}
