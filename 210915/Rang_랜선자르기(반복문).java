import java.util.*;


public class Main {
	static int N, K;
	static int[] LANS;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		K = sc.nextInt();
		N = sc.nextInt();
		
		LANS = new int[K];
		for (int i = 0; i < K; i++)
			LANS[i] = sc.nextInt();
		
		Arrays.sort(LANS);
		System.out.println(binarySearch(1, LANS[K-1]));
		
		sc.close();
	}
	
	static long binarySearch(long s, long e) {
		long max = 0;
		
		while (s <= e) {
			long mid = (s + e) / 2;
			int count = 0;
			
			for (int i = 0; i < K; i++) {
				if (LANS[i] >= mid) {
					count += LANS[i] / mid;
				}
			}
			
			if (count < N) {
				e = mid-1;
			} else {
				max = Math.max(max, mid);
				s = mid+1;
			}
		}
		
		return max;
	}
}
