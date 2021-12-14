import java.util.*;

class Main {
	
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	long x = sc.nextLong();
    	long y = sc.nextLong();
    	long diff = y - x;
    	
    	long cnt = 1;
    	
    	if(diff < 1) {
    		System.out.print(0);
    		return;
    	}
    	
    	while(true) {
    		if(cnt * cnt >= diff)
    			break;
    		cnt++;
    	}
    	
    	if(cnt * cnt - cnt >= diff) {
    		System.out.print(cnt * 2 - 2);
    		
    	} else
    		System.out.print(cnt * 2 - 1);
    	
	}
}
