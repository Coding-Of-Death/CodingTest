import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
       int day = 1;
		int[] remains = new int[progresses.length];
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 0; i < progresses.length; i++) {
			if((100 - progresses[i]) / speeds[i] <= 1)
				remains[i] = 1;
			else {
				if((100-progresses[i]) % speeds[i] == 0) {
					remains[i] = (100 - progresses[i])/speeds[i];
				}
				else
					remains[i] = (int)(100 - progresses[i]) / speeds[i] + 1;
				
			}
		}
		
		day = remains[0];
		int k = 0;
		while(k < remains.length) {
			if(remains[k] <= day) {
				q.offer(day);
				k++;
			}
			else
				day++;
		}
        
		System.out.println(day + "일");
		
        int[] answer = new int[day];
		int size = q.size();
		
		for(int i = 0; i < size; i++) {
			int num = q.poll();
			answer[num-1]++;
		}
        
		ArrayList<Integer> list = new ArrayList<>();
		
        for(int i = 0; i < day; i++) {
			if(answer[i] != 0)
				list.add(answer[i]);
		}
		
		answer = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i).intValue();
		}
		return answer;
    }
}