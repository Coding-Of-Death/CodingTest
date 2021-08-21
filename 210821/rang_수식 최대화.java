import java.util.*;


class Solution {
    public long solution(String expression) {
        String[][] pri = {{"+", "-", "*"}, 
                          {"+", "*", "-"}, 
                          {"-", "+", "*"}, 
                          {"-", "*", "+"}, 
                          {"*", "+", "-"}, 
                          {"*", "-", "+"}};
        long answer = 0;
        Deque<String> deq = new LinkedList<>();
        
        for (int i = 0; i < pri.length; i++) {
            StringTokenizer token = new StringTokenizer(expression, "+-*", true);
            while(token.hasMoreTokens()) {
                deq.addLast(token.nextToken());
            }
            for (int j = 0; j < 3; j++) {
            	int len = deq.size();
            	for (int k = 0; k < len; k++) {
            		String now = deq.pollFirst();
                    
                    if (now.equals(pri[i][j])) {
                        deq.addLast(calc(deq.pollLast(), deq.pollFirst(), now));
                        k++;
                    } else {
                        deq.addLast(now);
                    }
            	}
            }
            
            System.out.println(deq.peek() + ", " + deq.size());
            
            long result = Long.parseLong(deq.poll());
            answer = Math.max(answer, Math.abs(result));
        }
        
        return answer;
    }
    
    String calc(String n1, String n2, String cal) {
        long result = 0;
        long num1 = Long.parseLong(n1);
        long num2 = Long.parseLong(n2);
        
        if (cal.equals("+"))
            result = num1 + num2;
        else if (cal.equals("-"))
            result = num1 - num2;
        else
            result = num1 * num2;
        
        return String.valueOf(result);
    }
}
