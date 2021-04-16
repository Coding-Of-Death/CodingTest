import java.util.*;


public class Main {
	public static void main(String[] args) {
		String[] s;
		Scanner scan = new Scanner(System.in);
		
		int testCase = scan.nextInt();
		scan.nextLine();
		
		s = new String[testCase];
		
		for (int i = 0; i < testCase; i++) {
			s[i] = scan.nextLine();
		}
		
		String[] result = checkVPS(s);
		
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
	
	static String[] checkVPS(String[] str) {
		Stack<Integer> stack = new Stack<>();
		String[] result = new String[str.length];
		boolean flag;
		
		for (int i = 0; i < str.length; i++) {
			flag = true;
			
			for (int j = 0; j < str[i].length(); j++) {
				switch(str[i].charAt(j)) {
					case '(':
						stack.push(1);
						break;
					case ')':
						if (stack.empty()) {
							result[i] = "NO";
							flag = false;
						} else {
							stack.pop();
						}
						break;
				}
				
				if (!flag)	break;
			}
			
			if (flag && stack.empty()) {
				result[i] = "YES";
			} else {
				result[i] = "NO";
			}
			
			stack.clear();
		}
		
		return result;
	}
}
