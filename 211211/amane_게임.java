import java.util.*;

class Main {
	
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int x = sc.nextInt();
    	int y = sc.nextInt();
    	int z = getPercent(x, y);
    	
    	int left = 1;
    	int right = 1_000_000_000;
    	int answer = -1;
    	
    	while(left <= right) {
    		int mid = (left + right) / 2;
    		
    		if(getPercent(mid + x, mid + y) != z) {
    			answer = mid;
    			right = mid - 1;
    			
    		} else {
    			left = mid + 1;
    		}
    	}
    	
    	System.out.println(answer);
    	
	}
	
	static int getPercent(int x, int y) {
		int z = (int) ((long) y * 100 / x);
		return z;
	}
}
