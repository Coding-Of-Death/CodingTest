import java.util.*;

class Solution {
    static int idx = 0;
    
    public String solution(String p) {
        String answer = "";
        
        boolean flag = checkString(p);
        
        if(flag)
            answer = p;
        
        else{
            answer = makeString(p);
        }
        return answer;
    }
    
    static boolean checkString(String s){
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                stack.push('(');
            else {
            	if(stack.size() != 0) {
            		stack.pop();
            	
            	}
                // stack이 크기가 0인데 )가 들어오면 안 맞는 것이므로 false 반환
                else {
            		return false;
            	}
            }
        }
        
        // 다 돌고도 size가 0이 아니면 false 반환
        if(stack.size() != 0)
        	return false;
        
        // size가 0이면 짝이 맞으므로 true 반환
        else
        	return true;
        
    }
    
    static void checkIdx(String s){
        int pair = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                pair++;
            else pair--;
            
            // pair가 0이면 균형잡힘
            if(pair == 0){
                idx = i + 1;
                break;
            }
        }
    }
    
    static String makeString(String s){
        checkIdx(s);
        
        String answer = "";
        String u = s.substring(0, idx);
        String v = s.substring(idx);
    
        // true면 올바른 괄호
        if(checkString(u))
            answer += u;
        
        // 올바른 괄호가 아니다
        else{
            // 4-1
            answer += "(";
            
            // 4-2
            if(!v.equals("")){
                System.out.println("uU: " + u);
                System.out.println("uV: " + v);
                // 재귀하자
                answer += makeString(v);
                v = "";
            }
            
            // 4-3
            answer += ")";
            
            // 4-4
            for(int i = 1; i < u.length() - 1; i++){
                if(u.charAt(i) == '(')
                    answer += ")";
                else
                    answer += "(";
            }
            
            //System.out.println(answer);
        }
        
        // 남은 거 다시 재귀하자
        if(!v.equals("")){
            System.out.println("V: " + v);
            answer += makeString(v);
        }
        
        return answer;
    }
}
