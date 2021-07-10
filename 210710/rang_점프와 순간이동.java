public class Solution {
    /* 방법 1
    public int solution(int n) {
        return Integer.bitCount(n);
    }
    */
  
    //방법 2
    public int solution(int n) {
        int k = 1;
        
        //while (n --> 0) : n--, n > 0
        while (n > 1) {
            k += n%2;
            n /= 2;
        }
        return k;
    }
}
