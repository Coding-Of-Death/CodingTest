import java.util.*;


class Solution {    
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        LinkedList<Integer> queue = new LinkedList<>();
        
        for (String oper : operations) {
            String[] op = oper.split(" ");
            
            switch(op[0]) {
                case "I":
                    queue.offer(Integer.parseInt(op[1]));
                    Collections.sort(queue);
                    break;
                case "D":
                    if (queue.isEmpty()) break;
                    
                    if (Integer.parseInt(op[1]) == 1) {
                        queue.pollLast();
                    } else {
                        queue.pollFirst();
                    }
                    break;
            }
        }
        
        if (!queue.isEmpty()) {
            answer[0] = queue.peekLast();
            answer[1] = queue.peekFirst();
        }
        
        return answer;
    }

}
