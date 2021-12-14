import java.util.*;

class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        long gcd_num = 0;
        
        if(w >= h)  gcd_num = gcd((long) w, (long) h);
        else        gcd_num = gcd((long) h, (long) w);
        
        answer = ((long) w * (long) h) - (((long) w / gcd_num) + ((long) h / gcd_num) - 1) * gcd_num;
        
        return answer;
    }
    
    static long gcd(long w, long h){
        if(w % h == 0){
            return h;
        }
        
        return gcd(h, w % h);
    }
}
