import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = (long) times[times.length-1] * n;
        
        Arrays.sort(times);
        long min_time = 1;
        long max_time = (long) times[times.length-1] * n;   // times[times.length-1] * n은 int형 범위를 벗어나므로 형변환 필수!
        long mid_time;
        long sum_people;
        
        while (min_time <= max_time) {
            mid_time = (long)(min_time + max_time) / 2;
            
            sum_people = 0;
            for (int t : times) {
                sum_people += (long)(mid_time / t);
            }
            
            if (sum_people >= n) {
                answer = Math.min(answer, mid_time);
                if (answer > mid_time) {
                    answer = mid_time;
                }
                max_time = mid_time - 1;
            
            } else if (sum_people < n) {
                min_time = mid_time + 1;
            }
        }
        
        return answer;
    }
}
