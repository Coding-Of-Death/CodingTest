import java.util.*;


class Solution {
    public int solution(String dartResult) {
        Stack<Integer> stack = new Stack<>();
        
        StringTokenizer stk = new StringTokenizer(dartResult,"SDT*#",true);
        
        while(stk.hasMoreTokens()) {
            String s = stk.nextToken();
            
            switch(s) {
                case "S":
                    stack.add((int) Math.pow(stack.pop(),1));
                    break;
                case "D":
                    stack.add((int) Math.pow(stack.pop(),2));
                    break;
                case "T":
                    stack.add((int) Math.pow(stack.pop(),3));
                    break;
                case "*":
                    int num = stack.pop();
                    
                    if (!stack.isEmpty()) {
                        stack.add(stack.pop()*2);
                    }
                    stack.add(num*2);
                    break;
                case "#":
                    stack.add(stack.pop()*(-1));
                    break;
                default:
                    stack.add(Integer.parseInt(s));
                    break;
            }
        }
        
        //System.out.println(stack);
        
        while (stack.size() > 1) {
            int n2 = stack.pop();
            int n1 = stack.pop();
            stack.add(n1 + n2);
        }
        
        return stack.pop();
    }
}
