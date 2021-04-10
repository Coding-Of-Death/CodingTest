import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer  = 0;
        int upHcita;
        
        Arrays.sort(citations);
        
        if (citations[citations.length - 1] == 0)
            return 0;
        
        for (int h = citations[citations.length - 1]; h > 0; h--) {
            upHcita = 0;
            
            for (int i = 0; i < citations.length; i++) {
                if (h <= citations[i]) {
                    upHcita++;
                }
            }
            
            if (upHcita >= h && citations.length - upHcita <= h) {
                answer = h;
                break;
            }
            
        }
        
        return answer;
    }
}
