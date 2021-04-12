import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;
        
        PriorityQueue<Integer> list = new PriorityQueue<>();
        for (int j = 0; j < scoville.length; j++){
            list.offer(scoville[j]);
        }
        
        int tmp = 0;
        
        while(list.peek() < K){
            if(list.size() < 2){
                return -1;
            }
            
            int num1 = list.poll();
            int num2 = list.poll();
            tmp = num1 + num2 * 2;
            
            list.offer(tmp);
            count++;
            
        }
        
        return count;
    }
}