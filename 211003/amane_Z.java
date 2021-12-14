import java.util.*;

class Main {
	/* 참조: https://bcp0109.tistory.com/47  */
	
	public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	int r = sc.nextInt();
    	int c = sc.nextInt();
    	
    	int size = 1;
    	for(int i = 0; i < n; i++) {
    		size *= 2;
    	}
    	
    	int cnt = 0;
    	int x = 0;
    	int y = 0;
    	
    	
    	while(size > 0) {
    		size /= 2;
    		
    		if(r < x + size && c < y + size)
    			cnt += size * size *0;
    		
    		else if(r < x + size) {
    			cnt += size * size * 1;
    			y += size;
    		}
    		
    		else if(c < y + size) {
    			cnt += size * size * 2;
    			x += size;
    		}
    		
    		else {
    			cnt += size * size * 3;
    			y += size;
    			x += size;
    		}
    		
    		if(size == 1)
    			break;
    		
    	}
    	System.out.println(cnt);
	}
}
