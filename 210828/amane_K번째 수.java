import java.util.*;

public class Main{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		long left = 1;
		long right = k;
		long result = 0;
		
		while(left <= right) {
			long mid = (left + right) / 2;
			long cnt = 0;
			
			// mid보다 큰 수 계산
			for(int i = 1; i <= n; i++) {
				cnt += Math.min(mid / i, n);
			}
			
			if(cnt < k)
				left = mid + 1;
			else {
				result = mid;
				right = mid - 1;
			}
		}
		
		System.out.println(result);
	}
}
