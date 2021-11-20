import java.util.*;


class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {-1};
        
        int num = s / n;
        if (num != 0) {
            int[] result = new int[n];
            int ran = s % n;
            
            for (int i = n-1; i >= 0; i--) {
                if (ran > 0) {
                    result[i] = num+1;
                    ran--;
                } else {
                    result[i] = num;
                }
            }
            answer = result;
        }
        
        return answer;
    }
}
