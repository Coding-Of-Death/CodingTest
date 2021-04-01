import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int time = 0;
        int sum = 0;
        
        // 트럭의 무게합이 하중 미만인 경우
        // 다리의 길이만큼 트럭이 올라온 경우
        // 그외
        
        /*
        for (int i = 0; i < truck_weights.length; i++) {
            if (sum + truck_weights[i] <= weight) {
                if (queue.size() == bridge_length) {
                    sum -= queue.poll();
                }
                queue.offer(truck_weights[i]);
                sum += truck_weights[i];
                time++;
            } else {
                time += bridge_length - queue.size();
                sum -= queue.poll();
                i--;
            }
        }
        */
        // 실패한 코드 : 테스트 케이스는 실행되나 체점 불합격
        
        for (int w : truck_weights) {
            while (true) {
                // 큐가 비어있으면 트럭의 무게를 넣는다.
                if (queue.isEmpty()) {
                    queue.offer(w);
                    sum += w;
                    time++;
                    break;
                    
                // 트럭이 다리를 다 지났으면(큐의 크기 = 다리의 길이), 큐에서 꺼내 최대무게를 빼준다. 
                } else if (queue.size() == bridge_length) {
                    sum -= queue.poll();
                    
                } else {
                    time++;
                    // 큐가 비어있지 않고, 무게가 충분할 때 트럭의 무게를 넣는다.
                    if (sum + w > weight) {
                        queue.offer(0);
                    
                    // 큐가 비어있지 않고, 무게가 초과될 때 0을 넣는다.
                    } else {
                        queue.offer(w);
                        sum += w;
                        break;
                    }
                }
            }
        }
        
        // 마지막 트럭이 지나가는 시간을 더해주어야 한다.
        return time + bridge_length;
    }
}
