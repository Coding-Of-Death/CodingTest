import java.util.*;


public class Main {
	public static void main(String[] args) {
    // 총 게임 횟수의 2배 이상 해도 변하지 않는다면 더 이상의 계산이 의미가 없다.
    final int MAX = 1_000_000_000;
    Scanner sc = new Scanner(System.in);
	    
		long x = sc.nextLong();
		long y = sc.nextLong();
		
		int z = (int) Math.floor(y * 100.0 /x);
		
		long left  = 0;
		long right = MAX;
		
		while (left <= right) {
		    long mid = (left + right) / 2;
		    
		    int newZ = (int) Math.floor((y+mid) * 100.0 /(x+mid));
		    
		    if (newZ > z)   right = mid - 1;
		    else            left  = mid + 1;
		}
		
		System.out.println(right == MAX? -1 : right+1);
	}
}
