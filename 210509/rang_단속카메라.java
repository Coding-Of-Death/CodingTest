import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int camera = Integer.MIN_VALUE;
        
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        for (int[] r : routes) {
            if (r[0] > camera) {
                camera = r[1];
                answer++;
            }
        }
        
        
        return answer;
    }
}
