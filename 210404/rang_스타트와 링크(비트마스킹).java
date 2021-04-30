/*
비트 마스크란? https://www.notion.so/10c7defe6c1a449f89e8390712689956#0b26f28997804af4bd3d486bf56f1ae0

- 순열이 사용했던 방법과 유사하다.
- n이 8일때 `00001111`을 2진수로 바꾸면 15, `11110000`을 2진수로 바꾸면 240
- 15부터 240까지 반복문을 돌면서 0이 들어있는 사람은 스타트팀, 1이 들어있는 사람은 링크팀으로 넣어준다.

*/

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
		
		selectTeam(n);
		
		System.out.println(result);
	}
	
	private static void selectTeam(int n) {
		
		for(int i=(1 << (n/2 + 1)) - 1; i < (1 << n); i++){
			for (int j = 0; j < n; j++){
				if((i & (1 << j)) == 0)
					start.add(j);
				else
					link.add(j);
		  }
			
			minimizeStarkLink(n);
			
			start.clear();
			link.clear();
		}
	}
	
	private static void minimizeStarkLink(int n) {
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
	}
	
}
