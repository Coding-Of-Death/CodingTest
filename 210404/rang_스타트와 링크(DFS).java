import java.util.*;

public class Main {
	static int[][] s;
	static LinkedList<Integer> start, link;
	static int result = 10000;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		s = new int[n][n];
		
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[i].length; j++) {
				s[i][j] = scan.nextInt();
			}
		}
		
		start	= new LinkedList<>();
		link	= new LinkedList<>();
		
		minimizeStarkLink(0, n);
		
		System.out.println(result);
	}
	
	private static void minimizeStarkLink(int index, int n) {
		
		if (index == n) {
			if (start.size() == n/2 && link.size() == n/2) {
				int startSum = 0;
				int linkSum = 0;
				
				for (int i = 0; i < n/2; i++) {
					for(int j = i+1; j < n/2; j++) {
						if (i == j)
							continue;
						
						startSum += s[start.get(i)][start.get(j)] + s[start.get(j)][start.get(i)];
						linkSum  += s[link.get(i)][link.get(j)] + s[link.get(j)][link.get(i)];
					}
				}
				
				result = Math.min(result, Math.abs(startSum - linkSum));
			}
			
			return;
		}
		
		start.addLast(index);
		minimizeStarkLink(index+1, n);
		start.removeLast();
		
		link.addLast(index);
		minimizeStarkLink(index+1, n);
		link.removeLast();
		
	}
	
}
