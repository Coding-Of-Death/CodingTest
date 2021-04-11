import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> scovQ = new PriorityQueue<>();
        int answer = 0;
        
        for (int s : scoville)
            scovQ.add(s);
        
        while (scovQ.size() != 1 && scovQ.peek() < K) {
            int mixScov = scovQ.poll() + (scovQ.poll() * 2);
            scovQ.add(mixScov);
            answer++;
        }
        
        if (scovQ.peek() < K) {
            answer = -1;
        }
        
        return answer;
    }
}
