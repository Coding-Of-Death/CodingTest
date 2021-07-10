import java.util.*;


class Solution {
    public int solution(String s) {
        Queue<Character> que = new LinkedList<>();
        int answer = 0;
        
        for (char c : s.toCharArray()) {
            que.offer(c);
        }
        
        for (int i = 0; i < s.length(); i++) {
            answer += isPaired(que);
            que.offer(que.poll());
        }
        
        return answer;
    }
    
    int isPaired(Queue<Character> q) {
        Stack<Character> stack = new Stack<>();
        Character[] temp = new Character[q.size()];
        temp = q.toArray(temp);
        
        for(int i = 0; i < temp.length; i++) {
            if (stack.isEmpty() || temp[i] == '(' || temp[i] == '[' || temp[i] == '{')
                stack.push(temp[i]);
            else if ((temp[i] == ')' && stack.peek() == '(') 
                     || (temp[i] == ']' && stack.peek() == '[')
                     || (temp[i] == '}' && stack.peek() == '{'))
                stack.pop();
            else 
                break;
        }
        
        if (!stack.isEmpty()) {
            return 0;
        }
        
        return 1;
    }
}
