import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> work = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : works){
            work.add(i);
        }
        
        for(int i = 0; i < n; i++){
            int max = work.poll();
            if(max <= 0) break;
            work.add(max - 1);
        }
        
        while(!work.isEmpty()){
            int tmp = work.poll();
            answer += tmp * tmp;
        }
        
        return answer;
    }
}
