import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		if(o1[0] == o2[0])
        			return o1[1] - o2[1];
        		return o1[0] - o2[0];
        			
        	}
        });
        
        for(int i = 0; i < n; i++) {
        	int num = sc.nextInt();
        	if(num != 0) {
                int[] nums;
        		if(num > 0)
        			nums = new int[] {num, 1};
        		else
        			nums = new int[] {Math.abs(num), -1};
                
                q.offer(nums);
                
        	} else {
        		if(q.isEmpty()) {
        			System.out.println(0);
                    
        		} else {
        			int[] arr = q.poll();
        			if(arr[1] == 1)
        				System.out.println(arr[0]);
        			else
        				System.out.println(arr[0] * -1);
        				
        		}
        			
        	}
        }
    }
}
