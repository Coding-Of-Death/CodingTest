import java.util.*;


class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int w : works) {
           pq.add(w);
        }
        
        for (int i = 0; i < n; i++) {
            int work = pq.remove();
            if (work == 0)  break;
            pq.add(work-1);
        }
        
        long answer = 0;
        while (!pq.isEmpty()) {
            int work = pq.remove();
            answer += work * work;
        }
        
        return answer;
    }
}
