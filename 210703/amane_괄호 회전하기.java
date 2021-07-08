import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++){
            Stack<String> stack = new Stack();
            s = s.substring(1, s.length()) + s.substring(0, 1);
            //System.out.println(s);
            
            for(int j = 0; j < s.length(); j++){
                String ch = s.substring(j, j+1);
                if(stack.isEmpty()){
                    stack.push(ch);
                    continue;
                }
                
                if(ch.equals(")") && stack.peek().equals("(")){
                    stack.pop();
                    
                } else if(ch.equals("}") && stack.peek().equals("{")){
                    stack.pop();
                    
                } else if(ch.equals("]") && stack.peek().equals("[")){
                    stack.pop();
                } else{
                    stack.push(ch);
                }
            
            }
            
            if(stack.isEmpty()){
                answer++;
                
            }
        }
        return answer;
    }
}
