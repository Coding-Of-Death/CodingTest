import java.util.*;


class StackArray {
	static final int MAX = 10000;
	int[] array;
	int index;
	
	StackArray() {
		array = new int[MAX];
		index = 0;
	}
	
	void push(int num) {
		array[index++] = num;
	}
	
	int pop() {
		if (index > 0) {
			return array[--index];
		}
		
		return -1;
	}
	
	int size() {
		return index;
	}
	
	int empty() {
		if (index > 0) {
			return 0;
		}
		
		return 1;
	}
	
	int top() {
		if (index > 0) {
			int i = index - 1;
			return array[i];
		}
		
		return -1;
	}
}


public class Main {
	public static void main(String[] args) {
		String[] commands;
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		commands = new String[n];
		
		scan.nextLine();
		
		for (int i = 0; i < n; i++) {
			commands[i] = scan.nextLine();
		}
		
		startStack(commands);
	}
	
	static void startStack(String[] strs) {
		StackArray stackArray = new StackArray();
		
		int i =0;
		while (i < strs.length) {
			String[] arguments = strs[i].split(" ");
			
			if (arguments[0].equals("push")) {
				stackArray.push(Integer.parseInt(arguments[1]));
				
			} else if (arguments[0].equals("pop")) {
				System.out.println(stackArray.pop());
				
			} else if (arguments[0].equals("size")) {
				System.out.println(stackArray.size());
				
			} else if (arguments[0].equals("empty")) {
				System.out.println(stackArray.empty());
				
			} else if (arguments[0].equals("top")) {
				System.out.println(stackArray.top());
			}
			
			i++;
		}
	}
}
