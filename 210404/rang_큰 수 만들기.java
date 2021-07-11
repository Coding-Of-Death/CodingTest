import java.util.*;


class Solution {
    public String solution(String number, int k) {
        StringBuffer answer = new StringBuffer();
        char[] num = number.toCharArray();
        
        int remain = num.length - k;
        int start = 1;
        int end;
        int max = 0;
        
        while (remain --> 0) {
            end = num.length - remain;
            
            for (int i = start; i < end; i++) {
                if (num[i] > num[max])
                    max = i;
            }
            
            answer.append(num[max]);
            start = max + 1;
            max = max + 1;
        }
        
        return answer.toString();
    }
}
