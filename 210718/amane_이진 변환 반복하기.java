import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int len = 0;
        int time = 0;
        
        while(!s.equals("1")){
            int before = s.length();
            s = s.replaceAll("0", "");
            int after = s.length();
            
            s = Integer.toBinaryString(after);
            time++;
            len += before - after;
        }
        
        answer[0] = time;
        answer[1] = len;
        
        
        return answer;
    }
}
