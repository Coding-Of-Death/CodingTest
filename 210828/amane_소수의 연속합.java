import java.util.*;

public class Main{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		boolean[] check = new boolean[n + 1];
		ArrayList<Integer> list = new ArrayList<>();
		
		check[0] = check[1] = true;
		
		// n까지의 소수찾기
		// 소수만 false 처리
		for(int i = 2; i * i <= n; i++) {
			if(!check[i]) {
				for(int j = i * i; j <= n; j += i)
					check[j] = true;
			}
		}
		
		for(int i = 1; i <= n; i++) {
			if(!check[i])
				list.add(i);
		}
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int ans = 0;
		
		while(true) {
			if(sum >= n) {
				sum -= list.get(start);
				start++;
				
			} else if(end == list.size())
				break;
			
			else {
				sum += list.get(end);
				end++;
			}
			
			if(n == sum)
				ans++;
			
		}
		System.out.println(ans);
	}
}
