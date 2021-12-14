import java.util.*;

class Main {
	/*
	 * op(char c)
	 * 	- 연산자의 우선순위를 반환함
	 * 	- ( * , / ) > ( + , - ) > ( ( , ) )
	 * */
	
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	char[] arr = sc.nextLine().toCharArray();
    	
    	Stack<Character> st = new Stack<>();
    	StringBuilder sb = new StringBuilder();
    	
    	for(char c : arr) {
    		if(c >= 'A' && c <= 'Z')
    			sb.append(c);
    		else {
    			if(c == '(')
    				st.push(c);
    			
    			else if (c == ')') {
    				while(!st.isEmpty() && st.peek() != '(')
    					sb.append(st.pop());
    				// '(' 연산자 꺼내기
    				if(!st.isEmpty())
    					st.pop();
    			}
    			
    			// 괄호를 제외한 연산자의 경우, 우선순위를 비교하여 표기
    			// 괄호는 여기서 스택에서 뺴면 안 됨
    			else {
    				while(!st.isEmpty() && op(st.peek()) >= op(c))
    					sb.append(st.pop());
    				
    				st.push(c);
    					
    			}
    		}
    	}
    	
    	// 스택에 남은 연산자 빼내기
    	while(!st.isEmpty())
    		sb.append(st.pop());
    	
    	System.out.println(sb);
    	
    }
    
    static int op(char c) {
    	if(c == '*' || c == '/') return 2;
    	else if (c == '+' || c == '-') return 1;
    	else return 0;
    }
    
    
}
