import java.util.*;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		// 작업에 소요된 시간(일)
		int day = 1;
		
		// 작업 완료까지 남은 시간(일)
	    	int[] remains = new int[progresses.length];
		
	    	// 작업을 언제 완료되는지를 넣을 큐
	    	Queue<Integer> q = new LinkedList<>();
		
	    	for(int i = 0; i < progresses.length; i++) {
			// (작업 완료까지 남은 양 / 작업 속도) 가 1보다 작거나 같으면 1일 안에 완료할 수 있다는 것이므로 1 대입
			if((100 - progresses[i]) / speeds[i] <= 1)
				remains[i] = 1;

			// 아니라면 작업완료까지 남은 시간 구하기
			else {
				// 작업완료까지 남은 양 / 작업 속도가 딱 나눠 떨어지면 그 시간을 대입
				if((100-progresses[i]) % speeds[i] == 0) {
					remains[i] = (100 - progresses[i])/speeds[i];
				}
				// 아니라면 하루 더 추가해서 대입
				else
					remains[i] = (int)(100 - progresses[i]) / speeds[i] + 1;

			}
	     	}

		// 첫번째 작업이 끝나지 않으면 그 뒤의 작업을 배포할 수 없으므로
		// day에 배포가능한 날짜인 remains[0] 대입
		day = remains[0];
		
		int k = 0;
		while(k < remains.length) {
			// remains[k]의 값이 day보다 작거나 같으면 day날에 배포 가능하므로
			// 배포날짜를 큐에 넣음
			if(remains[k] <= day) {
				q.offer(day);
				k++;
			}
			
			// 아니라면 배포가 불가능하므로 day + 1
			else
				day++;
		}

		// 배포를 몇개씩 하는 지 count하기 위한 배열
		int[] answer = new int[day];
		
		// 큐의 크기
		int size = q.size();

		// 큐에 저장된 날짜에 따라 count;
		for(int i = 0; i < size; i++) {
			int num = q.poll();
			answer[num-1]++;
		}

		// count한 값을 정리
		ArrayList<Integer> list = new ArrayList<>();

		// answer[i] == 0이면 배포하지 않은 날이므로 배포한 날짜만 add
		for(int i = 0; i < day; i++) {
		       if(answer[i] != 0)
				list.add(answer[i]);
		}

		// 배포한 날짜에 배포한 개수만을 저장하기 위해 다시 할당
		answer = new int[list.size()];
		
		// list값을 answer에 대입
		for(int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i).intValue();
		}
		
		return answer;
	   }
}
