import java.util.*;

class Solution {
    static int answer = 9;
    static int num;
    
    public int solution(int N, int number) {
        num = N;
        dfs(0, 0, number);
        
        if(answer > 8) return -1;
        
        return answer;
    }
    
    static void dfs(int cnt, int number, int target){
        if(cnt > 8)
            return;
        
        if(number == target){
            answer = Math.min(answer, cnt);
            return;
        }
        
        for(int i = 1; i <= 8-cnt; i++){
            String tmp = "";
            for(int j = 0; j < i; j++){
                tmp += Integer.toString(num);
            }
            
            int temp = Integer.parseInt(tmp);
            
            dfs(cnt+i, number + temp, target);
            dfs(cnt+i, number - temp, target);
            dfs(cnt+i, number * temp, target);
            dfs(cnt+i, number / temp, target);
            
        }
    }
}