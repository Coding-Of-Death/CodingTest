import java.util.*;

public class Main {
	final static int MAX_LENGTH = 100;
	
	public static void main(String[] args) {
		/*
		  stack () [] 짝을 이루어야
		  
		  (,[ 만나면
		  	stack에 넣기
		  	
		  ), ] 만나면 
		  	1. stack이 비어있는지 확인
		  	2. peek으로 각각 (, [ 맞는지 확인
		   stack이 비어있지 않으면 no출력
		*/
		
		Scanner scan = new Scanner(System.in);
		
		// 각 문자열의 길이는 100글자보다 작거나 같다.(내가 설정할 필요 없다.)
		// 입력의 종료조건으로 맨 마지막에 점 하나가 들어온다.
		String input = "";
		
		while (true) {
			input = scan.nextLine();
			
			if (input.equals(".")) {
				break;
			}
			
			isCheckedBalance(input);	
		}
	}
	
	private static void isCheckedBalance(String input) {
		Stack<String> stack = new Stack<>();
			
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			
			if (c == '[') {
				stack.push("[");
				
			} else if (c == '(') {
				stack.push("(");
				
			} else if (c == ']') {
				if (!stack.empty() && stack.peek().equals("[")) {
					stack.pop();
					
				} else {
					System.out.println("no");
					return;
					
				}
			} else if (c == ')') {
				if (!stack.empty() && stack.peek().equals("(")) {
					stack.pop();
					
				} else {
					System.out.println("no");
					return;
					
				}
			}
		}
		
		if (stack.empty()) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}
}
