import java.util.*;
class Solution {
    private int answer = 0;
    public int solution(String s) {
        Stack<String> stack = new Stack<>();
        
        for(int i = 0 ; i < s.length(); i++){
            stack.clear();
            s = s.substring(1, s.length()) + s.charAt(0);
            
            for(int j = 0 ; j < s.length(); j++){
                String targetString = s.substring(j, j+1);
                
                if(stack.empty()){
                    stack.push(targetString);
                    continue;
                }
                
                if(")".equals(targetString)){
                    if("(".equals(stack.peek())) stack.pop();
                    continue;
                }else if("}".equals(targetString)){
                    if("{".equals(stack.peek())) stack.pop();
                    continue;
                }else if("]".equals(targetString)){
                    if("[".equals(stack.peek())) stack.pop();
                    continue;
                }
                stack.push(targetString);
            }
            if(stack.empty()){
                answer++;
            }
        }
        return answer;
    }
}
