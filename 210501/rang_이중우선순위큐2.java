import java.util.*;


class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String oper : operations) {
            String[] op = oper.split(" ");
            
            switch(op[0]) {
                case "I":
                    minQ.offer(Integer.parseInt(op[1]));
                    maxQ.offer(Integer.parseInt(op[1]));
                    break;
                case "D":
                    if (minQ.isEmpty()) break;
                    
                    if (Integer.parseInt(op[1]) == 1) {
                        int max = maxQ.poll();
                        minQ.remove(max);
                    } else {
                        int min = minQ.poll();
                        maxQ.remove(min);
                    }
                    break;
            }
        }
        
        if (!minQ.isEmpty()) {
            answer[0] = maxQ.peek();
            answer[1] = minQ.peek();
        }
        
        return answer;
    }
}
