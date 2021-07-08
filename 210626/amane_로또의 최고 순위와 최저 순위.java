import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cnt = 0;
        int zero = 0;
        
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0){
                zero++;
                continue;
            }
            
            for(int j = 0; j < win_nums.length; j++){
                if(lottos[i] == win_nums[j])
                    cnt++;
            }
        }
        cnt += zero;
        
        for(int i = 0; i < 2; i++){
            if(cnt == 6)
                answer[i] = 1;
            
            else if (cnt == 5)
                answer[i] = 2;
            
            else if (cnt == 4)
                answer[i] = 3;
            
            else if (cnt == 3)
                answer[i] = 4;
            
            else if (cnt == 2)
                answer[i] = 5;
            else 
                answer[i] = 6;
            cnt -= zero;
        }
        
        return answer;
    }
}
