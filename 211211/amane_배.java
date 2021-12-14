import java.util.*;

class Main {
	static int[] dx = {0, 0, -1, 1};
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	List<Integer> list = new ArrayList<Integer>();
    	
    	for(int i = 0; i < n; i++) {
    		list.add(sc.nextInt());
    	}
    	Collections.sort(list, Collections.reverseOrder());
    	
    	int box = sc.nextInt();
    	List<Integer> boxes = new ArrayList<Integer>();
    	
    	for(int i = 0; i < box; i++) {
    		boxes.add(sc.nextInt());
    	}
    	
    	Collections.sort(boxes, Collections.reverseOrder());
    	
    	if(list.get(0) < boxes.get(0))
    		System.out.println(-1);
    	
    	else {
    		int time = 0;
    		while(!boxes.isEmpty()) {
    			int idx = 0;
    			int i = 0;
    			while(i < list.size()) {
    				if(idx == boxes.size())
    					break;
    				
    				else if(list.get(i) >= boxes.get(idx)) {
    					boxes.remove(idx);
    					i++;
    				}
    				else
    					idx++;
    			}
    			time++;
    		}
    		System.out.println(time);
    	}
	}
}
